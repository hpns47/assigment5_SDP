public class HomeAutomationFacade {
    private Device light;
    private Device musicSystem;
    private Thermostat thermostat;
    private Device securityCamera;
    private Device doorLock;
    private final DeviceStateRepository repo = new DeviceStateRepository();

    public HomeAutomationFacade(Device light, Device musicSystem, Thermostat thermostat, Device securityCamera, Device doorLock) {
        this.light = light;
        this.musicSystem = musicSystem;
        this.thermostat = thermostat;
        this.securityCamera = securityCamera;
        this.doorLock = doorLock;
    }

    public void startPartyMode() {
        Logger.getInstance().log("\nStarting Party Mode");
        light.operate();
        musicSystem.operate();
        thermostat.setTemperature(21);
        Logger.getInstance().log("Lights dimmed and music volume set to HIGH.");
        repo.saveDeviceState("SystemMode", "Party");
    }

    public void activateNightMode() {
        Logger.getInstance().log("\nActivating Night Mode");
        light.operate();
        thermostat.setTemperature(18);
        securityCamera.operate();
        doorLock.operate();
        repo.saveDeviceState("SystemMode", "Night");
    }

    public void leaveHome() {
        Logger.getInstance().log("\nLeaving Hom");
        light.operate();
        musicSystem.operate();
        thermostat.setTemperature(16);
        securityCamera.operate();
        doorLock.operate();
        repo.saveDeviceState("SystemMode", "Away");
        Logger.getInstance().log("Security system armed and house locked.");
    }

    public void vacationMode() {
        Logger.getInstance().log("\nVacation Mode");
        light.operate();
        thermostat.setTemperature(15);
        securityCamera.operate();
        doorLock.operate();
        repo.saveDeviceState("SystemMode", "Vacation");
        Logger.getInstance().log("All devices minimized for long-term energy saving.");
    }

    public void morningMode() {
        Logger.getInstance().log("\nMorning Mode");
        light.operate();
        thermostat.setTemperature(22);
        musicSystem.operate();
        repo.saveDeviceState("SystemMode", "Morning");
        Logger.getInstance().log("Good morning! Lights and music are on.");
    }
}
