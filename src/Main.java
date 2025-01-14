import database.DatabaseService;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        selectExample();
        InsertExample();



    }
    public static void InsertExample(){

        Connection connection = DatabaseService.CreateConnection();
        try{

            // Izvršavanje SQL upita
            String query = "INSET INTO Drzava(Naziv) VALUES(?)"; // Zamijenite stvarnim nazivom tablice

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1,"Slovenija");
            Integer result = statement.executeUpdate();

            System.out.println("rezulat je :" + result);


            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }


    public static void selectExample(){

        Connection connection = DatabaseService.CreateConnection();
        try{

            // Izvršavanje SQL upita
            String query = "SELECT * FROM Drzava"; // Zamijenite stvarnim nazivom tablice
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Ispis rezultata
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("IDDrzava"));
                System.out.println("Naziv: " + resultSet.getString("Naziv"));
            }

            // Zatvaranje resursa
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    }


