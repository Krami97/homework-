
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Unesite iznos za platiti:");
        double iznosZaPlatiti = scanner.nextDouble();

        System.out.println("Odaberite nacin placanja: \n1.Kartica\n2.gotovina\n3.Paypal");
        int odabir = scanner.nextInt();

        switch (odabir){
            case 1:
                provediPlacanje(new KreditnaKartica(),iznosZaPlatiti);
                break;
            case 2:
                provediPlacanje(new Gotovina(),iznosZaPlatiti);
                break;
            case 3:
                provediPlacanje(new PayPal(),iznosZaPlatiti);
                break;
        }




    }
    public static void provediPlacanje( Placanje tipPlacanja, double iznosPlacanja){
        tipPlacanja.plati(iznosPlacanja);
        System.out.println(tipPlacanja.getDetalje());

    }


}
