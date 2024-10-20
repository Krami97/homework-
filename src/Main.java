import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numberList = new ArrayList<>();
        List<Integer> listaBrojaca = new ArrayList<>();

        // inicializacija liste brojaca na nulu
        for (int i = 0; i < 10; i++) {
            listaBrojaca.add(0);
        }
        // unos brojeva od starane korisnika
        for(int i = 0 ; i<10 ;i++){
            System.out.printf("Unesi %d. broj:\n",i+1);
            numberList.add(scanner.nextInt());
        }
        // provjera koliko se koji borj ponaclja?
        for (int i = 0 ;i<10;i++) {
            int trenutniBroj = numberList.get(i);
            for (Integer integer : numberList) {
                if(trenutniBroj== integer){
                    listaBrojaca.set(i,listaBrojaca.get(i)+1);
                }

            }

        }
        int maxTimes = Collections.max(listaBrojaca);
        int indexOfMax = listaBrojaca.indexOf(maxTimes);
        int maxTimesNumber = numberList.get(indexOfMax);
        if(maxTimes>1){
            System.out.printf("Najcesce unesen broj je %d i on je unesen %d puta",maxTimesNumber,maxTimes);
        }else{
            System.out.println("Nijedan unsesni borj nije unesen vise od jedanput");
        }
}
}