import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userChoice = 0;
        List<String> brojevi =new ArrayList<>();
        List<String> imena = new ArrayList<>();

        do{
            System.out.println("Telefonski imenitk");
            System.out.println("Odaberite sljedecu akciju:");
            System.out.println("odaberite 1 za dodavanje novog kontakta u imenik");
            System.out.println("odaberite 2 za pretraživanje po imenu");
            System.out.println("odaberite 3 za pretraživanje po telefonskom broju korisnika");
            System.out.println("odaberite 4 za ispis cjelog imenika");
            System.out.println("odaberite 5 za izlaz");
            userChoice =  scanner.nextInt();

            switch (userChoice){
                case 1:
                    brojevi = dodajBroj(brojevi);
                    imena = dodajIme(imena);
                    break;

                case 2:
                    pretraziPoimenu(brojevi,imena);
                    break;
                case 3:
                    pretraziPoBroju(brojevi,imena);
                    break;
                case 4:
                    ispisTelefonskogImenika(brojevi,imena);
                    break;
                default:
                    System.out.println("krivi odabir");
            }

        }while(userChoice != 5);
        System.out.println("Izašli ste iz imenika");
    }
    public static List<String> dodajBroj(List<String> brojevi){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesitie Broj:");
        brojevi.add(scanner.nextLine());
        return brojevi;
    }
    public static List<String> dodajIme(List<String> imena){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesitie ime:");
        imena.add(scanner.nextLine());
        return imena;
    }
    public static void pretraziPoBroju(List<String> brojevi,List<String> imena){
        Scanner scanner = new Scanner(System.in);
        System.out.println("unesiti broj kako bi saznali ime");
        String broj  = scanner.nextLine();
        if(brojevi.contains(broj)){
            System.out.println("korisnik tog borja je:" + imena.get(brojevi.indexOf(broj)));
        }else{
            System.out.println("Korisnik toga broja ne postoji u imeniku");
        }
        System.out.println(" ");
    }
    public static void pretraziPoimenu(List<String> brojevi,List<String> imena){
        Scanner scanner = new Scanner(System.in);
        System.out.println("unesiti ime kako bi saznali broj korisnika");
        String ime  = scanner.nextLine();
        if(imena.contains(ime)){
            System.out.println("Korisnik "+ ime +" ima broj :" + brojevi.get(imena.indexOf(ime)));
        }else{
            System.out.println("U imeniku ne postoji korisnik sa tim imenom");
        }
        System.out.println(" ");
    }
    public static void ispisTelefonskogImenika(List<String> brojevi,List<String> imena){
        System.out.println("Kontakti u imeniku su:");
        for(int i = 0;i<imena.size(); i++){
            System.out.println(imena.get(i) +" | "+ brojevi.get(i));
        }
        System.out.println(" ");
    }



}