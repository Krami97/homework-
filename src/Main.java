import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Koliko  novca želite?");
        String novac = scanner.nextLine();

        kusur(novac);

    }
    public static void kusur(String novac){
        Float novacfloat = Float.valueOf(novac);
        while(novacfloat>0){
            if(novacfloat-500>=0){
                System.out.println(500);
                novacfloat = novacfloat - 500;
            }else if(novacfloat-200>=0){
                System.out.println(200);
                novacfloat = novacfloat -200;
            }else if(novacfloat-100>=0){
                System.out.println(100);
                novacfloat = novacfloat - 100;
            }else if(novacfloat-50>=0){
                System.out.println(50);
                novacfloat = novacfloat - 50;
            }else if(novacfloat-20>=0) {
                System.out.println(20);
                novacfloat = novacfloat - 20;
            }else if(novacfloat-10>=0) {
                System.out.println(10);
                novacfloat = novacfloat - 10;
            }else if(novacfloat-5>=0) {
                System.out.println(5);
                novacfloat = novacfloat - 5;
            }else if(novacfloat-2>=0) {
                System.out.println(2);
                novacfloat = novacfloat - 2;
            }else if(novacfloat-1>=0) {
                System.out.println(1);
                novacfloat = novacfloat - 1;
            }else if(novacfloat-0.5>=0) {
                System.out.println(0.5);
                novacfloat = (float) (novacfloat - 0.5);
            }else if(novacfloat-0.2>=0) {
                System.out.println(0.2);
                novacfloat = (float) (novacfloat - 0.2);
            }else if(novacfloat-0.1>=0) {
                System.out.println(0.1);
                novacfloat = (float) (novacfloat - 0.1);
            }else if(novacfloat-0.05>=0) {
                System.out.println(0.05);
                novacfloat = (float) (novacfloat - 0.05);
            }else if(novacfloat-0.02>=0) {
                System.out.println(0.02);
                novacfloat = (float) (novacfloat - 0.02);
            }else if(novacfloat-0.01>=0) {
                System.out.println(0.01);

                novacfloat = (float) (novacfloat - 0.01);
            }



        }
    }
}
