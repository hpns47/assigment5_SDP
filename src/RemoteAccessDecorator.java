import java.util.Random;

public class RemoteAccessDecorator extends DeviceDecorator {
    public RemoteAccessDecorator(Device device) {
        super(device);
    }

    @Override
    public void operate() {
        if (new Random().nextInt(10) < 2) {
            Logger.getInstance().log("Connection failed. Retrying...");
        } else {
            super.operate();
            Logger.getInstance().log("Remote access enabled (smartphone control).");
        }
    }
}
