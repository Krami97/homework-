
public class Main {
    public static void main(String[] args) {
        Proizvod auto = new Proizvod("toyota",100000);
        auto.postaviPopust(30);
        System.out.println("Konacna cijena za " +auto.getNaziv() +" "+ auto.izracunajCijenu());
    }
}
