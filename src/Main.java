
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int najveciBroj;
        System.out.println("Koliko brojeva želite unjesti?");
        int velicinaPolja = scanner.nextInt();
        int[] polje = new int[velicinaPolja];

        for(int i = 0;i<polje.length;i++){
            System.out.printf("Unesi %d broj\n",i+1);
            polje[i]= scanner.nextInt();
        }
        najveciBroj = polje[0];

        for (int i : polje) {
            if (i > najveciBroj){
                najveciBroj = i;
            }
        }
        System.out.printf("od svih unesenih brojeva najveci je %d",najveciBroj);



    }
}
