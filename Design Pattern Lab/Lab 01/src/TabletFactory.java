public class TabletFactory extends DeviceFactory{
    @Override
    public Device createDevice() {
        return new Tablet("medium");
    }
}
