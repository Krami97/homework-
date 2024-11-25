import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<Vozilo> vozila = new ArrayList<>();

        vozila.add(new Automobil("Toyota","Corolla","ZG1234IK",5,"benzin"));
        vozila.add(new Automobil("Tesla","Model 3","SB8384DJ",5,"struja"));
        vozila.add(new Automobil("Smart","Fortwo","ST2356DK",2,"dizel"));
        vozila.add(new Kamion("Toyota","Tacoma","ZG5453BJ",3000,3));
        vozila.add(new Kamion("Ford","F-150","BJ23153AP",5000,4));
        int odabir ;
        do{
            System.out.println("odaberite opiju:"+
                    "\n1.Nađi vozilo po registraciji"+
                    "\n2.Ispis svih postojecih vozila"+
                    "\n3.Izlaz");
            odabir = scanner.nextInt();
            scanner.nextLine();
            switch (odabir){
                case 1:
                    System.out.println("Unesi registraciju vozila");
                    String registracija= scanner.nextLine();
                    pronadiVoziloPoRegistraciji(vozila,registracija);
                    break;
                case 2:
                    System.out.println("Popis vozila:");
                    ispisiSvaVozila(vozila);
                    break;
                default:
                    System.out.println("Krivi unos");


            }

        }while(odabir!=3);
            

        


    }

    public static void pronadiVoziloPoRegistraciji(List<Vozilo> vozila,String registracija){
        Vozilo trazenoVozilo = null;
        for (Vozilo vozilo : vozila) {
            if (vozilo.getRegistracija().equals(registracija)) {
                trazenoVozilo = vozilo;
                break;
            }
        }
            if (trazenoVozilo == null){
                System.out.println("Vozilo ne postoji");
            }else{
                System.out.println(trazenoVozilo.infoVozila());
            }


    }
    public static void ispisiSvaVozila(List<Vozilo> vozila){
        for (Vozilo vozilo : vozila) {
            System.out.println(vozilo.infoVozila());
        }
    }
}
