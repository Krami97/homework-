
public class Main {
    public static void main(String[] args) {
        Polaznik polaznik1 = new Polaznik("Pero","Peric");
        Polaznik polaznik2 = new Polaznik("Ana","Ankic",22,"Žensko");
        Polaznik polaznik3 = new Polaznik();


        System.out.println("Prvi polaznik je " + polaznik1.getIme() +" "+  polaznik1.getPrezime());
        polaznik2.setDob(33);
        polaznik3.setIme("Josko");
        polaznik3.setPrezime("Joskic");

    }
}
