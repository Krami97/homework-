public class Polaznik {
    private String ime;
    private String prezime;
    private Integer dob;
    private String spol;



    public Polaznik(String ime, String prezime){
        this.ime = ime;
        this.prezime = prezime;

    }
    public Polaznik(String ime, String prezime , Integer dob, String spol){

    }
    public Polaznik(){

    }
    public String getIme(){
        return this.ime;
    }
    public String getPrezime(){
        return this.prezime;
    }
    public void setDob(Integer dob){
        this.dob = dob;
    }
    public void setIme(String ime){
        this.ime = ime;
    }
    public void setPrezime(String prezime){
        this.prezime = prezime;
    }
}
