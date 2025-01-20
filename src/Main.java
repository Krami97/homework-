import database.DatabaseService;
import org.w3c.dom.ls.LSOutput;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Connection connection = DatabaseService.CreateConnection();
        Scanner scanner = new Scanner(System.in);
        int odabir;
        do {
            System.out.println("Odaberite:");
            System.out.println("1 za brisnaje racuna");
            System.out.println("2 za novu kupovinu");
            System.out.println("0 za izlaz");
            odabir = scanner.nextInt();
            scanner.nextLine();

            switch (odabir){
                case 1:
                    brisanjeRacuna(connection);
                    break;
                case 2:
            }

        }while(odabir!=0);




        if (connection == null) {
            try {
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }

        }

    }

    public static void brisanjeRacuna(Connection connection){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite ID racuna koje zelite izbrisati:");
        int idRacuna = scanner.nextInt();


        try {
            connection.setAutoCommit(false);

            String DELETEstavkaQuery = "DELETE Stavka WHERE  RacunID = ?";
            PreparedStatement preparedStatementStavka  =connection.prepareStatement(DELETEstavkaQuery);
            preparedStatementStavka.setInt(1,idRacuna);
            preparedStatementStavka.executeUpdate();

            String DELETEracunQuery = "DELETE Racun WHERE  IDRacun = ?";
            PreparedStatement preparedStatementRacun  =connection.prepareStatement(DELETEracunQuery);
            preparedStatementRacun.setInt(1,idRacuna);
            preparedStatementRacun.executeUpdate();

            connection.commit();
            System.out.println("Racun izbrisan!\n");
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }

    }
    public static void novaKupovina(Connection connection){
        // Uzimanje podatak od korisnika
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite ID kupca:");
        int kupacId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Unestiet ID komercialista:");
        int komercialistId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Unestiet ID Kreditne Kartice :");
        int kreditnaKarticaID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Uneste komentar ili 0 ako nemate komentar ");
        String komentarRacuna = scanner.nextLine();
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String DatumIzdavanja = today.format(formatter);

        HashMap<Integer, Integer> proizvodKolicina = new HashMap<>();
        int proizvodId;
        int kolicinaProizvoda;
        do {
            System.out.println("Unesite ID proizvoda:\n(Unesite 0 ako nema više proizvoda)");
            proizvodId = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Unesite kolicinu proizvoda:");
            kolicinaProizvoda = scanner.nextInt();
            scanner.nextLine();
            proizvodKolicina.put(proizvodId,kolicinaProizvoda);
        }while(proizvodId != 0);

        try {
            connection.setAutoCommit(false);
            // dodavanje racuna
            String racunQuery = "INSERT INTO Racun (KupacID,KomercialistID,KreditnaKarticaID,DatumIzdavanja) VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(racunQuery);
            preparedStatement.setInt(1,kupacId);
            preparedStatement.setInt(2,komercialistId);
            preparedStatement.setInt(3,kreditnaKarticaID);
            preparedStatement.setString(4,DatumIzdavanja);
            preparedStatement.executeUpdate();


            //dodavanje stavki
            int racunId = DohvacanjeRacunaID(connection,DatumIzdavanja,kupacId,komercialistId);

            String stavkaQuery = "INSERT INTO Stavka (RacunID,Kolicna,ProitvodID) VALUES(?,?,?)";
            for (Integer proizvodID : proizvodKolicina.keySet()) {
                PreparedStatement preparedStatement1 = connection.prepareStatement(stavkaQuery);
                preparedStatement1.setInt(1,racunId);
                preparedStatement1.setInt(2,proizvodKolicina.get(proizvodID));
                preparedStatement1.setInt(3,proizvodID);
                preparedStatement1.executeUpdate();

            }






        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public static int DohvacanjeRacunaID(Connection connection , String DatumIzdavanja,int KupacID,int KomercialistID) throws SQLException{
        String query = "SELECT IDRacun FROM Racun WHERE DatumIzdavanja = ? AND KupacID = ? AND KomercialistID = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,DatumIzdavanja);
            preparedStatement.setInt(2,KupacID);
            preparedStatement.setInt(3,KomercialistID);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt("IDRacun");




    }
    public static String NoviBrojRacuna(Connection connection) throws SQLException {
        String query = "SELECT MAX(BrojRacuna) FROM Racun";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();
        String brojRacunaString= resultSet.getString("BrojRacuna");
        brojRacunaString.substring(1,6);

    }


}