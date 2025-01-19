import database.DatabaseService;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Connection connection = DatabaseService.CreateConnection();
        Scanner scanner = new Scanner(System.in);
        int odabir;
        do {
            System.out.println("Odaberite");
            System.out.println("1 za dodavanje autora");
            System.out.println("2 za dodavanje knjige");
            System.out.println("3 za dohvanje svih knjiga za zadanog autora ");
            System.out.println("4 za aržuriranje naslova knjige");
            System.out.println("5 za dohvacanje svhih autora bez knjiga ");
            System.out.println("0 za izlaz iz prgrama");
            odabir = scanner.nextInt();
            scanner.nextLine();

            switch (odabir){
                case 1:
                    dodavanjeAutora(connection);
                    break;
                case 2:
                    dodavanjeKnjige(connection);
                    break;
                case 3:
                    ispisSvihKnjigaZadanogAutora(connection);
                    break;
                case 4:
                    arzuriranjeNaslovaKnjige(connection);
                    break;
                case 5:
                    ispisAutoraBezKnjige(connection);
                    break;
            }
        }while(odabir != 0);
        if (connection == null) {
            try {
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }

        }

    }

    public static void dodavanjeAutora(Connection connection){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ime autora:");
        String imeAutora = scanner.nextLine();
        System.out.println("Prezime autora:");
        String prezimeAutora = scanner.nextLine();
        System.out.println("Nacionalnost autora:");
        String nacionalnostAutora = scanner.nextLine();

        String query ="INSERT INTO Autor (ime,prezime,nacionalnost) VALUES(?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,imeAutora);
            preparedStatement.setString(2,prezimeAutora);
            preparedStatement.setString(3,nacionalnostAutora);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("Autor dodan\n");

        }catch (SQLException e){
            e.printStackTrace();

        }
    }
    public static void dodavanjeKnjige(Connection connection){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Naslov knjige:");
        String naslovKnjige = scanner.nextLine();
        System.out.println("godina Izdanja:");
        int godinaIzdanja = scanner.nextInt();
        System.out.println("ID autora:\n(unestie 0 ako zelite listu svih autora");
        int autrorID = scanner.nextInt();
        if (autrorID == 0){
            ispisSvihAutora(connection);
            System.out.println("ID autora:");
            autrorID = scanner.nextInt();
        }


        String query ="INSERT INTO Knjiga (Naslov,GodinaIzdanja,autorID) VALUES(?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, naslovKnjige);
            preparedStatement.setInt(2, godinaIzdanja);
            preparedStatement.setInt(3,autrorID);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("Knjiga dodana\n");

        }catch (SQLException e){
            e.printStackTrace();

        }
    }
    public static void arzuriranjeNaslovaKnjige(Connection connection){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Uneite id knjige kojoj zelite promjeniti nalsov \n(unesite 0 ako zelite ispissvih knjiga");
        int idKnjige = scanner.nextInt();
        if (idKnjige == 0){
            ispisSvihKnjiga(connection);
            System.out.println("Uneite id knjige kojoj zelite promjeniti nalsov");
            idKnjige = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.println("Unesite novi naslov knjige:");
        String noviNalsovKnjige = scanner.nextLine();


        String query ="UPDATE Knjiga SET Naslov = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, noviNalsovKnjige);
            preparedStatement.setInt(2, idKnjige);

            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("Knjiga arzurirana\n");

        }catch (SQLException e){
            e.printStackTrace();

        }
    }

    public static void ispisSvihKnjigaZadanogAutora(Connection connection){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite Prezime autora cije knjige zelite pretraziti:");
        String prezimeAutora = scanner.nextLine();


        String query ="SELECT k.id,k.Naslov,a.ime,a.prezime FROM Knjiga AS k INNER JOIN Autor AS a ON a.id = k.autorId WHERE a.Prezime = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, prezimeAutora);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println("ID Knjige: " +resultSet.getInt("id"));
                System.out.println("Naslov Knjige: " + resultSet.getString("naslov"));
                System.out.println("Ime Autora: " + resultSet.getString("ime"));
                System.out.println("Prezime Autora: " + resultSet.getString("prezime"));
                System.out.println(" ");
            }
            preparedStatement.close();


        }catch (SQLException e){
            e.printStackTrace();

        }
    }

    public static void ispisAutoraBezKnjige(Connection connection){


        String query ="SELECT a.id,a.ime,a.prezime FROM Autor AS a  LEFT JOIN Knjiga AS k ON k.autorID = A.id  GROUP BY a.id,a.ime,a.prezime  HAVING COUNT(k.autorId) = 0; ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Autori bez unesenih knjiga:");
            while(resultSet.next()){
                System.out.println("ID: "+resultSet.getInt("id"));
                System.out.println("Ime: "+resultSet.getString("ime"));
                System.out.println("Prezime: "+resultSet.getString("Prezime"));
                System.out.println(" ");

            }
            preparedStatement.close();


        }catch (SQLException e){
            e.printStackTrace();

        }
    }


    public static void ispisSvihAutora(Connection connection){

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Autor");
            while(resultSet.next()){
                System.out.println("id: "+resultSet.getInt("id")+
                        " Ime: "+resultSet.getString("ime")+
                        " Prezime: "+resultSet.getString("prezime")+
                        " Nacionalnost: "+resultSet.getString("nacionalnost"));
            }
        }catch (SQLException e){
            e.printStackTrace();

        }
    }
    public static void ispisSvihKnjiga(Connection connection){
        String qury = "SELECT k.id,k.naslov,a.ime,a.prezime FROM Knjiga AS k INNER JOIN Autor AS a ON a.id = k.autorId";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(qury);
            while(resultSet.next()){
                System.out.println("ID Knjige: " +resultSet.getInt("id"));
                System.out.println("Naslov Knjige: " + resultSet.getString("naslov"));
                System.out.println("Ime Autora: " + resultSet.getString("ime"));
                System.out.println("Prezime Autora: " + resultSet.getString("prezime"));
                System.out.println(" ");
            }
        }catch (SQLException e){
            e.printStackTrace();

        }
    }


}