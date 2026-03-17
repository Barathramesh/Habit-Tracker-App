package Controller;

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

    public void createPost(User user) {
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

        while(true) {
            System.out.println("Enter community to share your post: ");
            String community = scan.nextLine();
            boolean created = communityService.createPost(user, content, community);
            if(created) {
                System.out.println("Post created and shared in the community successfully.");
                return;
            }

            System.out.println("Community not found. Try again.");
        }

    }
}
