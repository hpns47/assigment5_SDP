//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Device light = new Light();
        Device musicSystem = new MusicSystem();
        Thermostat thermostat = new Thermostat();
        Device camera = new SecurityCamera();

        light = new VoiceControlDecorator(new EnergySaverDecorator(light));
        musicSystem = new RemoteAccessDecorator(new EnergySaverDecorator(musicSystem));

        HomeAutomationFacade home = new HomeAutomationFacade(light, musicSystem, thermostat, camera);

        home.startPartyMode();
        home.activateNightMode();
        home.leaveHome();
    }
}