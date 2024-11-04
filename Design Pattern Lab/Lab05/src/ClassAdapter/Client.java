package ClassAdapter;

public class Client {
    public static void main(String[] args) {
        Printer modernPrinter = new ModernPrinter();
        modernPrinter.print("Modern Doc");

        Printer legacyPrinterClassAdapter = new LegacyPrinterClassAdapter();
        legacyPrinterClassAdapter.print("Legacy Doc");
    }
}