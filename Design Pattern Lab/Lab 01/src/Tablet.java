public class Tablet implements Device{
    private String size;

    public Tablet(String size) {
        this.size = size;
    }

    @Override
    public void powerOn() {
        System.out.println("Tablet's power is on");
    }

    @Override
    public void powerOff() {
        System.out.println("Tablet's power is off");
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "size='" + size + '\'' +
                '}';
    }
}
