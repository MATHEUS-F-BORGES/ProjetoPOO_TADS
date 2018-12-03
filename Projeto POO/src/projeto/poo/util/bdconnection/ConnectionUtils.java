package projeto.poo.util.bdconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author victo
 */
public class ConnectionUtils {
    public static Connection getConnection() throws SQLException {
        Connection conn = null;

        String dbURL = "jdbc:mysql://localhost:3306/gerenciacontas";
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "");
        properties.put("serverTimezone", "UTC");
        conn = DriverManager.getConnection(dbURL, properties);
        return conn;
    }

}
