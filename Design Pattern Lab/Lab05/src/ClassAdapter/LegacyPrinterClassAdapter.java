package ClassAdapter;

public class LegacyPrinterClassAdapter extends LegacyPrinter implements Printer{

    @Override
    public void print(String text) {
        printMessage(text);
    }
}
