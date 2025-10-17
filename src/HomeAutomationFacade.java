public class HomeAutomationFacade {
    private Device light;
    private Device musicSystem;
    private Thermostat thermostat;
    private Device securityCamera;

    public HomeAutomationFacade(Device light, Device musicSystem, Thermostat thermostat, Device securityCamera) {
        this.light = light;
        this.musicSystem = musicSystem;
        this.thermostat = thermostat;
        this.securityCamera = securityCamera;
    }

    public void activateNightMode() {
        System.out.println("\n Activating Night Mode ");
        light.operate();
        thermostat.setTemperature(18);
        thermostat.operate();
        securityCamera.operate();
    }

    public void startPartyMode() {
        System.out.println("\nStarting Party Mode ");
        light.operate();
        System.out.println("Lights dimmed for party atmosphere.");
        musicSystem.operate();
        System.out.println("Music volume set to HIGH.");
    }

    public void leaveHome() {
        System.out.println("\nLeaving Home");
        System.out.println("Turning off all devices...");
        light.operate();
        thermostat.setTemperature(16);
        thermostat.operate();
        securityCamera.operate();
        System.out.println("Security system armed.");
    }
}
