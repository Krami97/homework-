
import java.util.HashSet;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        HashSet<String> odjelA = new HashSet<>();
        HashSet<String> odjelB = new HashSet<>();

        odjelA.add("Tin");
        odjelA.add("Hrvoje");
        odjelA.add("Pero");
        odjelA.add("Ana");

        odjelB.add("Tin");
        odjelB.add("Marko");
        odjelB.add("Zvonimir");
        odjelB.add("Ana");

        HashSet<String> unija = new HashSet<>();
        unija.addAll(odjelB);
        unija.addAll(odjelA);

        System.out.println("Unija odjela:");
        for (String string : unija) {
            System.out.println(string);
        }

        System.out.println("\nZaposlenici koji rade u oba skupa");
        for (String string : unija) {
            if (odjelA.contains(string) && odjelB.contains(string)){
                System.out.println(string);
            }
        }

        System.out.println("\nZaposlenici koji rade samo u jednom odjelu");
        for (String string : unija) {
            if (odjelA.contains(string) && odjelB.contains(string)){
                continue;
            }
            System.out.println(string);
        }







    }
}



