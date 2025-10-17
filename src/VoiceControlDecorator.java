public class VoiceControlDecorator extends DeviceDecorator {
    public VoiceControlDecorator(Device device) {
        super(device);
    }

    @Override
    public void operate() {
        super.operate();
        addVoiceControl();
    }

    private void addVoiceControl() {
        System.out.println("Voice control activated.");
    }
}
