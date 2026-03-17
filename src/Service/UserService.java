package Service;

import Model.User;
import java.util.*;

public class UserService {
    private final HashMap<String, User> users = new HashMap<>();

    public boolean existOrNot(String username) {
        return users.containsKey(username);
    }

    public void register(String username, String password, String mobileNumber) {
        User newuser = new User(username, password, mobileNumber);
        users.put(username, newuser);
    }

    public User login(String username, String password) {
        User user = users.get(username);
        if(user != null && user.getPassword().equals(password)) {
                return user;
        }
        return null;
    }
}
