package depaul.edu;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserServiceImp(); // Initialize the user service
        User newUser = userService.register("admin", "admin"); // Create an admin user
        ProductFactory productFactory = new ProductFactory();
        ProductCatalog catalog = new ProductCatalog(productFactory);
        catalog.loadProductsFromCsv("small_product_data.csv");
        
        Logger logger = new MemoryLogger(); // Initialize the logger

        System.out.println("Welcome to the Shopping System!\n");

        while (true) {
            System.out.println("Login please enter 'L'");
            System.out.println("Create an account please enter 'C'");
            System.out.println("Exit please enter 'Exit'");
            System.out.print("Please enter your choice: ");
            String action = scanner.nextLine();

            if ("Exit".equalsIgnoreCase(action)) {
                break; 
            }

            switch (action.toUpperCase()) {
                case "L": // Login
                    System.out.print("\nEnter username: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();
                    System.out.println("Logging in...");
                    
                    try {

                        
                        User user = userService.login(loginUsername, loginPassword);
                        System.out.println("Login successful! Welcome back, " + user.getUsername());
                        // record the login event
                        logger.log("User " + user.getUsername() + " logged in");

                        if (user.getUsername().equals("admin")) { // Check if the user is an admin
                            Boolean sessionActive = true;
                            while (sessionActive) {
                                System.out.println("\nAdmin Options:");
                                System.out.println("1. View Logs");
                                System.out.println("2. Logout");
                                System.out.print("Enter your choice: ");
                                int adminChoice = scanner.nextInt();
                                scanner.nextLine(); // Consume newline left-over
                    
                                switch (adminChoice) {
                                    case 1: // View Logs
                                        logger.getLogMessages().forEach(System.out::println);
                                        break;
                                    case 2: // Logout
                                        System.out.println("Logging out...");
                                        sessionActive = false;
                                        logger.log("User " + user.getUsername() + " logged out");
                                        break; 
                                    default:
                                        System.out.println("Invalid option. Please try again.");
                                        break;
                                }
                            }
                        }else{
                            boolean sessionActive = true;
                            while (sessionActive) {
                                System.out.println("\nWhat would you like to do?");
                                System.out.println("1. View Products");
                                System.out.println("2. View Cart");
                                System.out.println("3. Add Product to Cart");
                                System.out.println("4. Remove Product from Cart");
                                System.out.println("5. Checkout and Pay");
                                System.out.println("6. Logout");
                                System.out.print("Enter your choice: ");
                                int choice = scanner.nextInt();
                                scanner.nextLine();

                                switch (choice) {
                                    case 1: // View Products
                                        System.out.println("Available Products:");
                                        catalog.getAllProducts().forEach(product -> System.out.println(product.toString()));
                                        break;
                                    case 2: // View Cart
                                        System.out.println("Your Cart:");
                                        user.getCart().getItems().forEach((product, quantity) -> System.out.println(product + ", Quantity: " + quantity));
                                        System.out.println("Total Amount: $" + user.getCart().getTotalAmount());
                                        break;
                                    case 3: // Add Product to Cart
                                        System.out.print("Enter Product ID: ");
                                        String productId = scanner.nextLine();
                                        System.out.print("Enter Quantity: ");
                                        int quantity = scanner.nextInt();
                                        scanner.nextLine();
                                        Product productToAdd = catalog.getAllProducts().stream()
                                            .filter(p -> p.getId().equals(productId))
                                            .findFirst()
                                            .orElse(null);
                                        if (productToAdd != null) {
                                            user.getCart().addItem(productToAdd, quantity);
                                            System.out.println("Product added to cart.");
                                        } else {
                                            System.out.println("Product not found.");
                                        }
                                        break;
                                    case 4: // Remove Product from Cart
                                        System.out.print("Enter Product ID to remove: ");
                                        String removeProductId = scanner.nextLine();
                                        Product productToRemove = user.getCart().getItems().keySet().stream()
                                            .filter(p -> p.getId().equals(removeProductId))
                                            .findFirst()
                                            .orElse(null);
                                        if (productToRemove != null) {
                                            user.getCart().removeItem(productToRemove);
                                            System.out.println("Product removed from cart.");
                                        } else {
                                            System.out.println("Product not found in cart.");
                                        }
                                        break;
                                    case 6: // Logout
                                        System.out.println("Logging out...");
                                        // record the logout event
                                        logger.log("User " + user.getUsername() + " logged out");
                                        sessionActive = false;
                                        break;

                                    case 5: // Checkout and Pay
                                        double totalAmount = user.getCart().getTotalAmount();
                                        System.out.println("Your total amount is $" + totalAmount);
                                        System.out.print("Enter your card number: ");
                                        String cardNumber = scanner.nextLine();
                                        System.out.print("Enter your CVV: ");
                                        String cvv = scanner.nextLine();
                                        System.out.print("Enter Expired Date: ");
                                        String expiredDate = scanner.nextLine();
                                        System.out.println("Proceeding to payment...");
                                    
                                        PaymentGateway paymentGateway = new MockPaymentGateway();
                                        if (paymentGateway.processPayment(user, totalAmount, cardNumber, cvv, expiredDate)) {
                                            System.out.println("Payment successful!");
                                            // record the payment event
                                            logger.log("User " + user.getUsername() + " paid $" + totalAmount);
                                            user.clearCart(); // Clear the cart after successful payment
                                            System.out.println("Your cart is now empty.");
                                        } else {
                                            System.out.println("Payment failed. Please try again later.");
                                            logger.log("User " + user.getUsername() + " payment failed");
                                        }
                                        break;
                                    
                                }
                            }
                        }



                    } catch (IllegalArgumentException e) {
                        System.out.println("Login failed: " + e.getMessage() + ". Please try again.\n");
                    }
                    break;

                case "C": // Create Account
                    System.out.print("\nChoose a username:");
                    String newUsername = scanner.nextLine();
                    System.out.print("Choose a password:");
                    String newPassword = scanner.nextLine();

                    try {
                        User newUser2 = userService.register(newUsername, newPassword);
                        System.out.println("Creating account...");
                        System.out.println("Account created successfully! Welcome, " + newUser2.getUsername());
                        // record the account creation event
                        logger.log("User " + newUser2.getUsername() + " created an account");
                        System.out.println();


                    } catch (IllegalArgumentException e) {
                        System.out.println("Account creation failed: " + e.getMessage() + ". Please try again.\n");
                    }
                    break;

                default:
                    System.out.println("Invalid option. Please choose either 'L' for Login or 'C' for Create an Account or 'Exit' for quit .");
                    break;
            }
        }

        scanner.close();
        System.out.println("Thank you for using the Shopping System!");
    }
}

