package builder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.displayMenu();
        Scanner sc = new Scanner(System.in);
        int bread, filling, spread;
        System.out.print("\n1.Regular\n2.Toasted\nWhat type of bread do you want?: ");
        bread = sc.nextInt();
        System.out.print("\n1.Chicken\n2.Egg\nWhat type of filling do you want?: ");
        filling = sc.nextInt();
        System.out.print("\n1.Cheese\n2.Sauce\n3.No Spread\nWhat type of bread do you want?: ");
        spread = sc.nextInt();
        SpreadType spreadType = switch (spread) {
            case 1 -> SpreadType.Cheese;
            case 2 -> SpreadType.Sauce;
            default -> null;
        };

        Sandwich sandwich = new Sandwich.SandwichBuilder()
                .setBread(bread == 1 ? BreadType.Regular : BreadType.Toasted)
                .setFilling(filling == 1 ? FilingType.Chicken : FilingType.Egg)
                .setSpread(spreadType)
                .build();
        System.out.println("Your Sandwich: " + sandwich);
    }
}