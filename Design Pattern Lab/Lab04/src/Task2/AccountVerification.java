package Task2;

import java.util.Arrays;
import java.util.List;

public class AccountVerification {
    private List<String> validAccounts = Arrays.asList("1234-5678-9101-1121", "1111-2222-3333-4444");

    public boolean verifyAccount(String cardNumber) {
        System.out.println("Verifying account for card number: " + cardNumber);
        return validAccounts.contains(cardNumber);
    }
}
