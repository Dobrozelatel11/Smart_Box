package Logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    //private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/smart_box?serverTimezone=Europe/Samara";//useSSL=false
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "myrootpass";

    public Connection getConnection() {
        Connection connection = null;
        try {
           Class.forName(DB_DRIVER);

                connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
               // System.out.println("OK");
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    }
