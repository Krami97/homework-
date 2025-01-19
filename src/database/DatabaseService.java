package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {
    // public , static class razlika je da static mormo krirati instncu
    //Staticna klasa je kad se atirbuti ne mjenjaju dok je instaca kada se neki atibutei mogu mjenjati pa
    // se dvije instance razlikuju u nekom segmentu
    //staticne metode su globalne metode
    //----------------------------------------------------------------
    // kriranje paketa za database  i kreiranje klase za spajanje sa bazom
    //kaoko nebi morali svaki put kreirati
    public static Connection CreateConnection(){
        // URL za povezivanje s bazom podataka
        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=Knjiznica;encrypt=true;trustServerCertificate=true";
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
