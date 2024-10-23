import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("Koliko elemenata želite unjeti u listu ?:");;
        int velicinaListe = scanner.nextInt();
        List<Integer> brojevi = new ArrayList<>();
        boolean duplicPostoji = false;

        for(int i = 0; i< velicinaListe ; i++){
            System.out.printf("Upišite %d broj:\n",1+i);
            brojevi.add(scanner.nextInt());
        }

        for (Integer i : brojevi) {
            int duplic = 0;

            for (Integer integer : brojevi) {
                if (i.equals(integer)) {
                    duplic++;
                }

            }
            if (duplic >= 2){
                duplicPostoji = true;
                break;
            }

        }
        System.out.println("duplic postoji:" + duplicPostoji);


    }
}
