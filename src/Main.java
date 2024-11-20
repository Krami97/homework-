public class Main {
    public static void main(String[] args) {
        Razred razred = new Razred("1B", "Petar");

        Ucenik ucenik1 = new Ucenik("Ana", "Anic",3);
        razred.dodajUcenika(ucenik1);

        Ucenik ucenik2 = new Ucenik("Ivan", "Ivic",4);
        razred.dodajUcenika(ucenik2);

        Ucenik ucenik3 = new Ucenik("Tin", "Kramaric",2);
        razred.dodajUcenika(ucenik3);



        razred.pronadiNajboljegUcenika();
        

    }
}



