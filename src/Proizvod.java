import java.math.BigDecimal;
import java.math.RoundingMode;

public class Proizvod {
    private String naziv;
    private BigDecimal cijena;
    private BigDecimal popust;

    public Proizvod(String naziv,Integer cijena){
        this.naziv = naziv;
        this.cijena = BigDecimal.valueOf(cijena);

    }
    public void postaviPopust(Integer popust){
        this.popust = BigDecimal.valueOf(popust);
    }
    public BigDecimal izracunajCijenu(){
        BigDecimal popust = this.cijena.multiply(this.popust).divide(new BigDecimal(100),2, RoundingMode.HALF_UP);
        return this.cijena.subtract(popust);
    }
    public String getNaziv(){
        return this.naziv;
    }
}
