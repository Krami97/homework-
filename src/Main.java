import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String,Polaznik> polaznici = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int izbor;
        do{
            System.out.println("Izaberi opicije:");
            System.out.println("1 dodaj polaznika");
            System.out.println("2 ispisi polaznike");
            System.out.println("0 izaz iz porgrama");
            izbor = scanner.nextInt();

            switch (izbor){
                case 1 :
                    dodavanjePolaznika(polaznici);
                    break;
                case 2 :
                    ispisPolaznika(polaznici);
                    System.out.println(" ");
                    break;
            }
        }while(izbor !=0 );

    }
    public static void dodavanjePolaznika(HashMap<String,Polaznik> polaznici){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ime polaznika");
        String ime = scanner.nextLine();
        System.out.println("Prezime polaznika");
        String prezime = scanner.nextLine();
        System.out.println("email polaznika");
        String email = scanner.nextLine();
        if(polaznici.containsKey(email)){
            System.out.println("Polaznik sa tim emailom vec postoji!\n");
        }else{
            polaznici.put(email,new Polaznik(ime,prezime,email));
            System.out.println("Polaznik kreiran\n");
        }
    }
    public static void ispisPolaznika(HashMap<String,Polaznik> polaznici){
        for (Polaznik value : polaznici.values()) {
            System.out.println(value);
        }
    }



}

