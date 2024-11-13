import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer unos = null;
        long rezultat = 0;

        System.out.println("Unesite broj");
        try {
            unos = scanner.nextInt();

            rezultat = izracunajFaktorijel(unos);
            System.out.println("Faktorijel od broja " + unos + " iznosi " + rezultat);
        } catch (InputMismatchException e) {
            System.out.println("Greška: Molimo unesite cijeli broj.");
        } catch (Exception e) {
            System.out.println("Greška: " + e.getMessage());
        }
    }

    public static long izracunajFaktorijel(int broj) throws Exception {
        if (broj < 0) {
            throw new Exception("Faktorijel nije definiran za negativne brojeve.");
        }
        long rezultat = 1;
        for (int i = 1; i <= broj; i++) {
            rezultat *= i;
        }
        return rezultat;
    }
}

