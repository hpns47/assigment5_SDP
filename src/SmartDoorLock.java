public class SmartDoorLock implements Device {
    private boolean locked = false;
    private final DeviceStateRepository repo = new DeviceStateRepository();

    @Override
    public void operate() {
        locked = !locked;
        String state = locked ? "LOCKED" : "UNLOCKED";
        Logger.getInstance().log("Smart Door is now " + state);
        repo.saveDeviceState("SmartDoorLock", state);
    }
}
