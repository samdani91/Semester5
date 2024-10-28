package Task2;

public class PaymentFacade {
    private AccountVerification accountVerification;
    private SecurityPinCheck securityPinCheck;
    private BalanceCheck balanceCheck;
    private Ledger ledger;
    private NotificationService notificationService;

    public PaymentFacade() {
        this.accountVerification = new AccountVerification();
        this.securityPinCheck = new SecurityPinCheck();
        this.balanceCheck = new BalanceCheck();
        this.ledger = new Ledger();
        this.notificationService = new NotificationService();
    }

    public void processPayment(String cardNumber, String pin, double amount, String operationType) {

        if (!accountVerification.verifyAccount(cardNumber)) {
            System.out.println("Invalid account.");
            return;
        }

        if (!securityPinCheck.verifyPin(cardNumber, pin)) {
            System.out.println("Invalid PIN.");
            return;
        }


        if (!balanceCheck.hasSufficientBalance(cardNumber, amount)) {
            System.out.println("Insufficient balance.");
            return;
        }


        ledger.makeEntry(cardNumber, amount, operationType);


        notificationService.sendNotification("Payment of $" + amount + " for " + operationType + " has been successfully processed.");
    }
}

