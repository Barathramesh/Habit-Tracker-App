package Controller;

import Model.Community;
import Model.Post;
import Model.User;
import Service.CommunityService;

import java.util.*;

public class CommunityController {
    private final Scanner scan;
    private final CommunityService communityService;

    public CommunityController(Scanner scan, CommunityService communityService) {
        this.scan = scan;
        this.communityService = communityService;
    }

    public void CommunityMenu(User user) {
        while (true) {
            System.out.println();
            System.out.println("1. Create a Community:");
            System.out.println("2. Join a Community:");
            System.out.println("3. Show All Communities:");
            System.out.println("4. View a Community:");
            System.out.println("5. Leave a Community:");
            System.out.println("6. Back to Main Menu.");

            int choice = Integer.parseInt(scan.nextLine());

            switch (choice) {
                case 1:
                    createCommunity(user);
                    break;
                case 2:
                    joinCommunity(user);
                    break;
                case 3:
                    showAllCommunities(user);
                    break;
                case 4:
                    viewCommunity();
                    break;
                case 5:
                    leaveCommunity(user);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }

    private void showAllCommunities(User user) {
        HashSet<Community> mycommunities = user.getCommunities();
        for (Community community : mycommunities) {
            System.out.println(community);
        }
    }

    private void createCommunity(User user) {
        while(true) {
            System.out.println("Enter the name of the community: ");
            String name = scan.nextLine();

            if(communityService.existOrNot(name)) {
                 System.out.println("Community already exists!");
            } else {
                communityService.createCommunity(name,user);
                System.out.println("Community has been created successfully!");
                return;
            }
        }

    }

    private void joinCommunity(User user) {
        while(true) {
            System.out.println("Enter the name of the community: ");
            String name = scan.nextLine();
            if(!communityService.existOrNot(name)) {
                System.out.println("Community doesn't exists!");
            } else {
                if(!communityService.joinCommunity(name,user)) {
                    System.out.println("You have joined the community successfully!");
                } else {
                    
                }
            }
        }
    }

    private void leaveCommunity(User user) {
        while(true) {
            System.out.println("Enter the name of the community: ");
            String name = scan.nextLine();
            if(!communityService.existOrNot(name)) {
                System.out.println("Community doesn't exists!");
            } else {
                communityService.leaveCommunity(name,user);
                System.out.println("You have left the community successfully!");
                return;
            }
        }
    }

    private void viewCommunity() {
        while(true) {
            System.out.println("Enter the name of the community: ");
            String name = scan.nextLine();
            if(!communityService.existOrNot(name)) {
                System.out.println("Community doesn't exists!");
            } else {
                Community chats = communityService.viewCommunity(name);
                 HashSet<User> users = chats.getUsers();
                List<Post> posts = chats.getPosts();

                System.out.println("List of users:");
                for(User user : users) {
                    System.out.println(user.getUsername());
                }

                System.out.println("List of posts:");
                if(posts.isEmpty()) {
                    System.out.println("No posts in this community yet.");
                } else {
                    for(Post post : posts) {
                        System.out.println(post);
                    }
                }
                return;

            }
        }
    }
}
