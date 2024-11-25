public abstract class Vozilo {
    private String marka;
    private String model;
    private String registracija;

    public Vozilo(String marka, String model, String registracija){
        this.marka = marka;
        this.model = model;
        this.registracija = registracija;
    }

    public abstract String infoVozila();


    public String getRegistracija() {
        return registracija;
    }

    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }
}
