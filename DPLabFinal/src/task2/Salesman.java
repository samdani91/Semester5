package task2;

public class Salesman extends Employeee{
    private  double commission = 2500;
    public Salesman(double monthlySalary) {
        super(monthlySalary);
    }

    @Override
    public double calculatePayAmount() {
        return monthlySalary+commission;
    }
}
