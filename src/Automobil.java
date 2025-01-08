public class Automobil extends Vozilo{

    private int brojVrata;


    public Automobil(String marka, String registarskaOznaka, int godniaProizbodnje,int brojVrata) throws NeispravniPodaciExcepiton {
        super(marka, registarskaOznaka,godniaProizbodnje);
        if (brojVrata<0){
            throw new NeispravniPodaciExcepiton();
        }
            this.brojVrata = brojVrata;


    }
    @Override
    public void prikaziPodatke(){
        super.prikaziPodatke();
        System.out.println("Broj vrata: "+this.brojVrata);
    }

    public void setBrojVrata(int brojVrata) {
        this.brojVrata = brojVrata;
    }

    public int getBrojVrata() {
        return brojVrata;
    }

    @Override
    public String toStirng() {
        return "\nMarka:" + this.getMarka() +
                "\nRegistarska onzaka: " + this.getRegistarskaOznaka() +
                "\nGodina proizbodnje: " + this.getGodniaProizbodnje()+
                "\nBroj vrata: "+this.brojVrata;
    }
}
