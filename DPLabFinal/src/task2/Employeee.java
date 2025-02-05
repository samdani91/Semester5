package task2;

public abstract class Employeee {
    public double monthlySalary;

    public Employeee(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public abstract double calculatePayAmount();
}
