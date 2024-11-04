package ObjectAdapter;

public class Client {
    public static void main(String[] args) {
        Printer modernPrinter = new ModernPrinter();
        modernPrinter.print("Modern Doc");

        Printer legacyPrinterAdapter = new LegacyPrinterAdapter(new LegacyPrinter());
        legacyPrinterAdapter.print("Legacy Doc");
    }
}