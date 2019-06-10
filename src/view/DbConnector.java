package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnector {

    public static Connection getConnection() throws SQLException {
        Properties connectionProps = new Properties();
        connectionProps.put("user", "");
        connectionProps.put("password", "");

        return DriverManager.getConnection("jdbc:derby:ItemsDB;create=false", connectionProps);
    }
}
