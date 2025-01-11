import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*Zadatak 3: Kategorije proizvoda koristeći Map i List
Napišite program koji simulira sustav za upravljanje proizvodima:
1. Koristi HashMap gdje je ključ ime kategorije (npr. "Voće", "Povrće"), a vrijednost je Lista proizvoda u toj kategoriji.
2. Dodaje proizvode u kategorije (npr. "Jabuka" u "Voće").
3. Omogućuje prikaz svih proizvoda unutar određene kategorije.
4. Prikazuje sve kategorije i proizvode u njima.
 */
public class Main {
    public static void main(String[] args) {
    //TODO 1. Koristi HashMap gdje je ključ ime kategorije (npr. "Voće", "Povrće"), a vrijednost je Lista proizvoda u toj kategoriji.
    //TODO 2. Dodaje proizvode u kategorije (npr. "Jabuka" u "Voće").
        HashMap<String, ArrayList<String>> voceIPovrce = new HashMap<>();
        ArrayList<String> voce = new ArrayList<>(Arrays.asList("jabuka","kruška","banana","Kiwi","jagoda"));
        ArrayList<String> povrce  = new ArrayList<>(Arrays.asList("brokula","krastavac","mrkva","paprika","račica"));
        voceIPovrce.put("voce",voce);
        voceIPovrce.put("povrce",povrce);

    //TODO 3. Omogućuje prikaz svih proizvoda unutar određene kategorije.
    //TODO 4. Prikazuje sve kategorije i proizvode u njima.
        Scanner scanner = new Scanner(System.in);
        int korisnickiIzbor;
        do{
            System.out.println("Odaberi:");
            System.out.println("1 za prikaz voca");
            System.out.println("2 za prikaz povrca");
            System.out.println("3 za pirkaz svega");
            System.out.println("0 za izlaz");
            korisnickiIzbor = scanner.nextInt();

            switch (korisnickiIzbor){
                case 1:
                    ispisiVoce(voceIPovrce);
                    break;
                case 2:
                    ispisiPovrce(voceIPovrce);
                    break;
                case 3:
                    ispisSveVoceIPovrce(voceIPovrce);

            }

        }while(korisnickiIzbor!= 0);




    }
    public static void ispisiVoce(HashMap<String, ArrayList<String>> voceIPovrce){
        System.out.println("Voće:");
        for (String voce : voceIPovrce.get("voce")) {
            System.out.println(voce);
        }
    }
    public static void ispisiPovrce(HashMap<String, ArrayList<String>> voceIPovrce){
        System.out.println("Povrće:");
        for (String povrce : voceIPovrce.get("povrce")) {
            System.out.println(povrce);
        }
    }
    public static void ispisSveVoceIPovrce(HashMap<String, ArrayList<String>> voceIPovrce){
        for (String string : voceIPovrce.keySet()) {
            System.out.println(string+":");
            for (String s : voceIPovrce.get(string)) {
                System.out.println(s);
            }
        }
    }

}

