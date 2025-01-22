import database.DatabaseService;

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
                    novaKupovina(connection);
            }       break;

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
            if (proizvodId ==0){
                break;
            }
            System.out.println("Unesite kolicinu proizvoda:");
            kolicinaProizvoda = scanner.nextInt();
            scanner.nextLine();
            proizvodKolicina.put(proizvodId,kolicinaProizvoda);
        }while(true);
        String brojNovogRacuna;
        try {
            brojNovogRacuna =NoviBrojRacuna(connection);
            connection.setAutoCommit(false);
            // dodavanje racuna
            String racunQuery = "INSERT INTO Racun (KupacID,KomercijalistID,KreditnaKarticaID,DatumIzdavanja,BrojRacuna) VALUES(?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(racunQuery);
            preparedStatement.setInt(1,kupacId);
            preparedStatement.setInt(2,komercialistId);
            preparedStatement.setInt(3,kreditnaKarticaID);
            preparedStatement.setString(4,DatumIzdavanja);
            preparedStatement.setString(5,brojNovogRacuna);
            preparedStatement.executeUpdate();
            System.out.println("Kreiran novi racun " + brojNovogRacuna);

            //dodavanje stavki

            for (Integer proizvodID : proizvodKolicina.keySet()) {
                unosStavkiNaRacun(connection,proizvodID,proizvodKolicina.get(proizvodID),DatumIzdavanja,kupacId,komercialistId,brojNovogRacuna);
            }

            System.out.println("dodano " + proizvodKolicina.size() + " stavki na racun "+ brojNovogRacuna);

            // Skidanje proizvoda sa skladišta
            String novaKolicnaQuery = "UPDATE Proizvod SET MinimalnaKolicinaNaSkladistu = ? WHERE IDProizvod = ?";
            int trenutnaKolicina;
            int novaKolicina;
            for (Integer proizvodID : proizvodKolicina.keySet()) {
                trenutnaKolicina = dohvatiKolicinuStavkeNaSkladisut(connection,proizvodID);
                novaKolicina =  trenutnaKolicina - proizvodKolicina.get(proizvodID);
                PreparedStatement preparedStatement1 = connection.prepareStatement(novaKolicnaQuery);
                preparedStatement1.setInt(1,novaKolicina);
                preparedStatement1.setInt(2,proizvodID);
                preparedStatement1.executeUpdate();

            }
            System.out.println("Proizvodi skinuti sa skladišta!");


            connection.commit();



        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }


    }
    public static int DohvacanjeRacunaID(Connection connection , String DatumIzdavanja,int KupacID,int KomercialistID,String BrojRacuna) throws SQLException{
        String query = "SELECT IDRacun FROM Racun WHERE DatumIzdavanja = ? AND KupacID = ? AND KomercijalistID = ? AND BrojRacuna = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,DatumIzdavanja);
            preparedStatement.setInt(2,KupacID);
            preparedStatement.setInt(3,KomercialistID);
        preparedStatement.setString(4,BrojRacuna);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt("IDRacun");




    }
    public static String NoviBrojRacuna(Connection connection) throws SQLException {
        String query = "SELECT MAX(BrojRacuna) AS ZadnjiBrojRacuna FROM Racun";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();
        String brojRacunaString= resultSet.getString("ZadnjiBrojRacuna");
        String brojeviString = brojRacunaString.substring(2);
        int brojevi = Integer.valueOf(brojeviString) +1 ;
        return "SO"+brojevi;

    }
    public static int dohvatiKolicinuStavkeNaSkladisut(Connection connection , int proizvodID) throws SQLException {
        String query = "SELECT MinimalnaKolicinaNaSkladistu AS Kolicina FROM Proizvod WHERE IDProizvod = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,proizvodID);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt("Kolicina");
    }
    public static int dohvatiCijenuPoKomadu(Connection connection, int proizvodID) throws SQLException {
        String query = "SELECT CijenaBezPDV FROM Proizvod WHERE IDProizvod = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,proizvodID);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt("CijenaBezPDV");
    }
    public static void unosStavkiNaRacun(Connection connection, int proizvodID, int kolicina, String DatumIzdavanja, int kupacId, int komercialistId, String BrojRacuna) throws SQLException {
        int racunId = DohvacanjeRacunaID(connection,DatumIzdavanja,kupacId,komercialistId,BrojRacuna);
        String stavkaQuery = "INSERT INTO Stavka (RacunID,Kolicina,ProizvodID,CijenaPoKomadu,UkupnaCijena,PopustUpostocima) VALUES(?,?,?,?,?,0.00)";
        int cijenaPoKomadu = dohvatiCijenuPoKomadu(connection,proizvodID);
        PreparedStatement preparedStatement1 = connection.prepareStatement(stavkaQuery);
        preparedStatement1.setInt(1,racunId);
        preparedStatement1.setInt(2,kolicina);
        preparedStatement1.setInt(3,proizvodID);
        preparedStatement1.setInt(4,cijenaPoKomadu);
        preparedStatement1.setInt(5,(cijenaPoKomadu*kolicina));
        preparedStatement1.executeUpdate();
        System.out.println("Stavka Dodana!");
    }



}