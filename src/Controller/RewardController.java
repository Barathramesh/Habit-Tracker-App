package Controller;

import Model.User;
import Service.RewardService;

import java.util.Scanner;

public class RewardController {
    private final Scanner scan;
    private final RewardService rewardService =  new RewardService();
    
    public RewardController(Scanner scan) {
        this.scan = scan;
    }

    public void createReward(User user) {
    }
}
