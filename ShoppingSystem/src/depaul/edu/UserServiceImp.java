package depaul.edu;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImp implements UserService {
    private Map<String, User> users = new HashMap<>();

    @Override
    public User register(String username, String password) {
        if (users.containsKey(username)) {
            throw new IllegalArgumentException("User already exists.");
        }
        User user = new User(username, password);
        users.put(username, user);
        return user;
    }

    @Override
    public User login(String username, String password) {
        if (!users.containsKey(username)) {
            throw new IllegalArgumentException("User does not exist.");
        }
        User user = users.get(username);
        if (!user.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid password.");
        }
        return user;
    }
}

