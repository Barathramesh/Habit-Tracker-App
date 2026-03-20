package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Habit {
    private int habitID;
    private String username;
    private String habitName;
    private String frequency;
    private boolean completionStatus;
    private int streak;
    private int totaldays;
    private LocalDate lastcompletedDate;
    private LocalDate lastRewardDate;
    private List<Remainder> reminders;

    public Habit(String userID, int habitID, String habitName, String frequency) {
        this.habitID = habitID;
        this.username = userID;
        this.habitName = habitName;
        this.frequency = frequency;
        this.completionStatus = false;
        this.streak = 0;
        this.totaldays = 0;
        this.lastcompletedDate = null;
        this.lastRewardDate = null;
        reminders = new ArrayList<>();
    }

    public String getHabitName() {
        return habitName;
    }

    public String getFrequency() {
        return frequency;
    }

    public boolean isCompletionStatus() {
        return completionStatus;
    }

    public String getUsername() {
        return username;
    }

    public int getStreak() {
        return streak;
    }

    public void setStreak(int streak) {
        this.streak = streak;
    }

    public LocalDate getLastRewardDate() {
        return lastRewardDate;
    }

    public void setLastRewardDate(LocalDate lastRewardDate) {
        this.lastRewardDate = lastRewardDate;
    }

    public LocalDate getLastcompletedDate() {
        return lastcompletedDate;
    }

    public void setLastcompletedDate(LocalDate lastcompletedDate) {
        this.lastcompletedDate = lastcompletedDate;
    }

    public List<Remainder> getReminders() {
        return reminders;
    }

    public void addReminders(Remainder reminder) {
        reminders.add(reminder);
    }

    @Override
    public String toString() {
        return "Habit: " + habitName +
                ", Frequency: " + frequency +
                ", Streak: " + streak +
                ", Total: " + totaldays +
                ", Last Done: " + lastcompletedDate;
    }
}
