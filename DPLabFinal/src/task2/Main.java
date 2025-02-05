package task2;

public class Main {
    public static void main(String[] args) {
        Employeee manager = new Manager(20000);
        System.out.println("Manager pay amount: " + manager.calculatePayAmount());

        Employeee salesman = new Salesman(10000);
        System.out.println("Salesman pay amount: " + salesman.calculatePayAmount());

        Employeee engineer = new Engineer(15000);
        System.out.println("Engineer pay amount: " + engineer.calculatePayAmount());

    }
}
