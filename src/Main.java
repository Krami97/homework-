
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Saznaj broj znamenki nekog broja");
        System.out.println("Unesite neki cijeli broj:");
        int N = scanner.nextInt();
        int decimalPlaces = 0;
        if (N<0){
            N*=-1;
        }

        while (N>0){
            N/=10;
            decimalPlaces++;

        }

        System.out.println("Uneseni broj ima "+ decimalPlaces + " znamenke");



    }
}