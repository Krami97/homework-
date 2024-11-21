public class Zaposlenik {
    private String ime;
    private String prezime;
    private double placa;


    public Zaposlenik(String ime, String prezime, double placa){
        this.ime=ime;
        this.prezime = prezime;
        this.placa  = placa;
    }

    public void ispisiPodtkeZaposlenika(){
        System.out.println("Ime: "+this.ime+" Prezime: "+this.prezime+" Placa: "+this.placa);
    }

    public double getPlaca() {
        return placa;
    }
}
