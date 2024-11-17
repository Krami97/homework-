import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
public class Main {
    public static void main(String[] args) throws IOException {

        List<Proizvod> proizvodi = new ArrayList<>();
        proizvodi.add(new Proizvod("jaje",0.1,10));
        proizvodi.add(new Proizvod("banane",0.3,6));
        proizvodi.add(new Proizvod("Lonac",54.99,5));
        proizvodi.add(new Proizvod("kava",5.0,11));
        proizvodi.add(new Proizvod("kruh",1.3,50));
        proizvodi.add(new Proizvod("mikser",59.99,3));
        ispisListeProizvoda(proizvodi);
        spremanjeListeProizvodaUDatoteke(proizvodi);



    }
public static void ispisListeProizvoda(List<Proizvod> proizvodi){
    for (Proizvod proizvod : proizvodi) {
        System.out.println(proizvod.toString());
    }
}

public static void spremanjeListeProizvodaUDatoteke(List<Proizvod> proizvodi) throws IOException {
        FileWriter zapisProizvoda = new FileWriter("proizvodi.txt");
        zapisProizvoda.write("Proizvoidi:\n");
        FileWriter zapisSkupljihProizvoda = new FileWriter("skuplji_proizvodi.txt");
        zapisSkupljihProizvoda.write("Skuplji Proizvoidi:\n");
    for (Proizvod proizvod : proizvodi) {
        if(proizvod.getCijenaProizvoda()>50.0){
            zapisSkupljihProizvoda.write("------------------------------------------------------------------\n");
            zapisSkupljihProizvoda.write(proizvod.toString()+"\n");

        }else{
            zapisProizvoda.write("------------------------------------------------------------------\n");
            zapisProizvoda.write(proizvod.toString()+"\n");

        }
    }
    zapisProizvoda.close();
    zapisSkupljihProizvoda.close();

}
}



