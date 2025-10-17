public class Light implements Device {
    private boolean isOn = false;
    private final DeviceStateRepository repo = new DeviceStateRepository();

    @Override
    public void operate() {
        isOn = !isOn;
        String state = isOn ? "ON" : "OFF";
        Logger.getInstance().log("Light turned " + state);
        repo.saveDeviceState("Light", state);
    }
}
