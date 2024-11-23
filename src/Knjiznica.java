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

    /**
     * dodavanje nove knjige u knjiynicu
     * @param knjiga koja se dodaje u knjiznicu , kako bi se mogal posu]ivati
     */
    public void unesiNovuKnjiguUKnjiznicu(Knjiga knjiga){
        dostupneKnjige.add(knjiga);

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
     * registrira novog clana u knjiznicu
     * @param clan
     */
    private void dodajNovogClana(Clan clan){
        this.clanovi.add(clan);
    }


    public void unosNovagClana(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite ime:");
        String ime = scanner.nextLine();
        System.out.println("Unestie Prezime:");
        String prezime = scanner.nextLine();
        int brojClana= this.clanovi.size()+1;
        dodajNovogClana(new Clan(ime,prezime,brojClana));
    }

    public List<Clan> getClanovi() {
        return clanovi;
    }

    /**
     *
     * @param ime
     * @return
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
    public Knjiga prodadiKnjiguPoImenu(String ime) throws KnjigaNijeDostupna {
        Knjiga trazenaKnjiga =null;

            for (Knjiga knjiga : this.dostupneKnjige) {
                if (knjiga.getIme().equals(ime)) {
                    trazenaKnjiga = knjiga;
                }
            }
            return trazenaKnjiga;
    }

}
