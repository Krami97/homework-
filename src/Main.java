
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("unesi prvi cjeli broj: ");
        Integer number1 = scanner.nextInt();
        System.out.println("unesi drugi cijeli broj: ");
        Integer number2 = scanner.nextInt();
        System.out.println("odaberi matematičku operaciju: \n1 zbrajanje\n2 oduzimanje\n3 množenje\n4 djeljenje");
        int operator = scanner.nextInt();


        if (operator == 1){
            System.out.println(number1 + " + " + number2 + " = " +  (number2 + number1));
        } else if (operator == 2) {
            System.out.println(number1 + " - " + number2 + " = " +  (number2 - number1));
        } else if (operator == 3) {
            System.out.println(number1 + " * " + number2 + " = " +  (number2 * number1));
        } else if (operator == 4) {
            System.out.println(number1 + " / " + number2 + " = " +  ((float) number1 / number2));
        }

    }
}