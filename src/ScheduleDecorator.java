public class ScheduleDecorator extends DeviceDecorator {
    private int delaySeconds;

    public ScheduleDecorator(Device device, int delaySeconds) {
        super(device);
        this.delaySeconds = delaySeconds;
    }

    @Override
    public void operate() {
        Logger.getInstance().log("→ Scheduled to activate in " + delaySeconds + " seconds...");
        try {
            Thread.sleep(delaySeconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        super.operate();
    }
}
