package Controller;

import Model.Post;
import Model.User;
import Service.CommunityService;

import java.util.*;

public class PostController {
    private final Scanner scan;
    private final CommunityService communityService;
    
    public PostController(Scanner scan, CommunityService communityService) {
        this.scan = scan;
        this.communityService = communityService;
    }

    public void PostMenu(User user) {
        String community;
        while(true) {
            System.out.println("Enter community to perform Post Operation:");
            community =  scan.nextLine();

            if(!communityService.existOrNot(community)) {
                System.out.println("Community does not exist");
            } else {
                break;
            }
        }

        while (true) {
            System.out.println("1. Create a Post:");
            System.out.println("2. View a Post:");
            System.out.println("3. Back to Main Menu:");

            int choice = Integer.parseInt(scan.nextLine());
            switch (choice) {
                case 1:
                    createPost(user, community);
                    break;
                case 2:
                    viewPost(user, community);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

        }
    }

    private void viewPost(User user, String community) {
        List<Post> mypost = communityService.getAllPost(user,community);
        for (Post post : mypost) {
            System.out.println(post);
        }
    }

    private void createPost(User user, String community) {
        System.out.println("Enter your content (type END to finish):");
        StringBuilder sb = new StringBuilder();

        while(true) {
            String line = scan.nextLine();
            if (line.equalsIgnoreCase("END")) {
                break;
            }
            sb.append(line).append(". ");
        }
            String content = sb.toString();


        boolean created = communityService.createPost(user, content, community);
        if(created) {
            System.out.println("Post created and shared in the community successfully.");
            return;
        }

        System.out.println("Community not found. Try again.");
    }
}
