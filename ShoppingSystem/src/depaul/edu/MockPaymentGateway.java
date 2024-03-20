package depaul.edu;

public class MockPaymentGateway implements PaymentGateway {
    @Override
    public boolean processPayment(User user, double amount, String cardNumber, String cvv, String expiredDate) {
        System.out.println("Processing payment for " + user.getUsername() + ":");
        System.out.println("Amount: $" + amount);
        System.out.println("Card Number: " + cardNumber);
        System.out.println("CVV: " + cvv);
        System.out.println("Expired Date: " + expiredDate);
        return true;
    }
}

