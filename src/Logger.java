import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalTime;

public class Logger {
    private static Logger instance;
    private final DatabaseManager db;

    private Logger() {
        db = DatabaseManager.getInstance();
    }

    public static Logger getInstance() {
        if (instance == null) instance = new Logger();
        return instance;
    }

    public synchronized void log(String message) {
        String timestamp = LocalTime.now().withNano(0).toString();
        System.out.println("[LOG " + timestamp + "] " + message);

        try (PreparedStatement ps = db.getConnection().prepareStatement(
                "INSERT INTO device_logs (timestamp, message) VALUES (?, ?)"
        )) {
            ps.setString(1, timestamp);
            ps.setString(2, message);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("DB log insert failed: " + e.getMessage());
        }
    }
}
