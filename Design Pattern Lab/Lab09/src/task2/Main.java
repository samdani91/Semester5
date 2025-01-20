package task2;

public class Main {
    public static void main(String[] args) {
        Robot robot1 = new Robot("Robot1", new AggressiveBehavior());
        Robot robot2 = new Robot("Robot2", new DefensiveBehavior());
        Robot robot3 = new Robot("Robot3", new NormalBehavior());


        robot1.performAction();
        robot2.performAction();
        robot3.performAction();


        System.out.println("\nChanging behaviors dynamically...");
        robot1.setBehavior(new DefensiveBehavior());
        robot2.setBehavior(new NormalBehavior());
        robot3.setBehavior(new AggressiveBehavior());


        robot1.performAction();
        robot2.performAction();
        robot3.performAction();
    }
}
