public class SecurityCamera implements Device {
    private boolean isActive = false;
    private final DeviceStateRepository repo = new DeviceStateRepository();

    @Override
    public void operate() {
        isActive = !isActive;
        String state = isActive ? "ACTIVE" : "INACTIVE";
        Logger.getInstance().log("Security Camera " + state);
        repo.saveDeviceState("SecurityCamera", state);
    }
}
