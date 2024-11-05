import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("tin","kramaric","123",3.3);
        Student kopijaStudent = student;
        student.promjeniProsjekOcjena(4.4);
        System.out.println(student.getProsjekOcjena());
        System.out.println(kopijaStudent.getProsjekOcjena());
        //dobijemo iste vrijednosti jer smo u variablu kopijaStudent spremili adresu objekta student to jest istu referencu na objekt
        //Promjena napravljena u jednoj referenci utjece na drugu jer pokazuju na isti objekt u memoriji



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
