public class MusicSystem implements Device {
    private boolean isPlaying = false;
    private final DeviceStateRepository repo = new DeviceStateRepository();

    @Override
    public void operate() {
        isPlaying = !isPlaying;
        if (isPlaying) {
            Logger.getInstance().log("Music System started playing: 'Linkin Park One Step Closer'");
            repo.saveDeviceState("MusicSystem", "PLAYING");
        } else {
            Logger.getInstance().log("Music System stopped playing.");
            repo.saveDeviceState("MusicSystem", "STOPPED");
        }
    }
}
