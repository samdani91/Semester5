package task1;

public class Main {
    public static void main(String[] args) {

        Coffee coffee = new PlainCoffee();
        System.out.println("Description: " + coffee.getDescription());
        System.out.println("Cost: " + coffee.getCost());


        Coffee creamSugarMilkCoffee = new WhippedCreamDecorator(new SugarDecorator(new MilkDecorator(new PlainCoffee())));
        System.out.println("\nDescription: " + creamSugarMilkCoffee.getDescription());
        System.out.println("Cost: "+ creamSugarMilkCoffee.getCost());
    }
}
