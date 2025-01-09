public class Polaznik {
    private final String ime;
    private final String prezime;
    private final String email;


    public Polaznik(String ime, String prezime, String email) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getIme() {
        return ime;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString(){
        return ime+ " " + prezime + " " + email;

    }
}
