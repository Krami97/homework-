
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int odabir ;
        Knjiznica knjiznica = new Knjiznica();
        // dodavanje nekih pocetnih knjiga
        knjiznica.unosKnjige(new Knjiga("Basic Economics","Thomas Sowell",2014));
        knjiznica.unosKnjige(new Knjiga("Kiklop","Ranko Marinkovic",1965));
        knjiznica.unosKnjige(new Knjiga("Free Will","Sam Harris",2012));
        knjiznica.unosKnjige(new Knjiga("Deep Work","Cal Newport",2016));
        knjiznica.unosKnjige(new Knjiga("Dopamine Nation","Anna Lembke",2021));
        knjiznica.unosKnjige(new Knjiga("Ultralearning","Scott H. Young",2019));
        do{
            System.out.println(" ");
            System.out.println("Knjiznica odabir:");
            System.out.println(
                    "1.uclnai se u knjiznicu\n" +
                    "2.posudi knjigu\n" +
                    "3.vrati knjigu\n" +
                    "4.dostupne knjige\n" +
                    "5.posudene knjige\n" +
                    "6.ispis clanova\n" +
                    "7.dodaj novu knjigu u knjiznicu\n"+
                    "0.izlaz");
            odabir =scanner.nextInt();
            switch (odabir){
                case 1:
                    knjiznica.unosNovagClana();
                    break;
                case 2:
                    posudivanjeKjige(knjiznica);
                    break;
                case 3:
                    vracanjeKnjige(knjiznica);
                    break;
                case 4:
                    knjiznica.ispisDostupnihKnjiga();
                    break;
                case 5:
                    knjiznica.ispisPosudnjenihKnjiga();
                    break;
                case 6:
                    knjiznica.ispisClanovaKnjiznice();
                    break;
                case 7:
                    knjiznica.korisnikUnesiNovuKnjiguUKnjiznicu();
                    break;
                default:
                    zapisPodataka(knjiznica);
                    ispisPodataka(knjiznica);
            }

        }while(odabir!=0);

    }

    /**
     *
     * @param knjiznica u kojoj se posuduju knjige
     * @return vraca clana knjiznicae ako je uclanjen ili null ako nije
     * @throws ClanNePostoji ako clan ne postoji
     */
    public static Clan autentikacijaClana(Knjiznica knjiznica) throws ClanNePostoji {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ime i Prezime clana: ");
        String imeClana = scanner.nextLine();

        Clan clan = knjiznica.prodadiClanaPoImenu(imeClana);
        if (clan == null) {
            throw new ClanNePostoji();
        }
        return clan;


    }

    /**
     *
     * @param knjiznica u kojoj se psudjuje knjga
     * @return vraca knjigu ako postoji ,ako ne vraca null ( provjerava u posudenima i dostupnima)
     * @throws KnjigaNijeDostupna baca ako nemoze naci knjigu u knjiznici
     */
    public static Knjiga autentikacijaKnjige(Knjiznica knjiznica,String status) throws  KnjigaNijeDostupna {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("ime knjige");
        String imeKnjige = scanner.nextLine();
        Knjiga knjiga = knjiznica.prodadiKnjiguPoImenu(imeKnjige,status);
        if (knjiga == null){
            throw new KnjigaNijeDostupna();
        }
        return knjiga;


    }

    public static void posudivanjeKjige(Knjiznica knjiznica){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ");

        try{
            Clan clan = autentikacijaClana(knjiznica);
            Knjiga knjiga = autentikacijaKnjige(knjiznica,"posudba");
            knjiznica.posudivanjeKnjige(knjiga,clan);
            }
        catch (ClanNePostoji e){
            System.out.println(" ");
            System.out.println("korisnik ne postoji");
            System.out.println("Dali se zelite registrirati? da/ne");
            String odgovorKorisnika = scanner.nextLine();
            if (odgovorKorisnika.equals("da")) {
                knjiznica.unosNovagClana();
            }
        }
        catch (KnjigaNijeDostupna e){
            System.out.println("Knjiga koju ster trazili trenutno nedostupna");
            System.out.println(" ");

        }

    }
    public static void vracanjeKnjige(Knjiznica knjiznica){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ");
        try{
            Clan clan = autentikacijaClana(knjiznica);
            Knjiga knjiga = autentikacijaKnjige(knjiznica,"vracanje");
            knjiznica.vracanjeKnjige(knjiga,clan);
        }
        catch (ClanNePostoji e){
            System.out.println(" ");
            System.out.println("Nemamo vas u sustavu!");
            System.out.println("Dali se zelite registrirati? da/ne");
            String odgovorKorisnika = scanner.nextLine();
            if (odgovorKorisnika.equals("da")) {
                knjiznica.unosNovagClana();
            }
        }
        catch (KnjigaNijeDostupna e){
            System.out.println("Tu knjigu niste posudili od nas");
            System.out.println(" ");

        }


    }
    public static void zapisPodataka(Knjiznica knjiznica) throws IOException {
        FileWriter zapisKnjiznice = new FileWriter("Tvrtka.txt");
        zapisKnjiznice.write("Dosupne knjige:\n");
        for (Knjiga knjiga : knjiznica.getDostupneKnjige()) {
            zapisKnjiznice.write(knjiga.toString()+"\n");
        }
        zapisKnjiznice.write("\nPosudene Knjige:\n");
        for (Knjiga knjiga : knjiznica.getPosudeneKnjige()) {
            zapisKnjiznice.write(knjiga.toString()+"\n");
        }

        zapisKnjiznice.close();

        FileWriter zapisClanova = new FileWriter("Clanovi.txt");
        zapisClanova.write("\nClanovi Knjiznice:\n");
        for (Clan clan : knjiznica.getClanovi()) {
            zapisClanova.write("\n"+clan.toString()+"\n");
        }
        zapisClanova.close();
    }

    public static void ispisPodataka(Knjiznica knjiznica) throws IOException {
        BufferedReader citanjeKnjiznice = new BufferedReader(new FileReader("Tvrtka.txt"));
        String redak;
        while ((redak = citanjeKnjiznice.readLine()) != null) {
            System.out.println(redak);
        }
        citanjeKnjiznice.close();

        BufferedReader citanjeClanova = new BufferedReader(new FileReader("Clanovi.txt"));
        String line;
        while ((line = citanjeClanova.readLine()) != null) {
            System.out.println(line);
        }
        citanjeClanova.close();
        }


}
