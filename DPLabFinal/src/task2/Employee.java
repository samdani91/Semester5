package task2;

public class Employee {
    private int type;
    private static final int  ENGINEER = 0;
    private static final int  SALESMAN = 1;
    private static final int  MANAGER = 2;
    private double monthlySalary;
    private double commission;
    private double bonus;

    public Employee(int type,double salary,double commission,double bonus){
        this.type = type;
        this.monthlySalary = salary;
        this.commission = commission;
        this.bonus = bonus;
    }

    public double PayAmount(){
        switch (this.type){
            case ENGINEER:
                return monthlySalary;
            case SALESMAN:
                return monthlySalary+commission;
            case MANAGER:
                return monthlySalary+bonus;
            default:
                System.out.println("Incorrect Employee");
                return 0;
        }
    }
}

class TestEmployee{
    public static void main(String[] args) {
        Employee manager = new Employee(2,20000,5000,2500);
        manager.PayAmount();

        Employee salesman = new Employee(1,10000,2500,1500);
        salesman.PayAmount();

        Employee engineer = new Employee(0,15000,3000,2000);
        engineer.PayAmount();
    }
}