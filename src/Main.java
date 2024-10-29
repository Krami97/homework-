
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Koliko  novca želite?");
        String novac = scanner.nextLine();

        kusur(novac);

    }
    public static void kusur(String novac){
        Double[] listaNovcanica = {500.0,200.0,100.0,50.0,20.0,10.0,5.0,2.0,1.0,0.5,0.2,0.1,0.05,0.02,0.01};
        Double novacdouble = Double.valueOf(novac);

        int i = 0;
        System.out.println("vracamo vam:");;
        while(novacdouble>0 && i< listaNovcanica.length){
            novacdouble = Math.round(novacdouble * 100.0) / 100.0;
            if (novacdouble-listaNovcanica[i]>=0){
                System.out.println(listaNovcanica[i]);
                novacdouble-=listaNovcanica[i];
            }else{
                i++;
            }




        }
    }
}
