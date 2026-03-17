package Model;

public class Habit {
    private int habitID;
    private String username;
    private String habitName;
    private String frequency;
    private boolean completionStatus;
    private int streak;
    private int totaldays;

    public Habit(String userID, int habitID, String habitName, String frequency) {
        this.habitID = habitID;
        this.username = userID;
        this.habitName = habitName;
        this.frequency = frequency;
        this.completionStatus = false;
    }

    public Habit(int streak, int totaldays) {
        this.streak = streak;
        this.totaldays = totaldays;
    }

    public int getHabitID() {
        return habitID;
    }

    public void setHabitID(int habitID) {
        this.habitID = habitID;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userID) {
        this.username = userID;
    }

    public String getHabitName() {
        return habitName;
    }

    public void setHabitName(String habitName) {
        this.habitName = habitName;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public boolean isCompletionStatus() {
        return completionStatus;
    }

    public void setCompletionStatus(boolean completionStatus) {
        this.completionStatus = completionStatus;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getStreak() {
        return streak;
    }

    public void setStreak(int streak) {
        this.streak = streak;
    }

    public int getTotaldays() {
        return totaldays;
    }

    public void setTotaldays(int totaldays) {
        this.totaldays = totaldays;
    }

    @Override
    public String toString() {
        return "{" +  "Habit = " + habitName + '\'' +
                ", frequency = " + frequency + '\'' +
                ", completion Status = " + completionStatus +
                '}';
    }
}
