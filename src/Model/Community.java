package Model;

import java.util.*;

public class Community {
    private int CommunityID;
    private String CommunityName;
    private String AdminID;
    private List<User> Users;
    private List<Post> Posts;

    public Community(int communityID, String communityName, String adminID, User user) {
        CommunityID = communityID;
        CommunityName = communityName;
        AdminID = adminID;
        this.Users = new ArrayList<>();
        this.Posts = new ArrayList<>();
        this.Users.add(user);
        this.AdminID = adminID;
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

    public List<User> getUsers() {
        return Users;
    }

    public void setUsers(List<User> users) {
        Users = users;
    }

    public List<Post> getPosts() {
        return Posts;
    }

    public void setPosts(List<Post> posts) {
        Posts = posts;
    }
}
