
public class Knjiga {
    private String ime;
    private String autor;
    private int godinaIzdanja;

    /**
     * Kreira objekt knjige
     * @param ime knige
     * @param autor knjige
     * @param godinaIzdanja knjige
     */
    public Knjiga(String ime, String autor, int godinaIzdanja){
        this.ime = ime;
        this.autor = autor;
        this.godinaIzdanja = godinaIzdanja;
    }

    public void ispisPodataka(){
        System.out.println("Ime: "+this.ime+" Prezime: "+this.autor+" Itdanje : "+this.godinaIzdanja);
    }

    public String getIme() {
        return ime;
    }
}
