import java.math.BigDecimal;

public abstract class Zaposlenik {
    private String ime;
    private BigDecimal osnovnaPlaca;
    private Integer brojRadnihSati;


    public Zaposlenik(String ime , BigDecimal osnovnaPlaca, Integer brojRadnihSati){
        this.ime = ime;
        this.osnovnaPlaca = osnovnaPlaca;
        this.brojRadnihSati = brojRadnihSati;
    }

    public void ispisPodatakaZaposlenika(){
        System.out.println("Ime: "+this.ime);
        System.out.println("Broj radnik sati: "+this.brojRadnihSati+" h");
        System.out.println("Osnovna placa: "+this.osnovnaPlaca);

    }
    public BigDecimal getOsnovnaPlaca(){
        return this.osnovnaPlaca;
    }
    public Integer getBrojRadnihSati(){
        return this.brojRadnihSati;
    }
    public abstract void izracunStvarnePlace();

}
