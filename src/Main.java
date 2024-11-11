
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
                Placanje kartica = new KreditnaKartica();
                kartica.plati(iznosZaPlatiti);
                System.out.println(kartica.getDetalje());
                break;
            case 2:
                Placanje gotovina = new Gotovina();
                gotovina.plati(iznosZaPlatiti);
                System.out.println(gotovina.getDetalje());
                break;
            case 3:
                Placanje paypal = new PayPal();
                paypal.plati(iznosZaPlatiti);
                System.out.println(paypal.getDetalje());
                break;
        }




    }


}
