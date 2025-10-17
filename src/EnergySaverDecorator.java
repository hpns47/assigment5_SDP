public class EnergySaverDecorator extends DeviceDecorator {
    private int batteryLevel = 100;

    public EnergySaverDecorator(Device device) {
        super(device);
    }

    @Override
    public void operate() {
        if (batteryLevel < 20) {
            Logger.getInstance().log("Battery low (" + batteryLevel + "%) – ultra saving mode ON.");
        } else {
            super.operate();
            batteryLevel -= 10;
            Logger.getInstance().log("Energy saving active. Battery at " + batteryLevel + "%");
        }
    }
}
