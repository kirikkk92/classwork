import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {

    Connection conn;

    public static Connection getConn() throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:h2:mem:Shop", // URL

                "", // User

                ""); // Password

        return conn;

    }
}