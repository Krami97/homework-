import java.io.PrintWriter;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Student student1 = new Student("Tin", "Kramaric", "00001");
        Student student2 = new Student("Pero", "Peric", "00002");
        Student student3 = new Student("Ana", "Ankic", "00003");



        PrintWriter writer = new PrintWriter("studenti.txt");
        writer.println(student1.toString());
        writer.println(student2.toString());
        writer.println(student3.toString());
        writer.close();

        FileReader reader = new FileReader("studenti.txt");
        int brojZnakova = 0;
        int c;
        while ((c = reader.read()) != -1) {
                brojZnakova++;

        }
        reader.close();
        System.out.println("Broj slova u datoteci: " + brojZnakova);
    }
}


