package Controller;

import Model.Reward;
import Model.User;
import Service.CommunityService;
import Service.RewardService;

import java.util.*;

public class PostController {
    private final Scanner scan;
    private final CommunityService communityService;
    private final RewardService rewardService;
    
    public PostController(Scanner scan, CommunityService communityService, RewardService rewardService) {
        this.scan = scan;
        this.communityService = communityService;
        this.rewardService = rewardService;
    }

    public void PostMenu(User user) {
        int communityID;
        while (true) {
            System.out.println("Enter Community ID to perform post operations:");
            communityID = Integer.parseInt(scan.nextLine());
            if(!communityService.existOrNot(communityID)) {
                System.out.println("Community ID does not exist");
            } else {
                break;
            }
        }
        System.out.println();
        while(true) {
            System.out.println("1. Create a Post:");
            System.out.println("2. Reward into Post:");
            System.out.println("3. Back to main menu:");

            int choice = Integer.parseInt(scan.nextLine());
            switch(choice) {
                case 1:
                    createPost(user, communityID);
                    break;
                case 2:
                    convertRewardIntoPost(user, communityID);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    private void convertRewardIntoPost(User user, int communityID) {
        List<Reward> myrewards = rewardService.getRewardsByUser(user);
        for(Reward reward : myrewards) {
            System.out.println(reward);
        }

        int rewardID = Integer.parseInt(scan.nextLine());
        Reward reward = rewardService.findRewardById(user, rewardID);
        if(reward != null) {
            System.out.println("Would you like to add something into the post please enter your content (type END to finish):");
            StringBuilder sb = new StringBuilder();

            while (true) {
                String line = scan.nextLine();
                if (line.equalsIgnoreCase("END")) {
                    break;
                }
                sb.append(line).append(". ");
            }
            String content = sb.toString();

            boolean created = communityService.createPostForReward(user, reward, content, communityID);
            if (created) {
                System.out.println("Post created and shared in the community successfully.");
            } else {
                System.out.println("Post could not be created.");
            }
        }else{
            System.out.println("Invalid reward Id");
        }

    }


    public void createPost(User user, int communityID) {
        System.out.println("Enter your content (type END to finish):");
        StringBuilder sb = new StringBuilder();

        while(true) {
            String line = scan.nextLine();
            if(line.equalsIgnoreCase("END")) {
                break;
            }
            sb.append(line).append(". ");
        }
        String content = sb.toString();
        boolean created = communityService.createPost(user, content, communityID);
        if (created) {
            System.out.println("Post created and shared in the community successfully.");
        } else {
            System.out.println("Post could not be created.");
        }
    }
}
