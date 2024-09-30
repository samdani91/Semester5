public class Laptop implements Device{
    private String brand;

    public Laptop(String brand) {
        this.brand = brand;
    }

    @Override
    public void powerOn() {
        System.out.println("Laptop's power is on");
    }

    @Override
    public void powerOff() {
        System.out.println("Laptop's power is off");
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
