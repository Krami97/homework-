import java.util.ArrayList;
import java.util.List;

public class Razred {

    private String ime;

    private String imeRazrednika;

    private List<Ucenik> ucenici;

    public Razred(String ime, String imeRazrednika) {
        this.ime = ime;
        this.imeRazrednika = imeRazrednika;
        this.ucenici = new ArrayList<>();
    }

    public Razred(String ime, String imeRazrednika, List<Ucenik> ucenici) {
        this.ime = ime;
        this.imeRazrednika = imeRazrednika;
        this.ucenici = ucenici;
    }

    public List<Ucenik> getUcenici() {
        return this.ucenici;
    }

    public void setUcenici(List<Ucenik> ucenici) {
        this.ucenici = ucenici;
    }

    public void dodajUcenike(List<Ucenik> noviUcenici) {
        this.ucenici.addAll(noviUcenici);
    }

    public void dodajUcenika(Ucenik ucenik) {
        this.ucenici.add(ucenik);
    }

    public void zamjeniUcenika(Ucenik ucenik, Integer index) {
        this.ucenici.set(index, ucenik);
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getImeRazrednika() {
        return imeRazrednika;
    }

    public void setImeRazrednika(String imeRazrednika) {
        this.imeRazrednika = imeRazrednika;
    }
    public void pronadiNajboljegUcenika(){
        Ucenik najbolji = ucenici.get(0);
        for(int i = 1;i<ucenici.size();i++)
            if (ucenici.get(i).getOcjena() > najbolji.getOcjena()) {
                najbolji = ucenici.get(i);
            }
        System.out.println("Najbolji ucenik je :");
        najbolji.ispisiInfo();
    }

}