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


    public int getCommunityID() {
        return CommunityID;
    }

    public void setCommunityID(int communityID) {
        CommunityID = communityID;
    }

    public String getCommunityName() {
        return CommunityName;
    }

    public void setCommunityName(String communityName) {
        CommunityName = communityName;
    }

    public String getAdminID() {
        return AdminID;
    }

    public void setAdminID(String adminID) {
        AdminID = adminID;
    }

    public HashSet<User> getUsers() {
        return Users;
    }

    public void setUsers(HashSet<User> users) {
        Users = users;
    }

    public List<Post> getPosts() {
        return Posts;
    }

    public void setPosts(List<Post> posts) {
        Posts = posts;
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
