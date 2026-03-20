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

    public Reward(int rewardID, String rewardName, String username, int points, String rewardType, String description) {
        this.rewardID = rewardID;
        this.rewardName = rewardName;
        this.username = username;
        this.points = points;
        this.awardedAt = LocalDate.now();
        this.rewardType = rewardType;
        this.description = description;
    }

    public int getRewardID() {
        return rewardID;
    }

    public void setRewardID(int rewardID) {
        this.rewardID = rewardID;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getRewardType() {
        return rewardType;
    }

    public void setRewardType(String rewardType) {
        this.rewardType = rewardType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getAwardedAt() {
        return awardedAt;
    }

    public void setAwardedAt(LocalDate awardedAt) {
        this.awardedAt = awardedAt;
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