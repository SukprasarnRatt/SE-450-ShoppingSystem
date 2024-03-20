# Se-450-ShoppingSystem

This project is a Java-based simplified shopping system designed to demonstrate the application of fundamental software engineering principles and design patterns.

## Navigating the Application

Upon running the application, you will be greeted with a console-based menu that allows you to:

- **Login:** Existing users can log in by entering their username and password.
- **Register:** New users can create an account by choosing a username and password.
- **Browse Products:** Once logged in, users can browse the available products in the product catalog.
- **Manage Shopping Cart:** Users can add products to their shopping cart, view the cart, modify product quantities, or remove products.
- **Checkout and Pay:** Users can proceed to checkout, where they will enter payment information to simulate a payment process.
- **View Logs (Admin only):** Users with admin privileges can view application logs.

### Exiting the Application

You can exit the application at any time by choosing the exit option from the main menu.

## How It Works

### Architecture

The Shopping System is built using Java and follows object-oriented principles to structure the application into manageable components, each responsible for a distinct aspect of the application:

- **User Authentication:** Handles user registration and login, ensuring that shopping cart data is associated with individual user accounts.
- **Product Catalog:** A collection of products that users can browse. The catalog can be populated from a static data file or a database.
- **Shopping Cart Management:** Allows users to add items to a shopping cart, modify item quantities, or remove items.
- **Order Processing:** Uses design patterns like Singleton and Factory to manage the lifecycle of a shopping cart and the creation of product instances.
- **Mock Payment Processing:** Simulates the payment process, abstracted from the core shopping functionality to mimic real-world payment gateways.
- **Logging:** A simple logging mechanism records key events and transactions, offering insights into application usage and operations.

### Design Patterns

This project utilizes several design patterns to enhance its design and maintainability:

- **Singleton:** Ensures a class has only one instance and provides a global point of access to it. Used for managing the shopping cart.
- **Factory:** Defines an interface for creating an object but lets subclasses alter the type of objects that will be created. Used for product creation.
