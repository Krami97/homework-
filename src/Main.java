
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        // kreiranje hashSeta
        HashSet<String> studenti = new HashSet<>();
        // dodavanje vrijednosti u hash set
        studenti.add("Tin");
        studenti.add("Marko");
        studenti.add("Pero");
        studenti.add("Ivan");

        // provjer adali skup sadrži određenu vrijednost
        if(studenti.contains("Marko")){
            System.out.println("Marko postoji");
        }else{
            System.out.println("Marko ne postoji");
        }


        //ispis svih elementa hashSeta pomocu for petlje
        for (String string : studenti) {
            System.out.println(string);
        }
        //uklanjanje jednog imena iz skupa
        studenti.remove("Tin");
        System.out.println(studenti);
    }
}



