import database.DatabaseService;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int odabir;
        do {
            System.out.println("Odaberite:");
            System.out.println("1 - dodanj novi grad");
            System.out.println("2 - izmjena postojeceg grada");
            System.out.println("3 - brisanje postojeceg grada ");
            System.out.println("4 - prikaz svih gradova sortiranih po nazivu");
            System.out.println("5 - za izlaz");
            odabir = scanner.nextInt();


            switch (odabir){
                case 1:
                    InsertGrad();
                    break;
                case 2:
                    updateGrad();
                    break;
                case 3:
                    deleteGrad();
                    break;
                case 4:
                    prikazGradova();
                    break;

            }
        } while (odabir != 5);


    }
    public static void prikazDrzava(){
        Connection connection = DatabaseService.CreateConnection();
        String query = "SELECT * FROM Drzava";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                System.out.println("ID: "+ resultSet.getInt("IDDrzava")+" Drzava: "+ resultSet.getString("Naziv"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    public static void InsertGrad(){
        Scanner scanner  =new Scanner(System.in);
        System.out.println("Unesitie Ime Grada");
        String nazivGrada = scanner.nextLine();
        prikazDrzava();
        System.out.println("Odaberite ID Drzave u kojoj se nalazi Grad");
        int drzavaID  = scanner.nextInt();



        Connection connection = DatabaseService.CreateConnection();
        try{


            String query = "INSERT INTO Grad (Naziv,DrzavaID) VALUES (?,?)";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1,nazivGrada);
            statement.setInt(2,drzavaID);
            int result = statement.executeUpdate();

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


    public static void prikazGradova(){

        Connection connection = DatabaseService.CreateConnection();
        try{


            String query = "SELECT g.IDGrad ,g.Naziv , d.Naziv AS Drzava FROM Grad AS g INNER JOIN Drzava AS d ON d.IDDrzava = g.DrzavaID ORDER BY g.Naziv";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("IDGrad")+
                        "| Naziv: " + resultSet.getString("Naziv")+
                        "| Drzava: " + resultSet.getString("Drzava"));

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

    public static void updateGrad(){
        Scanner scanner  =new Scanner(System.in);
        System.out.println("Unesitie ID grada koji zelite izmjeniti \n(upisite 0 ako zelite vidjeti listu gradova)");
        int gradID = scanner.nextInt();
        scanner.nextLine();
        if (gradID == 0){
            prikazGradova();
            System.out.println("Unesi ID grada koji zelis zamjeniti ");
            gradID = scanner.nextInt();
        }
        String gradNaziv = getGradNaziv(gradID);
        int drzavaID = getDrzavaID(gradID);
        System.out.println("Odaber: \n1 izmjena Naziva \n2 Izmjenda DrzavaID\n3 Izmjeni oboje");
        int odabir = scanner.nextInt();
        scanner.nextLine();
        switch (odabir){
            case 1:
                System.out.println("Novi Naziv:");
                gradNaziv = scanner.nextLine();
                scanner.nextLine();
                break;
            case 2:
                prikazDrzava();
                System.out.println("Novi DrzavaID:");
                drzavaID = scanner.nextInt();
                scanner.nextLine();
                break;
            case 3:
                System.out.println("Novi Naziv:");
                gradNaziv = scanner.nextLine();
                System.out.println("Novi DrzavaID:");
                drzavaID = scanner.nextInt();
                scanner.nextLine();
        }





        Connection connection = DatabaseService.CreateConnection();
        try{


            String query = "UPDATE Grad SET Naziv = ? , DrzavaID = ? WHERE IDGrad = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,gradNaziv);
            statement.setInt(2,drzavaID);
            statement.setInt(3,gradID);
            statement.executeUpdate();

            System.out.println("grad je izmjenjen!");


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

    public static int getDrzavaID(int IDgrad){
        Connection connection = DatabaseService.CreateConnection();
        int drzavaID = 0;
        try{


            String query = "SELECT DrzavaID FROM Grad WHERE IDGrad = "+String.valueOf(IDgrad);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            drzavaID =  resultSet.getInt("DrzavaID");




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
        return drzavaID;


    }
    public static String getGradNaziv(int IDgrad){
        Connection connection = DatabaseService.CreateConnection();
        String drzavaNaziv = " ";
        try{


            String query = "SELECT Naziv FROM Grad WHERE IDGrad = "+String.valueOf(IDgrad);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            drzavaNaziv =  resultSet.getString("Naziv");




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
        return drzavaNaziv;


    }
    public static void deleteGrad(){
        Scanner scanner  =new Scanner(System.in);
        prikazGradova();
        System.out.println("Unesitie ID grada koji zelite izbrisati");
        int IDgrad = scanner.nextInt();
        scanner.nextLine();

        Connection connection = DatabaseService.CreateConnection();
        try{


            String query = "DELETE Grad WHERE IDGrad = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,IDgrad);
            statement.executeUpdate();

            System.out.println("Grad je izbrisan!");


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


