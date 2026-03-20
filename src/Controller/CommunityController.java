package Controller;

import Model.Community;
import Model.Post;
import Model.User;
import Service.CommunityService;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

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
            System.out.println("3. View a Community:");
            System.out.println("4. Leave a Community:");
            System.out.println("5. Back to Main Menu.");

            int choice = Integer.parseInt(scan.nextLine());

            switch (choice) {
                case 1:
                    createCommunity(user);
                    break;
                case 2:
                    joinCommunity(user);
                    break;
                case 3:
                    viewCommunity();
                    break;
                case 4:
                    leaveCommunity(user);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }

    public void createCommunity(User user) {
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

    public void joinCommunity(User user) {
        while(true) {
            System.out.println("Enter the name of the community: ");
            String name = scan.nextLine();
            if(!communityService.existOrNot(name)) {
                System.out.println("Community doesn't exists!");
            } else {
                List<User> users = communityService.joinCommunity(name,user);
                System.out.println("You have joined the community successfully!");
                System.out.println(users);
                return;
            }
        }
    }

    public void leaveCommunity(User user) {
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

    public void viewCommunity() {
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
