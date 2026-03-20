package Service;

import Model.Community;
import Model.Post;
import Model.Reward;
import Model.User;

import java.util.*;

public class CommunityService {
    private final HashMap<Integer, Community> community = new HashMap<>();
    private int CommunityID = 1;
    private int PostID = 1;

    public boolean existOrNot(int communityID) {
        return community.containsKey(communityID);
    }

    public int createCommunity(String communityName, String description, User user) {
        Community community1 = new Community(CommunityID++, communityName, user.getUsername(), user, description);
        community.put(community1.getCommunityID(), community1);
        user.getCommunities().add(community1);
        return community1.getCommunityID();
    }

    public List<Community> viewMyCommunities(User user) {
        List<Community> myCommunities = new ArrayList<>();
        for(int i : community.keySet()) {
            if(community.get(i).getUsers().contains(user)) {
                myCommunities.add(community.get(i));
            }
        }
        return myCommunities;
    }

    public boolean joinCommunity(int communityID, User user) {
        Community community1 = community.get(communityID);
        if (community1.getUsers().contains(user)) {
            return true;
        }
        community1.getUsers().add(user);
        user.getCommunities().add(community1);
        return false;
    }

    public void leaveCommunity(int communityID, User user) {
        Community community1 = community.get(communityID);
        if(community1 == null) {
            return;
        }
        if(community1.getAdminID().equals(user.getUsername())) {
            community.remove(communityID,community1);
            System.out.println("The Entire community has been deleted!");
        }
        community1.getUsers().removeIf(u -> u.getUsername().equals(user.getUsername()));
    }

    public boolean createPost(User user, String content, int communityID) {
        Community community1 = community.get(communityID);
        if(community1 == null) {
            return false;
        }
        Post post = new Post(PostID++, user.getUsername(), community1, content);
        community1.getPosts().add(post);
        return true;
    }

    public List<Community> viewAllCommunities() {
        return new ArrayList<>(community.values());
    }

    public Community communityUsers(int communityID, User user) {
       for(int i : community.keySet()) {
           if(community.get(i).getUsers().contains(user) && i == communityID) {
               return community.get(i);
           }
       }
       return null;
    }

    public boolean createPostForReward(User user, Reward reward, String content, int communityID) {
        Community community1 = community.get(communityID);
        if(community1 == null) {
            return false;
        }
        Post post = new Post(PostID++, user.getUsername(), community1, content, reward);
        community1.getPosts().add(post);
        return true;
    }
}
