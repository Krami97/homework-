import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> brojevi = new ArrayList<>();

        System.out.println("koliko brojeva zelite unjeti:");
        int brojUnosa = scanner.nextInt();

        for(int i = 0; i<brojUnosa; i++){
            System.out.printf("unesite %d broj",i+1);
            brojevi.add(scanner.nextInt());
        }

        System.out.println("Lista je uzlazno sortirana je :"+ uzlaznoSoritiranaLista(brojevi));




    }
    public static boolean uzlaznoSoritiranaLista(List<Integer> listaBrojeva){
        int trenutniBroj = listaBrojeva.get(0);
        for (Integer i : listaBrojeva) {
            if (i>= trenutniBroj){
                trenutniBroj=i;
            }else{
                return false;
            }
        }
        return true;
    }
}
