package Controller;


import Model.Community;
import Model.Post;
import Model.User;
import Service.CommunityService;

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
            System.out.println("2. View a Community:");
            System.out.println("3. Join a Community:");
            System.out.println("4. View My Communities:");
            System.out.println("5. Leave a Community:");
            System.out.println("6. Back to Main Menu.");

            int choice = Integer.parseInt(scan.nextLine());

            switch (choice) {
                case 1:
                    createCommunity(user);
                    break;
                case 2:
                    viewACommunity(user);
                    break;
                case 3:
                    joinCommunity(user);
                    break;
                case 4:
                    viewMyCommunities(user);
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

    private void viewACommunity(User user) {
        while(true) {
            System.out.println("Enter Community ID:");
            int communityID = Integer.parseInt(scan.nextLine());

            if(!communityService.existOrNot(communityID)) {
                System.out.println("Invalid Community ID!");
            } else {
                Community currentCommunity = communityService.communityUsers(communityID, user);

                if(currentCommunity != null) {
                    System.out.println("List of Users:");
                    for (User u : currentCommunity.getUsers()) {
                        System.out.print(u.getUsername() + " ");
                    }
                    System.out.println();
                    System.out.println("List of Posts:");
                    if (currentCommunity.getPosts().isEmpty()) {
                        System.out.println("No posts yet.");
                    } else {
                        for (Post p : currentCommunity.getPosts()) {
                            System.out.println(p);
                        }
                    }
                    return;
                } else {
                    System.out.println("Your are not able to see this community until you join this community.");
                }
            }
        }
    }

    private void viewAllCommunities() {
        List<Community> allCommunities = communityService.viewAllCommunities();
        for (Community community : allCommunities) {
            System.out.println("Community ID: " + community.getCommunityID()+"      "+
                    "Community Admin: "+ community.getAdminID());
            System.out.println("Community Name: " + community.getCommunityName()+"      "+
                    "Community Description: " + community.getDescription());
            System.out.println();
        }
    }

    public void createCommunity(User user) {
        System.out.println("Enter the name of the community: ");
        String name = scan.nextLine();
        System.out.println("Enter the description of the community: ");
        String description = scan.nextLine();

        int id = communityService.createCommunity(name, description, user);
        System.out.println("Community has been created successfully.!");
        System.out.println("Your Community ID is: " + id);
    }


    public void joinCommunity(User user) {
        viewAllCommunities();
        while (true) {
            System.out.println("Enter the Community ID: ");
            int id = Integer.parseInt(scan.nextLine());
            if (!communityService.existOrNot(id)) {
                System.out.println("Community doesn't exists with this ID!");
            } else {
                if(communityService.joinCommunity(id, user)) {
                    System.out.println("You are already in this community!");
                    return;
                } else {
                    System.out.println("You have joined the community successfully!");
                    return;
                }
            }
        }
    }

    public void leaveCommunity(User user) {
        while (true) {
            System.out.println("Enter the Community ID: ");
            int id = Integer.parseInt(scan.nextLine());
            if (!communityService.existOrNot(id)) {
                System.out.println("Community doesn't exists!");
            } else {
                communityService.leaveCommunity(id, user);
                System.out.println("You have left the community successfully!");
                return;
            }
        }
    }

    public void viewMyCommunities(User user) {
        List<Community> myCommunities = communityService.viewMyCommunities(user);

        if (myCommunities.isEmpty()) {
            System.out.println("No communities available.");
            return;
        }

        for (Community c : myCommunities) {
            System.out.println("Community ID: " + c.getCommunityID()+"      "+
                    "Community Admin: "+ c.getAdminID());
            System.out.println("Community Name: " + c.getCommunityName()+"      "+
                    "Community Description: " + c.getDescription());
            System.out.println();
        }
    }
}