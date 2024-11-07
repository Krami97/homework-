import java.math.BigDecimal;

public abstract class Racun {
    private String brojRacuna;
    private BigDecimal stanje;
    private String vlasnik;





    public Racun(String brojRacuna, BigDecimal stanje, String vlasnik){
        this.brojRacuna = brojRacuna;
        this.stanje = stanje;
        this.vlasnik = vlasnik;


    }

    public void uplataNovacaNaRacun(BigDecimal iznosUplate){
        this.stanje=stanje.add(iznosUplate);
    }
    public void isplataNovacaSaRacuna(BigDecimal iznosIsplate){
        this.stanje=stanje.subtract(iznosIsplate);
    }
    public BigDecimal getStanje(){
        return this.stanje;
    }
    public void setStanje(BigDecimal novoStanje){
        this.stanje = novoStanje;
    }
    public abstract void obracunKamate();

    public void ispisiPodatkeRacna(){
        System.out.print("Ime vlasnika: "+ this.vlasnik);
        System.out.print(" Broj računa: "+ this.brojRacuna);
        System.out.print(" Stanje na računau: "+ this.stanje + "$\n");
    }


}
