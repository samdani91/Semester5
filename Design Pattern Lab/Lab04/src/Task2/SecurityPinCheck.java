package Task2;

import java.util.HashMap;
import java.util.Map;

public class SecurityPinCheck {
    private Map<String, String> cardPinMap = new HashMap<>();

    public SecurityPinCheck() {
        cardPinMap.put("1234-5678-9101-1121", "1234");
        cardPinMap.put("1111-2222-3333-4444", "5678");
    }

    public boolean verifyPin(String cardNumber, String pin) {
        System.out.println("Verifying PIN for card number: " + cardNumber);
        return cardPinMap.getOrDefault(cardNumber, "").equals(pin);
    }

}
