public class Motocikl extends Vozilo{
    private String tipMotora;

    public Motocikl(String marka, String registarskaOznaka, int godniaProizbodnje,String tipMotora) throws NeispravniPodaciExcepiton {
        super(marka, registarskaOznaka, godniaProizbodnje);
        this.tipMotora = tipMotora;
    }

    public void setTipMotora(String tipMotora) {
        this.tipMotora = tipMotora;
    }

    public String getTipMotora() {
        return tipMotora;
    }

    @Override
    public void prikaziPodatke() {
        super.prikaziPodatke();
        System.out.println("Tip Motora: " + this.tipMotora);
    }
    @Override
    public String toStirng() {
        return "Marka:" + this.getMarka() +
                "\nRegistarska onzaka: " + this.getRegistarskaOznaka() +
                "\nGodina proizbodnje: " + this.getGodniaProizbodnje()+
                "\nTip motora: "+this.tipMotora;
    }
}
