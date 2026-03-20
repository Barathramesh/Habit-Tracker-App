package Model;

import java.util.*;

public class Community {
    private int CommunityID;
    private String CommunityName;
    private String AdminID;
    private HashSet<User> Users;
    private List<Post> Posts;

    public Community(int communityID, String communityName, String adminID, User user) {
        this.CommunityID = communityID;
        this.CommunityName = communityName;
        this.AdminID = adminID;
        this.Users = new HashSet<>();
        this.Posts = new ArrayList<>();
        this.Users.add(user);
    }


    public HashSet<User> getUsers() {
        return Users;
    }

    public List<Post> getPosts() {
        return Posts;
    }

    @Override
    public String toString() {
        return "Community{" +
                "Community ID = " + CommunityID +
                ", Community Name = '" + CommunityName + '\'' +
                ", Admin Name = '" + AdminID + '\'' +
                '}';
    }
}
