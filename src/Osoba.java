public class Osoba {
    public final String ime;
    public final String  prezime;
    public final String datumRodenjaYYYYMMDD;

    public Osoba(String ime, String prezime, String datumRodenjaYYYYMMDD) {
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodenjaYYYYMMDD = datumRodenjaYYYYMMDD;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getDatumRodenjaYYYYMMDD() {
        return datumRodenjaYYYYMMDD;
    }
}
