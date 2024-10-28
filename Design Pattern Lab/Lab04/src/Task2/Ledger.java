package Task2;

import java.util.ArrayList;
import java.util.List;

public class Ledger {
    private List<String> ledgerEntries = new ArrayList<>();

    public void makeEntry(String cardNumber, double amount, String operationType) {
        String entry = "Card: " + cardNumber + ", Amount: $" + amount + ", Operation: " + operationType;
        ledgerEntries.add(entry);
        System.out.println("Creating ledger entry: " + entry);
    }

    public void displayLedger() {
        System.out.println("Ledger Entries:");
        ledgerEntries.forEach(System.out::println);
    }
}
