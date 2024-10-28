package Task2;

public class Main {
    public static void main(String[] args) {
        PaymentFacade paymentFacade = new PaymentFacade();

        String cardNumber = "1234-5678-9101-1121";
        String pin = "1234";
        double amount = 29.99;
        String operationType = "Pizza Order";


        paymentFacade.processPayment(cardNumber, pin, amount, operationType);
    }
}
