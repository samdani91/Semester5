package Task2;

import java.util.HashMap;
import java.util.Map;

public class BalanceCheck {
    private Map<String, Double> accountBalances = new HashMap<>();

    public BalanceCheck() {
        accountBalances.put("1234-5678-9101-1121", 100.00);
        accountBalances.put("1111-2222-3333-4444", 50.00);
    }

    public boolean hasSufficientBalance(String cardNumber, double amount) {
        System.out.println("Checking balance for card number: " + cardNumber);
        Double balance = accountBalances.get(cardNumber);
        if (balance == null) {
            System.out.println("Account not found.");
            return false;
        }
        return balance >= amount;
    }
}
