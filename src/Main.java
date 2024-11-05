import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> Studenti = new ArrayList<>();

        Studenti.add(unosStudenta());
        int odabir;
        do{
            System.out.println("Odaberitie:");
            System.out.println("1 za unos jos studenata");
            System.out.println("2 za ispis studenta");
            System.out.println("3 za ispis najboljeg studenta");
            System.out.println("4 za ispis najlošijeg studenta");
            System.out.println("5 za prosjek ocjana svih studenata");
            System.out.println("6 za izlaz");
            odabir =scanner.nextInt();

            switch (odabir){
                case 1:
                    Studenti.add(unosStudenta());
                    break;
                case 2:
                    ispisStudenata(Studenti);
                    break;
                case 3:
                    najboljiStudent(Studenti);
                    break;
                case 4:
                    najgoriStudent(Studenti);
                    break;
                case 5:
                    prosjekStudenata(Studenti);
                    break;
            }

        }while(odabir!=6);





    }
    private static Student unosStudenta(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Unesite ime studenta:");
        String ime = scanner.nextLine();
        System.out.println("Unesite prezime studenta:");
        String prezime = scanner.nextLine();
        System.out.println("Unesite broj indeksa studneta:");
        String brojIndeksa = scanner.nextLine();
        System.out.println("Unesite prosjek ocjana studenta");
        double prosjekOcjena = scanner.nextDouble();

        return new Student(ime,prezime,brojIndeksa,prosjekOcjena);
    }
    private static void ispisStudenata( List<Student> studenti){
        for (Student student : studenti) {
            System.out.println("Ime: "+student.getIme()+
                    " Prezime: "+student.getPrezime()+
                    " Broj indeksa: " + student.getBrojIndeksa()+
                    " Prosjek ocjena: "+student.getProsjekOcjena());
        }
        System.out.println(" ");
    }
    private static void najboljiStudent(List<Student> studenti){
        Student najbolji = studenti.get(0);
        for(int i= 1;i<studenti.size();i++){
            if(najbolji.getProsjekOcjena()<studenti.get(i).getProsjekOcjena()){
                najbolji = studenti.get(i);
            }
        }
        System.out.println("Student sa najvišim prosjekom ocjena je :");
        System.out.println("Ime: "+najbolji.getIme());
        System.out.println("Prezime: "+ najbolji.getPrezime());
        System.out.println("Broj indeksa: "+ najbolji.getBrojIndeksa());
        System.out.println("Prosjek ocjena: " + najbolji.getProsjekOcjena());
        System.out.println(" ");
    }
    private static void najgoriStudent(List<Student> studenti){
        Student najgori = studenti.get(0);
        for(int i= 1;i<studenti.size();i++){
            if(najgori.getProsjekOcjena()>studenti.get(i).getProsjekOcjena()){
                najgori = studenti.get(i);
            }
        }
        System.out.println("Student sa najnižim prosjekom ocjena je :");
        System.out.println("Ime: "+najgori.getIme());
        System.out.println("Prezime: "+ najgori.getPrezime());
        System.out.println("Broj indeksa: "+ najgori.getBrojIndeksa());
        System.out.println("Prosjek ocjena: " + najgori.getProsjekOcjena());
        System.out.println(" ");
    }
    private static void prosjekStudenata(List<Student> studenti){
        double prosjekStudenata=0.0;
        for (Student student : studenti) {
            prosjekStudenata+=student.getProsjekOcjena();
        }
        prosjekStudenata = prosjekStudenata/studenti.size();
        System.out.printf("Prosjek svih studenta je: %.2f \n",prosjekStudenata);
    }

}
