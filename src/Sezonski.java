import java.math.BigDecimal;

public class Sezonski extends Zaposlenik{
    private Double bonus = 0.10;
    private Integer uvjetZabonus = 200;
    private BigDecimal konacnaPlaca;


    public Sezonski(String ime, BigDecimal onovnaPlaca, Integer brojSati){
        super(ime,onovnaPlaca,brojSati);
    }
    @Override
    public void izracunStvarnePlace() {

        if (this.getBrojRadnihSati() >= this.uvjetZabonus) {
            this.konacnaPlaca = this.getOsnovnaPlaca().add(this.getOsnovnaPlaca().multiply(BigDecimal.valueOf(this.bonus)));

        } else {
            this.konacnaPlaca = getOsnovnaPlaca();
        }
    }
    @Override
    public void ispisPodatakaZaposlenika(){
        super.ispisPodatakaZaposlenika();
        System.out.println("Konacna placa: "+ this.konacnaPlaca);
        System.out.println(this.getClass().getName()+ " zaposlenik");
    }
}
