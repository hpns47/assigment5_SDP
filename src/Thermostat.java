public class Thermostat implements Device{
    private int temperature = 20;

    @Override
    public void operate() {
        System.out.println("The thermostat is set to " + temperature + " degrees Celsius.");
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
