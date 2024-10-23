import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("Koliko elemenata želite unjeti u listu ?:");;
        int velicinaListe = scanner.nextInt();
        List<Integer> brojevi = new ArrayList<>();




        for(int i = 0; i< velicinaListe ; i++){
            System.out.printf("Upišite %d broj:\n",1+i);
            brojevi.add(scanner.nextInt());
        }

        int maxbroj = brojevi.get(0);
        int minbroj = brojevi.get(0);
        int suma = 0;

        for (Integer i : brojevi) {
            suma+=i;
            if(i <=minbroj){
                minbroj=i;
            }
            if(i >=maxbroj){
                maxbroj=i;
            }
        }

        float prosjek = (float) (suma-maxbroj-minbroj)/(brojevi.size()-2);
        System.out.printf("Prosjek svih brojeva iz liste bez maksa i mina je %f",prosjek);




    }
}
