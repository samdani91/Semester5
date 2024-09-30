import java.util.Scanner;
import java.util.zip.DeflaterInputStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        DeviceFactory myDevice;

        switch (input) {
            case "laptop" -> myDevice = new LaptopFactory();
            case "smartphone" -> myDevice = new SmartphoneFactory();
            case "tablet" -> myDevice = new TabletFactory();
            default -> {
                System.out.println("Device not found!");
                return;
            }
        }

        Device newDevice = myDevice.createDevice();
        newDevice.powerOn();
        System.out.println(newDevice.toString());
        newDevice.powerOff();

    }
}