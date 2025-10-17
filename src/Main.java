import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseManager.getInstance();

        Device light = new Light();
        Device music = new MusicSystem();
        Thermostat thermostat = new Thermostat();
        Device camera = new SecurityCamera();
        Device door = new SmartDoorLock();

        light = new VoiceControlDecorator(new EnergySaverDecorator(light));
        music = new ScheduleDecorator(new RemoteAccessDecorator(new EnergySaverDecorator(music)), 1);
        camera = new RemoteAccessDecorator(camera);

        HomeAutomationFacade home = new HomeAutomationFacade(light, music, thermostat, camera, door);

        Logger.getInstance().log("Smart Home Interactive Mode");

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("SMART HOME CONTROL PANEL");
            System.out.println("1. Start Party Mode");
            System.out.println("2. Activate Night Mode");
            System.out.println("3. Leave Home Mode");
            System.out.println("4. Vacation Mode");
            System.out.println("5. Morning Mode");
            System.out.println("6. Set Thermostat Temperature");
            System.out.println("7. Toggle Light Manually");
            System.out.println("8. Toggle Music System");
            System.out.println("9. Exit");
            System.out.print("Select option (1-9): ");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> home.startPartyMode();
                case "2" -> home.activateNightMode();
                case "3" -> home.leaveHome();
                case "4" -> home.vacationMode();
                case "5" -> home.morningMode();
                case "6" -> {
                    System.out.print("Enter desired temperature (°C): ");
                    try {
                        int temp = Integer.parseInt(scanner.nextLine());
                        thermostat.setTemperature(temp);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number.");
                    }
                }
                case "7" -> {
                    Logger.getInstance().log("Manual light control triggered.");
                    light.operate();
                }
                case "8" -> {
                    Logger.getInstance().log("Manual music control triggered.");
                    music.operate();
                }
                case "9" -> {
                    System.out.println("Exiting Smart Home...");
                    running = false;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
        Logger.getInstance().log("Smart Home session ended.");
    }
}
