package depaul.edu;

public interface PaymentGateway {
    boolean processPayment(User user, double amount, String cardNumber, String cvv, String expiredDate);
}


