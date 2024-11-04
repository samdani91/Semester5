package ObjectAdapter;

public class LegacyPrinterAdapter implements Printer {

    private LegacyPrinter legacyPrinter;

    public LegacyPrinterAdapter(LegacyPrinter legacyPrinter){
        this.legacyPrinter=legacyPrinter;
    }
    @Override
    public void print(String message) {
        legacyPrinter.printMessage(message);
    }
}