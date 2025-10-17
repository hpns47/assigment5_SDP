import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeviceStateRepository {
    private final Connection conn = DatabaseManager.getInstance().getConnection();

    public void saveDeviceState(String name, String state) {
        try (PreparedStatement ps = conn.prepareStatement("""
            INSERT INTO devices (name, state)
            VALUES (?, ?)
            ON CONFLICT(name) DO UPDATE SET state = excluded.state;
        """)) {
            ps.setString(1, name);
            ps.setString(2, state);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Failed to update device state: " + e.getMessage());
        }
    }
}
