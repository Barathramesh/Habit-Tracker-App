package Model;

import java.time.LocalDate;
import java.util.*;

public class User {
    private String username;
    private String password;
    private String phone;
    private int points = 0;
    private int loginStreak = 0;
    private LocalDate lastLoginDate;
    private int totalHabitsCompleted = 0;
    private HashSet<Community> communities;

    public User(String username, String password, String phone) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.communities = new HashSet<>();
        this.loginStreak = 0;
        this.lastLoginDate = null;
        this.totalHabitsCompleted = 0;
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

    public int getLoginStreak() {
        return loginStreak;
    }

    public void setLoginStreak(int loginStreak) {
        this.loginStreak = loginStreak;
    }

    public LocalDate getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(LocalDate lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public int getTotalHabitsCompleted() {
        return totalHabitsCompleted;
    }

    public void setTotalHabitsCompleted(int totalHabitsCompleted) {
        this.totalHabitsCompleted = totalHabitsCompleted;
    }


    @Override
    public String toString() {
        return username;
    }
}
