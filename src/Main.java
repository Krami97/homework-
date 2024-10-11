
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Unos brojeva dok ne postignemo određeni zbroj");
        int setNumber = 166;
        int attempts = 0 ;
        int sum = 0;
        int choice;

        do{
            System.out.println("Unesi borj: ");
            choice = scanner.nextInt();
            if (choice > 0){
                sum+=choice;

            }
            attempts++;
        }while (sum< setNumber && choice != 0 );

        System.out.println("suma unesenih brojeva= " + sum);

        // ovaj if sam dodao jer nisam bio sigurn dali zelis da se broj pokusaja ispise ako ako koirisnik unese 0
        if (choice>0){
            System.out.println("broj pokusaja= " + attempts);
        }

    }
}
//također nisam bio sigurn dali želiš da se negativni brojebi broje kao pokusaji ali zakljucio sam da vjerovatno da 