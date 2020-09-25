import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.*;

public class DB implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        try {
            Statement statement = Conn.getConn().createStatement();
            statement.execute("CREATE TABLE User")
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
