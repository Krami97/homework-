import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        TekuciRacun tekuci = new TekuciRacun("001", BigDecimal.valueOf(0.0),"Tin");
        StedniRacun stedni = new StedniRacun("002", BigDecimal.valueOf(0.0),"Sven");


        tekuci.uplataNovacaNaRacun(BigDecimal.valueOf(125));
        tekuci.isplataNovacaSaRacuna(BigDecimal.valueOf(25));

        stedni.uplataNovacaNaRacun(BigDecimal.valueOf(125));
        stedni.isplataNovacaSaRacuna(BigDecimal.valueOf(25));

        tekuci.obracunKamate();
        stedni.obracunKamate();
        tekuci.obracunKamate();
        stedni.obracunKamate();
        tekuci.obracunKamate();
        stedni.obracunKamate();
        tekuci.obracunKamate();
        stedni.obracunKamate();


    }

}
