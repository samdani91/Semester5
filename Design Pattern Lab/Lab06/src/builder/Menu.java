package builder;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<String> sandwiches;

    public Menu() {
        sandwiches = new ArrayList<>();
        sandwiches.add("Chicken Sandwich");
        sandwiches.add("Egg Sandwich");
    }

    public void displayMenu() {
        System.out.println("Displaying Menu: ");
        for (int i=0; i<sandwiches.size(); i++) {
            System.out.println((i+1) + " " + sandwiches.get(i));
        }
    }
}
