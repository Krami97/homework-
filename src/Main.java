import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NeispravniPodaciExcepiton, IOException {
        try {

            Vozilo auto1 = new Automobil("Toyota", "ZG3304IG", 1993, 5);
            Vozilo auto2 = new Automobil("Volvo", "ZG3322IG", 2004, 4);
            Vozilo motor = new Motocikl("Piaggio Vespa", "ZG1234BJ", 1954, "Skuter");

            EvidencijaVozila evidencijaVozila = new EvidencijaVozila();
            evidencijaVozila.dodajVozilo(auto1);
            evidencijaVozila.dodajVozilo(auto2);
            evidencijaVozila.dodajVozilo(motor);
            evidencijaVozila.spremPodatekUDatoteku("evidencija");
            evidencijaVozila.ucitajPodatkeIzDatoteke("evidencija");
        } catch (NeispravniPodaciExcepiton e) {
            System.out.println(e.getMessage());;
        }


    }

}
