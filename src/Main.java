import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numberList = new ArrayList<>();


        for(int i = 0 ; i<10;i++){
            System.out.printf("Unesi %d. broj:\n",i+1);
            numberList.add(scanner.nextInt());
        }
        //Pronaženje najmanjeg i največeg broja u listi
        int minimum = Collections.min(numberList);
        int maximum = Collections.max(numberList);
        // Pronaženje indexa najmanjeg i največeg broja u listi
        int indexOfMinimum = numberList.indexOf(minimum);
        int indexOfMaximum = numberList.indexOf(maximum);
        // zamjena najmanjeg i največeg broja u listi
        numberList.set(indexOfMinimum,maximum);
        numberList.set(indexOfMaximum,minimum);
        // i
        System.out.println("Nova lista brojeva");
        for (Integer i : numberList) {
            System.out.printf("%d,",i);

        }
    }

}