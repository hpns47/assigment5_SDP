import java.util.Random;

public class Thermostat implements Device {
    private int temperature = 22;
    private final DeviceStateRepository repo = new DeviceStateRepository();

    @Override
    public void operate() {
        Logger.getInstance().log("Thermostat set to " + temperature + "C");
        repo.saveDeviceState("Thermostat", temperature + "C");
    }

    public void setTemperature(int temp) {
        this.temperature = temp;
        Logger.getInstance().log("Temperature adjusted to " + temp + "C");
        repo.saveDeviceState("Thermostat", temp + "C");
    }

    public void autoAdjust() {
        int current = new Random().nextInt(10) + 15;
        Logger.getInstance().log("Sensor detected current temperature: " + current + "C");
        if (current < 18) setTemperature(22);
        else if (current >= 24) setTemperature(19);
    }
}
