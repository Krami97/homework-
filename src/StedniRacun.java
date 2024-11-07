import java.math.BigDecimal;

public class StedniRacun extends Racun {
    private BigDecimal kamata = BigDecimal.valueOf(1.5);

    public StedniRacun(String brojRacuna,BigDecimal stanje, String vlasnik){
        super(brojRacuna,stanje,vlasnik);
    }
    @Override
    public void obracunKamate(){
        BigDecimal iznosKamate = this.getStanje().multiply(this.kamata.divide(BigDecimal.valueOf(100)));
        this.setStanje(this.getStanje().add(iznosKamate));
        this.ispisiPodatkeRacna();
        System.out.println("To je novo stanje racuna nakon obracuna kamate od 0.1% iznosa " + iznosKamate);
        System.out.println(" ");

    }
}
