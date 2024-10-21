import java.util.HashMap;
import java.util.Map;

public class PrinterRegistry {
    private Map<String, Printer> printerMap = new HashMap<>();

    private static PrinterRegistry instance;

    private PrinterRegistry() {}

    public static PrinterRegistry getInstance() {
        if (instance == null) {
            instance = new PrinterRegistry();
        }
        return instance;
    }

    // Factory method to create or get a printer for a department
    private Printer createPrinter(String dept) {
        return DeptPrinter.createPrinter(dept);
    }


    public Printer getPrinterForDept(String dept) {
        if (!printerMap.containsKey(dept)) {
            Printer printer = createPrinter(dept);
            printerMap.put(dept, printer);
        }
        return printerMap.get(dept);
    }
}
