package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {

    public static Connection CreateConnection(){

        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=AdventureWorksOBP;encrypt=true;trustServerCertificate=true";
        String user = "root";
        String password = "password";
        Connection connection = null;
        // Usposavljanje veze
        try {
            connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {

            }
            return connection;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
