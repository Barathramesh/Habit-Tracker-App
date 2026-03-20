package Model;

import java.time.LocalDate;

public class Reward {

    private int rewardID;
    private String rewardName;
    private String username;
    private int points;
    private LocalDate awardedAt;
    private String rewardType;
    private String description;

    public Reward(int rewardID, String rewardName, String username, int points) {
        this.rewardID = rewardID;
        this.rewardName = rewardName;
        this.username = username;
        this.points = points;
        this.awardedAt = LocalDate.now();
        this.rewardType = "HABIT_COMPLETION";
        this.description = "";
    }

    public Reward(int rewardID, String rewardName, String username, int points, String description) {
        this.rewardID = rewardID;
        this.rewardName = rewardName;
        this.username = username;
        this.points = points;
        this.awardedAt = LocalDate.now();
        this.description = description;
    }

    public int getRewardID() {
        return rewardID;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "Reward Id: "+rewardID +
                ", Reward: " + rewardName +
                ", Points: " + points +
                ", User: " + username +
                ", Time: " + awardedAt;
    }
}