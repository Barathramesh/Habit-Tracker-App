package Model;

import java.time.LocalDate;
import java.util.*;

public class User {
    private String username;
    private String password;
    private String phone;
    private int points = 0;
    private int loginStreak = 0;
    private LocalDate lastLoginDate;
    private int totalHabitsCompleted = 0;
    private HashSet<Community> communities;
    private final HashSet<Journal> journals;
    private final List<Reward> rewards;
    private final List<Habit> habits;

    public User(String username, String password, String phone) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.communities = new HashSet<>();
        this.journals = new HashSet<>();
        this.rewards = new ArrayList<>();
        this.habits = new ArrayList<>();
        this.loginStreak = 0;
        this.lastLoginDate = null;
        this.totalHabitsCompleted = 0;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public HashSet<Community> getCommunities() {
        return communities;
    }

    public int getTotalHabitsCompleted() {
        return totalHabitsCompleted;
    }

    public void setTotalHabitsCompleted(int totalHabitsCompleted) {
        this.totalHabitsCompleted = totalHabitsCompleted;
    }

    public HashSet<Journal> getJournals() {
        return journals;
    }

    public void setJournals(Journal journal) {
        journals.add(journal);
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public void setRewards(Reward reward) {
        rewards.add(reward);
    }

    public List<Habit> getHabits() {
        return habits;
    }

    public void addHabit(Habit habit) {
        habits.add(habit);
    }

    @Override
    public String toString() {
        return username;
    }
}
