import database.DatabaseService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DatabaseService.CreateConnection();
        ArrayList<Osoba> osobe = new ArrayList<>();
        osobe.add(new Osoba("Tin", "Kramaric", "19471112"));
        osobe.add(new Osoba("Dino", "Mirt", "19521112"));
        osobe.add(new Osoba("Leon", "Thur", "19671112"));
        osobe.add(new Osoba("Anja", "Majurec", "19541112"));
        osobe.add(new Osoba("Vlatko", "Banovic", "19631112"));
        DodavanjeNovihOsoba(connection, osobe);
        pozivanjeProcedureZaArzuriranjePrezimenaOsobe(connection, 23, "NovoPrezime");
        brisanjeOsobaPoDatumuRodenja(connection, "19471112");
        connection.close();


    }

    public static void DodavanjeNovihOsoba(Connection connection, ArrayList<Osoba> osobe) throws SQLException {


        String query = "INSERT INTO Osoba (Ime,Prezime,DatumRodenja) VALUES(?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        for (Osoba osoba : osobe) {
            preparedStatement.setString(1, osoba.getIme());
            preparedStatement.setString(2, osoba.getPrezime());
            preparedStatement.setString(3, osoba.getDatumRodenjaYYYYMMDD());
            preparedStatement.executeUpdate();
            System.out.println("Osoba " + osoba.ime + " " + osoba.prezime + " dodana");
        }
        preparedStatement.close();
        connection.close();
    }

    public static void pozivanjeProcedureZaArzuriranjePrezimenaOsobe(Connection connection, int IDOsobe, String novoPrezime) throws SQLException {
        String callProcedrure = "{CALL AzurirajPrezime(?,?)}";
        CallableStatement callableStatement = connection.prepareCall(callProcedrure);
        callableStatement.setInt(1, IDOsobe);
        callableStatement.setString(2, novoPrezime);
        callableStatement.execute();
        callableStatement.close();
    }

    public static void brisanjeOsobaPoDatumuRodenja(Connection connection, String datumRodenjaYYYYMMDD) throws SQLException {
        String callProcedrure = "{CALL ObrisiOsobePoDatumuRodenja(?)}";
        CallableStatement callableStatement = connection.prepareCall(callProcedrure);
        callableStatement.setString(1, datumRodenjaYYYYMMDD);
        callableStatement.execute();
        callableStatement.close();
    }

}