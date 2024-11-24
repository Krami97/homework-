import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Knjiznica implements Kjnjiznicar {
    private List<Clan> clanovi;
    private List<Knjiga> dostupneKnjige;
    private List<Knjiga> posudeneKnjige;

    public Knjiznica(){
        this.clanovi = new ArrayList<>();
        this.dostupneKnjige = new ArrayList<>();
        this.posudeneKnjige = new ArrayList<>();
    }

    public void unosKnjige(Knjiga knjiga){
        this.dostupneKnjige.add(knjiga);
    }

    /**
     * dodavanje nove knjige u knjiznicu
     *
     */
    public void korisnikUnesiNovuKnjiguUKnjiznicu(){
        System.out.println(" ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("ime knjige:");
        String imeKnjige = scanner.nextLine();
        System.out.println("Ime autora knjige:");
        String imeAutora = scanner.nextLine();
        System.out.println("Unestite godinu izdanja: ");
        int godinaIzdanja = scanner.nextInt();

        unosKnjige(new Knjiga(imeKnjige,imeAutora,godinaIzdanja));

    }

    @Override
    public void posudivanjeKnjige(Knjiga knjiga,Clan clan) {
        this.dostupneKnjige.remove(knjiga);
        this.posudeneKnjige.add(knjiga);
        clan.posudivanjeKnjige(knjiga);



    }

    @Override
    public void vracanjeKnjige(Knjiga knjiga,Clan clan) {
        this.posudeneKnjige.remove(knjiga);
        this.dostupneKnjige.add(knjiga);
        clan.vracanjeKnjige(knjiga);

    }


    /**
     * Registracija novog clana u knjiznicu
     */
    public void unosNovagClana(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite ime:");
        String ime = scanner.nextLine();
        System.out.println("Unestie Prezime:");
        String prezime = scanner.nextLine();
        int brojClana= this.clanovi.size()+1;
        this.clanovi.add(new Clan(ime,prezime,brojClana));
    }

    public List<Clan> getClanovi() {

        return clanovi;
    }

    public List<Knjiga> getDostupneKnjige() {
        return dostupneKnjige;
    }

    public List<Knjiga> getPosudeneKnjige() {
        return posudeneKnjige;
    }

    /**
     *
     * @param ime ima clana kojeg trazimo
     * @return vraca clana ako postoji ili null ako ne
     * @throws ClanNePostoji ako clan nepostoji
     */
    public Clan prodadiClanaPoImenu(String ime) throws ClanNePostoji {
        Clan trazeniClan  = null;

            for (Clan clan : this.clanovi) {
                if (ime.equals(clan.getIme()+" "+clan.getPrezime())) {
                    trazeniClan = clan;
                }
            }

        return trazeniClan;
    }

    /**
     *
     * @param ime ime knjige koju trazimeo
     * @param vracanjeIliPosudba String posudba ako je posudba , povrat ili prazan string ako je povat knigae
     * @return vraca knjigu ako je nade ili null
     * @throws KnjigaNijeDostupna ako knjiga ne postoji
     */
    public Knjiga prodadiKnjiguPoImenu(String ime, String vracanjeIliPosudba) throws KnjigaNijeDostupna {
        Knjiga trazenaKnjiga =null;
        if(vracanjeIliPosudba.equals("posudba")){
            for (Knjiga knjiga : this.dostupneKnjige) {
                if (knjiga.getIme().equals(ime)) {
                    trazenaKnjiga = knjiga;
                    break;
                }
            }

        }else{
            for (Knjiga knjiga : this.posudeneKnjige) {
                if (knjiga.getIme().equals(ime)) {
                    trazenaKnjiga = knjiga;
                    break;
                }
            }

        }
        return trazenaKnjiga;
    }

    /**
     * ispis dostupnih knjiga u knjiznici
     */
    public void ispisDostupnihKnjiga(){
        if (this.dostupneKnjige.isEmpty()){
            System.out.println("Trenutno su sve knjige psudene");
            System.out.println(" ");
        }else{
            System.out.println("Dostupne knjige su:");
            for (Knjiga knjiga : this.dostupneKnjige) {
                System.out.println(knjiga.toString());

            }

        }

    }

    /**
     * ispis posudenih knjiga u knjiznici
     */
    public void ispisPosudnjenihKnjiga(){
        if (this.posudeneKnjige.isEmpty()){
            System.out.println("Trenutno su sve knjige dostupne");
            System.out.println(" ");
        }else{
            System.out.println("Knjige koje su posudene:");
            for (Knjiga knjiga : this.posudeneKnjige) {
                System.out.println(knjiga.toString());

            }

        }

    }

    /**
     * ispis svih clanova knjiznice
     */
    public void ispisClanovaKnjiznice(){
        if (this.clanovi.isEmpty()){
            System.out.println("Knjiznica nema clanova");
            System.out.println(" ");
        }else{
            System.out.println("Clanovi knjiznice:");
            for (Clan clan : this.clanovi) {
                System.out.println(clan.toString());

            }

        }

    }


}
