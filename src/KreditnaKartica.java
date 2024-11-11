public class KreditnaKartica implements Placanje{
    private double iznos;
    @Override
    public void plati(double iznos){
        this.iznos = iznos;


    }
    @Override
    public String getDetalje(){
        return "Plaćanje putem kreditne kartice u iznosu od : "+this.iznos+" EUR";
    }
    @Override
    public double vratiIznos(){
    return this.iznos;
    }
}