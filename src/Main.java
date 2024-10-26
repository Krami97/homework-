import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesi rečienicu:");
        String recenica = scanner.nextLine();


        wordStats(recenica);




    }
    public static void wordStats(String recenica){
        String[] rijeci =recenica.split(" ");
        String najdulajaRijec = rijeci[0];
        int brojacSlova = 0;
        List<String> rijeciPetPlus = new ArrayList<>();

        for (String s : rijeci) {
            brojacSlova+= s.length();
            if(s.length()>najdulajaRijec.length()){
                najdulajaRijec = s;
            }
            if(s.length()>5){
                rijeciPetPlus.add(s);
            }
        }
        System.out.println("Najduza rejc je :" + najdulajaRijec);
        float prosjecnaDuljinaRijeci = (float) brojacSlova/ rijeci.length;
        System.out.println("Prosjecna duljina rijeci je :"+prosjecnaDuljinaRijeci);
        System.out.println("Rjeci dulje od 5 znakova su :");
        for (String petPlus : rijeciPetPlus) {
            System.out.println(petPlus);

        }
    }

}