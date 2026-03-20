package Model;

import java.util.*;

public class Community {
    private final int CommunityID;
    private final String CommunityName;
    private final String AdminID;
    private final String description;
    private final HashSet<User> Users;
    private final List<Post> Posts;


    public Community(int communityID, String communityName, String adminID, User user,  String description) {
        this.CommunityID = communityID;
        this.CommunityName = communityName;
        this.AdminID = adminID;
        this.description = description;
        this.Users = new HashSet<>();
        this.Posts = new ArrayList<>();
        this.Users.add(user);
    }

    public HashSet<User> getUsers() {
        return Users;
    }

    public int getCommunityID() {
        return CommunityID;
    }

    public String getCommunityName() {
        return CommunityName;
    }

    public String getAdminID() {
        return AdminID;
    }

    public String getDescription() {
        return description;
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
