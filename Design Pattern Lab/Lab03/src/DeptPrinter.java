public class DeptPrinter implements Printer{
    private String dept;
    private DeptPrinter(String dept){
        this.dept=dept;
        System.out.println("Printer created for dept:"+dept);

    }
    @Override
    public void print(String document) {
        System.out.println("Printing document: " + document + " for dept: " + dept);
    }

    public static Printer createPrinter(String dept) {
        return new DeptPrinter(dept);
    }
}
