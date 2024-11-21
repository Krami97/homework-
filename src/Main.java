import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws PrazanString, NemozeNulaImanjiodNule {
        Scanner scanner = new Scanner(System.in);

        Tvrtka tvrtka = new Tvrtka("Algebra");

        for(int i = 0;i<3;i++){
            tvrtka.dodajZaposlenika(unosPodatkaZaposlenika());
        }

        int korisnikovOdabir;
        do {
            System.out.println("Odaberite:" +
                    "\n1. Unos zaposlenika" +
                    "\n2. Ispis svih Zaposlnika" +
                    "\n3. Za pronalazenje zapolenika sa najcecom placom" +
                    "\n4. Za izlaz iz programa");

            korisnikovOdabir = scanner.nextInt();
            switch (korisnikovOdabir){
                case 1:
                    tvrtka.dodajZaposlenika(unosPodatkaZaposlenika());
                    break;
                case 2:
                    tvrtka.ispisZaposlenika();
                    break;
                case 3:
                    Zaposlenik zaposlenik = tvrtka.prondjiNajvecuPlacu();
                    System.out.println("zaposlenik sa najcecom placom je:");
                    zaposlenik.ispisiPodtkeZaposlenika();
                    break;
                default:
                    System.out.println("krivi unos");


            }
        }while(korisnikovOdabir!=4);
        

    }

    public static Zaposlenik unosPodatkaZaposlenika() throws PrazanString, NemozeNulaImanjiodNule {
        Scanner scanner = new Scanner(System.in);
        String ime;
        String prezime;
        double placa;
        System.out.println("Unestie ime zaposlenika");
        ime = scanner.nextLine();
        System.out.println("Uneste prezime zaposlenika");
        prezime = scanner.nextLine();

        if(ime.isEmpty() || prezime.isEmpty()){
            throw new PrazanString();
        }
        System.out.println("Uneste placu zaposlenika ");
        placa = scanner.nextDouble();
        if(placa<= 0){
            throw new NemozeNulaImanjiodNule();
        }



        return new Zaposlenik(ime,prezime,placa);

        }

}



