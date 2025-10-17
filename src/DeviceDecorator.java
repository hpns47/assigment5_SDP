public abstract class DeviceDecorator implements Device {
    protected Device device;

    public DeviceDecorator(Device device) {
        this.device = device;
    }

    @Override
    public void operate() {
        device.operate();
    }
}
