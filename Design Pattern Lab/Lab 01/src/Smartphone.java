public class Smartphone implements Device {
    private String os;
    private int version;

    public Smartphone(String os, int version) {
        this.os = os;
        this.version = version;
    }

    @Override
    public void powerOn() {
        System.out.println("Smartphone's power is on");
    }

    @Override
    public void powerOff() {
        System.out.println("Smartphone's power is off");
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "os='" + os + '\'' +
                ", version=" + version +
                '}';
    }
}
