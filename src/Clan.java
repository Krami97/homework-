import java.util.ArrayList;
import java.util.List;

public class Clan{
    private String ime;
    private String prezime;
    private int clanskiBroj;
    private List<Knjiga> posudeneKnjige;

    public Clan(String ime, String prezime, int clanskiBroj){
        this.ime = ime;
        this.prezime = prezime;
        this.clanskiBroj = clanskiBroj;
        this.posudeneKnjige = new ArrayList<>();
    }

    public List<Knjiga> getPosudeneKnjige() {
        return posudeneKnjige;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public int getClanskiBroj() {
        return clanskiBroj;
    }

    /**
     * Brise knjigu sa korisnikove liste ,
     * koristi se kada kosrinik vrati knjigu
     * @param knjiga knjiga koju korisnik vraca
     */

    public void vracanjeKnjige(Knjiga knjiga){
        this.posudeneKnjige.remove(knjiga);

    }

    /**
     * Dodaje kjigu na korisnikkovu listu
     * koristi se kada korisnik posudi kjigu
     * @param knjiga posudena knjiga
     */
    public void posudivanjeKnjige(Knjiga knjiga){
        this.posudeneKnjige.add(knjiga);
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Knjiga knjiga : this.posudeneKnjige) {
            sb.append(knjiga.toString()).append("\n");
        }
        return "Ime: "+this.ime+" Prezime: "+this.prezime+" Clanski Broj: "+this.clanskiBroj+ "\nPosuđene Knjige:\n"+sb;


    }
}

