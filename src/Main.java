
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Koliko proizvoda zelite unjeti ");
        List<Proizvod> Proizvodi = new ArrayList<>();
        int brojProizvoda = scanner.nextInt();
        scanner.nextLine();

        for(int i= 0; i<brojProizvoda;i++){
            System.out.println("Unesite ime proizvoda:");
            String imeProizvoda = scanner.nextLine();
            System.out.println("Unesiti cijenu poroizvda");
            Integer cijena = scanner.nextInt();
            scanner.nextLine();
            Proizvodi.add(new Proizvod(imeProizvoda,cijena));
        }

        for (Proizvod proizvod : Proizvodi) {
            System.out.println("Proizvod "+ proizvod.getNaziv() + " ima cijenu "  + proizvod.getCijena() + " Koliko popust u % zelite dati?");
            proizvod.postaviPopust(scanner.nextInt());
        }
        for (Proizvod proizvod : Proizvodi) {
            System.out.println("Konacna cijena proizvoda "+proizvod.getNaziv()+" je "+ proizvod.izracunajCijenu());
        }






    }
}
