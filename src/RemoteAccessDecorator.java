public class RemoteAccessDecorator extends DeviceDecorator{
    public RemoteAccessDecorator(Device device) {
        super(device);
    }

    @Override
    public void operate() {
        super.operate();
        enableRemoteAccess();
    }

    private void enableRemoteAccess() {
        System.out.println("Remote access enabled.");
    }
}
