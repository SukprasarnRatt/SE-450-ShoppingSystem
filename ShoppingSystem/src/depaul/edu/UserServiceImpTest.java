package depaul.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceImpTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImp();
    }

    @Test
    void testRegisterAndLogin() {
        User registeredUser = userService.register("testUser", "password123");
        assertNotNull(registeredUser);
        assertEquals("testUser", registeredUser.getUsername());

        User loggedInUser = userService.login("testUser", "password123");
        assertNotNull(loggedInUser);
        assertEquals("testUser", loggedInUser.getUsername());
    }

    @Test
    void testRegisterExistingUser() {
        userService.register("testUser", "password123");
        assertThrows(IllegalArgumentException.class, () -> userService.register("testUser", "password123"));
    }

    @Test
    void testLoginNonExistingUser() {
        assertThrows(IllegalArgumentException.class, () -> userService.login("nonUser", "password"));
    }

    @Test
    void testLoginWithWrongPassword() {
        userService.register("testUser", "password123");
        assertThrows(IllegalArgumentException.class, () -> userService.login("testUser", "wrongPassword"));
    }
}

