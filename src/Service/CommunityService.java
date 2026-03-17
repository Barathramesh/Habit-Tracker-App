package Service;

import Model.Community;
import Model.Post;
import Model.User;

import java.util.*;

public class CommunityService {
    private final HashMap<String, Community> community = new HashMap<>();
    private int CommunityID = 1;
    private int PostID = 1;

    public boolean existOrNot(String name) {
        return community.containsKey(name.toLowerCase());
    }

    public void createCommunity(String name, User user) {
        Community community1 = new Community(CommunityID++, name, user.getUsername(), user);
        community.put(name.toLowerCase(), community1);
        user.getCommunities().add(community1);
    }

    public Community viewCommunity(String name) {
        return community.get(name.toLowerCase());
    }

    public boolean joinCommunity(String name, User user) {
        Community community1 = community.get(name.toLowerCase());
        community1.getUsers().add(user);
        if(user.getCommunities().contains(community1)) {
            return true;
        } else {
            user.getCommunities().add(community1);
            return false;
        }
    }

    public void leaveCommunity(String name, User user) {
        Community community1 = community.get(name.toLowerCase());
        if(community1 == null) {
            return;
        }
        community1.getUsers().removeIf(u -> u.getUsername().equals(user.getUsername()));
        user.getCommunities().removeIf(c -> c.getCommunityID() == community1.getCommunityID());
    }

    public boolean createPost(User user, String content, String group) {
        Community community1 = community.get(group.toLowerCase());
        if(community1 == null) {
            return false;
        }
        Post post = new Post(PostID++, user.getUsername(), community1, content);
        community1.getPosts().add(post);
        return true;
    }

    public List<Post> getAllPost(User user, String name) {
        Community community1 = community.get(name.toLowerCase());
        return community1.getPosts();
    }
}
