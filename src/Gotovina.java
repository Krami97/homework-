public class Gotovina implements Placanje {
    private double iznos;
    @Override
    public void plati(double iznos){
        this.iznos = iznos;


    }
    @Override
    public String getDetalje(){
        return "Plaćanje u gotovini u iznosu od : "+this.iznos+" EUR";
    }
    @Override
    public double vratiIznos(){
        return this.iznos;
    }
}

