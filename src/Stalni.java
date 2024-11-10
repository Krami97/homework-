import java.math.BigDecimal;

public class Stalni extends Zaposlenik {
    private Double bonus = 0.15;
    private Integer uvjetZabonus = 160;
    private BigDecimal konacnaPlaca;

    public Stalni(String ime, BigDecimal onovnaPlaca, Integer brojSati){
        super(ime,onovnaPlaca,brojSati);
    }

    @Override
    public void izracunStvarnePlace() {
        if(this.getBrojRadnihSati()>=this.uvjetZabonus){
            this.konacnaPlaca = this.getOsnovnaPlaca().add(this.getOsnovnaPlaca().multiply(BigDecimal.valueOf(this.bonus)));

        }
        else{
            this.konacnaPlaca = this.getOsnovnaPlaca();
        }

    }
    @Override
    public void ispisPodatakaZaposlenika(){
        super.ispisPodatakaZaposlenika();
        System.out.println("Konacna placa: "+ this.konacnaPlaca);
        System.out.println(this.getClass().getName()+ " zaposlenik");
    }
}
