package Service;

import Model.Habit;
import Model.Reward;
import Model.User;

import java.time.LocalDate;
import java.util.*;

public class RewardService {
    private final Map<String, Integer> userRewardCount = new HashMap<>();
    private int rewardIDCounter = 1;

    public List<Reward> processRewards(User user, Habit habit) {
        List<Reward> newRewards = new ArrayList<>();
        newRewards.add(createRewardForHabit(user, habit));

        Reward streakReward = checkStreakReward(user, habit);
        if (streakReward != null) newRewards.add(streakReward);

        Reward thresholdReward = checkThresholdReward(user);
        if (thresholdReward != null) newRewards.add(thresholdReward);

        return newRewards;
    }

    private Reward createRewardForHabit(User user, Habit habit) {
        int points = getFrequencyBasedPoints(habit.getFrequency());
        int id = userRewardCount.getOrDefault(user.getUsername(),0) + 1;
        userRewardCount.put(user.getUsername(), id);

        Reward reward = new Reward(id, habit.getHabitName(), user.getUsername(),points);

        user.setRewards(reward);
        user.setPoints(user.getPoints() + points);
        return reward;
    }

    private Reward checkStreakReward(User user, Habit habit) {
        int streak = habit.getStreak();

        if ((streak == 7 || streak == 14 || streak == 21 || streak == 30) &&
                !LocalDate.now().equals(habit.getLastRewardDate())) {

            int points = getStreakPoints(streak);
            habit.setLastRewardDate(LocalDate.now());

            return createReward(user, habit,streak + " Day Streak - " + habit.getHabitName(), points);
        }
        return null;
    }

    private Reward createReward(User user, Habit habit, String s, int points) {
        int id = userRewardCount.getOrDefault(user.getUsername(),90) + 1;
        userRewardCount.put(user.getUsername(), id);

        Reward reward = new Reward(id, habit.getHabitName(), user.getUsername(),points, s);

        user.setRewards(reward);
        user.setPoints(user.getPoints() + points);
        return reward;
    }

    public Reward findRewardById(User user, int rewardID) {
        List<Reward> userrewards = user.getRewards();
        for (Reward reward : userrewards) {
            if (reward.getRewardID() == rewardID) {
                return reward;
            }
        }
        return null;
    }

    private Reward checkThresholdReward(User user) {
        int completed = user.getTotalHabitsCompleted();

        if (completed == 5 || completed == 10 || completed == 20 || completed == 50) {
            int points = getThresholdPoints(completed);
            return createRewardForSuccess(user, "Successfully Completed " + completed + " Habits", points);
        }
        return null;
    }

    private Reward createRewardForSuccess(User user, String s, int points) {
        int id = userRewardCount.getOrDefault(user.getUsername(),90) + 1;
        userRewardCount.put(user.getUsername(), id);

        Reward reward = new Reward(id,"Completion of Habits", user.getUsername(), points, s);

        user.setRewards(reward);
        user.setPoints(user.getPoints() + points);
        return reward;
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

    private int getFrequencyBasedPoints(String frequency) {
        return switch (frequency) {
            case "Daily" -> 50;
            case "Weekly" -> 25;
            case "Monthly" -> 10;
            default -> 0;
        };
    }

    public List<Reward> getRewardsByUser(User user) {
       return  user.getRewards();
    }
}
