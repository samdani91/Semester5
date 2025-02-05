package task2;

public class Manager extends Employeee{
    private double bonus = 2500;
    public Manager(double monthlySalary) {
        super(monthlySalary);
    }

    @Override
    public double calculatePayAmount() {
        return monthlySalary+bonus;
    }
}
