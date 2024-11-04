package ClassAdapter;

public class ModernPrinter implements  Printer{

    @Override
    public void print(String text) {
        System.out.println("Modern Printer: "+ text);
    }
}
