import java.util.ArrayList;
import java.util.List;

public class Tvrtka {
    private String imeTvrtke;
    private List<Zaposlenik> zaposlenici;


    public Tvrtka(String ime ){
        this.imeTvrtke = ime;
        this.zaposlenici = new ArrayList<>();
    }
    public Tvrtka(String ime ,List<Zaposlenik> zaposlenici ){
        this.imeTvrtke = ime;
        this.zaposlenici = zaposlenici;
    }

    public void dodajZaposlenika(Zaposlenik zaposlenik){
        this.zaposlenici.add(zaposlenik);
    }

    public void ispisZaposlenika(){
        for (Zaposlenik zaposlenik : zaposlenici) {
            zaposlenik.ispisiPodtkeZaposlenika();
        }
    }
    public Zaposlenik prondjiNajvecuPlacu(){
        Zaposlenik ZaposlenikSaNajvecaPlaca = this.zaposlenici.get(0);
        for(int i = 1;i < zaposlenici.size();i++){
            if (ZaposlenikSaNajvecaPlaca.getPlaca()< zaposlenici.get(i).getPlaca()){
                ZaposlenikSaNajvecaPlaca = zaposlenici.get(i);
            }
        }
        return ZaposlenikSaNajvecaPlaca;
    }


}
