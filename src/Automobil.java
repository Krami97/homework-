public class Automobil extends Vozilo{
    private String marka;
    private String model;
    private String registracija;
    private int brojSjedala;
    private String gorivo;

    public Automobil(String marka, String model, String registracija,int brojSjedala,String gorivo) {
        super(marka, model, registracija);
        this.brojSjedala = brojSjedala;
        this.gorivo = gorivo;
    }


    @Override
    public String infoVozila() {
        return "Auto marke: "+ this.getMarka()+
                "\nmodela: "+ this.getModel()+
                "\nregistraciske oznake: "+this.getRegistracija()+
                "\nBroj sjedala: "+this.brojSjedala+
                "\nGorivo: "+this.gorivo+"\n";
    }
}
