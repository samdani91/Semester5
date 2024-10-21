public class Main {
    public static void main(String[] args) {
        Printer hrPrinter = PrinterRegistry.getInstance().getPrinterForDept("HR");
        Printer itPrinter = PrinterRegistry.getInstance().getPrinterForDept("IT");
        Printer hrPrinter2 = PrinterRegistry.getInstance().getPrinterForDept("HR");

        System.out.println();

        hrPrinter.print("Employee Handbook");
        itPrinter.print("SRS Document");
        hrPrinter2.print("HR Policies");

        System.out.println();

        System.out.println("Are HR printers same? " + (hrPrinter == hrPrinter2));
    }
}