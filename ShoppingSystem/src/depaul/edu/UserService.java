package depaul.edu;

public interface UserService {
    User register(String username, String password);
    User login(String username, String password);
}

