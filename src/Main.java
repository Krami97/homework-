
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int odabir = 0;
        Knjiznica knjiznica = new Knjiznica();
        do{
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


            }

        }while(odabir!=0);

    }
    public static void posudivanjeKjige(Knjiznica knjiznica){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("ime knjige");
        String imeKnjige = scanner.nextLine();
        System.out.println("Ime Clana");
        String imeClana  = scanner.nextLine();
        try{
            Clan clan = knjiznica.prodadiClanaPoImenu(imeClana);
            if(clan == null){
                throw new ClanNePostoji();
            }
            Knjiga knjiga = knjiznica.prodadiKnjiguPoImenu(imeKnjige);
            if (knjiga == null){
                throw new KnjigaNijeDostupna();
            }
            knjiznica.posudivanjeKnjige(knjiga,clan);


        }catch (ClanNePostoji e){
            System.out.println(" ");
            System.out.println("korisnik ne postoji");
            System.out.println("Prvo se registrirajte");
            knjiznica.unosNovagClana();

        }catch (KnjigaNijeDostupna e){
            System.out.println("Knjiga koju ster trazili trenutno nepostoji");

        }

    }





}



