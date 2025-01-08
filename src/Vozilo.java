public abstract class Vozilo {
    private String marka;
    private String registarskaOznaka;
    private int godniaProizbodnje;

    public Vozilo(String marka, String registarskaOznaka, int godniaProizbodnje) throws NeispravniPodaciExcepiton {
        this.marka = marka;
        if (godniaProizbodnje < 0) {
            throw new NeispravniPodaciExcepiton();
        }
        this.godniaProizbodnje = godniaProizbodnje;
        this.registarskaOznaka = registarskaOznaka;
    }

    public String getMarka() {
        return marka;
    }

    public int getGodniaProizbodnje() {
        return godniaProizbodnje;
    }

    public String getRegistarskaOznaka() {
        return registarskaOznaka;
    }

    public void setGodniaProizbodnje(int godniaProizbodnje) {
        this.godniaProizbodnje = godniaProizbodnje;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public void setRegistarskaOznaka(String registarskaOznaka) {
        this.registarskaOznaka = registarskaOznaka;
    }

    public void prikaziPodatke() {
        System.out.println("Marka:" + this.marka);
        System.out.println("Registarska onzaka: " + this.registarskaOznaka);
        System.out.println("Godina proizbodnje: " + this.godniaProizbodnje);
    }

    public String toStirng() {
        return "Marka:" + this.marka +
                "\nRegistarska onzaka: " + this.registarskaOznaka +
                "\nGodina proizbodnje: " + this.godniaProizbodnje;
    }


}






