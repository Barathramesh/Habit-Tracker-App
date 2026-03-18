package Service;

import Model.Habit;
import Model.Reward;
import Model.User;

import java.time.LocalDate;
import java.util.*;

public class RewardService {
    List<Reward> rewards = new ArrayList<>();
    private int rewardIDCounter = 1;

    public List<Reward> processRewards(User user, Habit habit) {
        List<Reward> newRewards = new ArrayList<>();
        newRewards.add(createReward(user, habit.getHabitName() + " Completed", 10));

        Reward streakReward = checkStreakReward(user, habit);
        if (streakReward != null) newRewards.add(streakReward);

        Reward thresholdReward = checkThresholdReward(user);
        if (thresholdReward != null) newRewards.add(thresholdReward);

        return newRewards;
    }

    private Reward createReward(User user, String title, int points) {
        Reward reward = new Reward(rewardIDCounter++, title, user.getUsername(), points);
        rewards.add(reward);
        user.setPoints(user.getPoints() + points);
        return reward;
    }

    private Reward checkStreakReward(User user, Habit habit) {
        int streak = habit.getStreak();

        if ((streak == 7 || streak == 14 || streak == 21 || streak == 30) &&
                !LocalDate.now().equals(habit.getLastRewardDate())) {

            int points = getStreakPoints(streak);
            habit.setLastRewardDate(LocalDate.now());

            return createReward(user, streak + " Day Streak - " + habit.getHabitName(), points);
        }
        return null;
    }

    private Reward checkThresholdReward(User user) {
        int completed = user.getTotalHabitsCompleted();

        if (completed == 5 || completed == 10 || completed == 20 || completed == 50) {
            int points = getThresholdPoints(completed);
            return createReward(user,"Completed " + completed + " Habits", points);
        }
        return null;
    }

    private int getStreakPoints(int streak) {
        return switch (streak) {
            case 7 -> 25;  case 14 -> 50;
            case 21 -> 75; case 30 -> 100;
            default -> 0;
        };
    }

    private int getThresholdPoints(int count) {
        return switch (count) {
            case 5 -> 30;  case 10 -> 75;
            case 20 -> 150; case 50 -> 300;
            default -> 0;
        };
    }

    public List<Reward> getRewardsByUser(String username) {
        List<Reward> userRewards = new ArrayList<>();
        for (Reward reward : rewards) {
            if (reward.getUsername().equals(username)) {
                userRewards.add(reward);
            }
        }
        return userRewards;
    }
}
