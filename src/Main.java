import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Zaposlenik> zaposlenici = new ArrayList<>();
        int korisnikovOdabir;

        unosZapolenikaUListu(zaposlenici);
        izracunajStvarnuPlacuSvihZapolenika(zaposlenici);
        do{
            System.out.println("Odaberi 1 za unos jos zaposelnika");
            System.out.println("Odaberi 2 za ispis svih zaposlenika i njihovih podataka");
            System.out.println("Odaberi 3 za izlaz iz porgrama");
            korisnikovOdabir = scanner.nextInt();

            switch (korisnikovOdabir){
                case 1:
                    unosZapolenikaUListu(zaposlenici);
                    izracunajStvarnuPlacuSvihZapolenika(zaposlenici);
                    break;
                case 2:
                    ispisPodatakaSvihZaposlenika(zaposlenici);
                    break;
            }
        }while(korisnikovOdabir!=3);



    }
    public static void unosZapolenikaUListu(List<Zaposlenik> zaposlenici){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite ime zaposlenika: ");
        String ime = scanner.nextLine();
        System.out.println("Unesite broj radnih sati zaposlenika: ");
        Integer brojSati = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Unesiti osnovnu placu zaposlenika: ");
        BigDecimal osnovnaPlaca = java.math.BigDecimal.valueOf(scanner.nextDouble());
        scanner.nextLine();
        System.out.println("Unesi tip zaposlenika stalni/sezonski: ");
        String tipZaposlenika = scanner.nextLine();
        if (tipZaposlenika.equals("stalni")){
            zaposlenici.add(new Stalni(ime,osnovnaPlaca,brojSati));
        }else if(tipZaposlenika.equals("sezonski")){
            zaposlenici.add(new Sezonski(ime,osnovnaPlaca,brojSati));
        }else {
            System.out.println("Neispravan unos , pokušaj ponovno");
            unosZapolenikaUListu(zaposlenici);
        }
    }
    public static void izracunajStvarnuPlacuSvihZapolenika(List<Zaposlenik> zaposlenici){
        for (Zaposlenik zaposlenik : zaposlenici) {
            zaposlenik.izracunStvarnePlace();
        }
    }
    public static void ispisPodatakaSvihZaposlenika(List<Zaposlenik> zaposlenici){
        for (Zaposlenik zaposlenik : zaposlenici) {
            zaposlenik.ispisPodatakaZaposlenika();
            System.out.println(" ");
        }
    }

}
