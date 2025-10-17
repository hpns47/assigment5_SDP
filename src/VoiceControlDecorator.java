public class VoiceControlDecorator extends DeviceDecorator {
    public VoiceControlDecorator(Device device) {
        super(device);
    }

    @Override
    public void operate() {
        super.operate();
        Logger.getInstance().log("Voice control feature enabled.");
    }
}
