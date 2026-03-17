package Model;

import java.util.*;

public class User {
    private String username;
    private String password;
    private String phone;
    private int points = 0;
    private HashSet<Community> communities;

    public User(String username, String password, String phone) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.communities = new HashSet<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public HashSet<Community> getCommunities() {
        return communities;
    }

    public void setCommunities(HashSet<Community> communities) {
        this.communities = communities;
    }

    @Override
    public String toString() {
        return username;
    }
}
