public class Kamion extends Vozilo{
    private String marka;
    private String model;
    private String registracija;
    private int nosivostKG;
    private int prikolice;
    public Kamion(String marka, String model, String registracija, int nosivostKG, int prikolice) {
        super(marka, model, registracija);
        this.nosivostKG = nosivostKG;
        this.prikolice = prikolice;
    }

    @Override
    public String infoVozila() {
        return "Kamion marke: "+ this.getMarka()+
                "\nmodela: "+ this.getModel()+
                "\nRegistraciske oznake: "+this.getRegistracija()+
                "\nNosivosti: "+this.nosivostKG+
                "\nBroj prikolica: "+this.prikolice+"\n";
    }
}
