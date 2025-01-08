
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<String> gradovi = new TreeSet<>();
        
        gradovi.add("Zagreb");
        gradovi.add("Split");
        gradovi.add("Rijeka");
        gradovi.add("Šibenik");
        gradovi.add("Vinkovci");


        for (String string : gradovi) {
            System.out.println(string);
        }

        System.out.println(gradovi.first());
        System.out.println(gradovi.last());
        gradovi.remove("Rijeka");

        for (String string : gradovi) {
            System.out.println(string);
        }

    }
}



