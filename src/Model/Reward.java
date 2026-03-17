package Model;

import java.time.LocalDate;

public class Reward {

    private int rewardID;
    private String rewardName;
    private String username;
    private int points;
    private LocalDate awardedAt;

    public Reward(int rewardID, String rewardName, String username, int points) {
        this.rewardID = rewardID;
        this.rewardName = rewardName;
        this.username = username;
        this.points = points;
        this.awardedAt = LocalDate.now();
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

    @Override
    public String toString() {
        return "Reward: " + rewardName +
                ", Points: " + points +
                ", User: " + username +
                ", Time: " + awardedAt;
    }
}