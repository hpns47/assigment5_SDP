public class Main {
    public static void main(String[] args) {
        DatabaseManager.getInstance();

        Device light = new Light();
        Device music = new MusicSystem();
        Thermostat thermostat = new Thermostat();
        Device camera = new SecurityCamera();
        Device door = new SmartDoorLock();

        // Decorators
        light = new VoiceControlDecorator(new EnergySaverDecorator(light));
        music = new ScheduleDecorator(new RemoteAccessDecorator(new EnergySaverDecorator(music)), 1);
        camera = new RemoteAccessDecorator(camera);

        // Facade
        HomeAutomationFacade home = new HomeAutomationFacade(light, music, thermostat, camera, door);

        // Demo
        home.startPartyMode();
        home.activateNightMode();
        home.leaveHome();
        home.vacationMode();
        home.morningMode();

        Logger.getInstance().log("Smart Home session complete");
    }
}
