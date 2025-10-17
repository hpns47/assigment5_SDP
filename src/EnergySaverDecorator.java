public class EnergySaverDecorator extends DeviceDecorator{
    public EnergySaverDecorator(Device device) {
        super(device);
    }

    @Override
    public void operate() {
        super.operate();
        optimizeEnergy();
    }

    private void optimizeEnergy() {
        System.out.println("Energy saver mode activated.");
    }
}
