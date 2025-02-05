package task2;

public class Engineer extends Employeee{

    public Engineer(double monthlySalary) {
        super(monthlySalary);
    }

    @Override
    public double calculatePayAmount() {
        return monthlySalary;
    }
}
