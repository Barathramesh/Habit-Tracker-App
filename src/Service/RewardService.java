package Service;

import Model.Reward;
import Model.User;

import java.util.*;

public class RewardService {
    List<Reward> rewards = new ArrayList<>();

    public Reward generateReward(User user, String habit, int rewardID) {
        Reward reward = new Reward(rewardID,habit+" Completed",user.getUsername(), user.getPoints());
        rewards.add(reward);
        return reward;
    }
}
