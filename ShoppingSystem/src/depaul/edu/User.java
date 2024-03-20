package depaul.edu;

public class User {
    private String username;
    private String password;
    private ShoppingCart cart;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.cart = new ShoppingCart();
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void clearCart() {
        this.cart = new ShoppingCart(); // Reset the cart
    }
}

