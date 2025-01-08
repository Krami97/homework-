import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EvidencijaVozila {
    public List<Vozilo> vozila;


    public EvidencijaVozila(){
        this.vozila= new ArrayList<>();
    }

    public void dodajVozilo(Vozilo vozilo){
        this.vozila.add(vozilo);

    }

    public void spremPodatekUDatoteku(String datoteka) throws IOException {
        File file = new File(datoteka+".txt");
        try(FileWriter zapisi = new FileWriter(file)){
            for (Vozilo vozilo : this.vozila) {
                zapisi.write(vozilo.toStirng());
            }

        }catch (IOException e){
            System.out.println("Zapis nije uspio zbog greške :"+e.getMessage());
        }

    }
    public void ucitajPodatkeIzDatoteke(String datoteka) throws IOException {
        File file = new File(datoteka+".txt");
        try(BufferedReader citac = new BufferedReader(new FileReader(file))){
            String recenica;
            while((recenica = citac.readLine()) != null){
                System.out.println(recenica);

            }

        }catch (IOException e){
            System.out.println("datoteka koju zelite procitati vjerovatno ne postoji");
        }

    }
}
