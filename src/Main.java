/*
Zadatak 2: Popis jedinstvenih vrijednosti koristeći Set
Napišite program koji:
1.Od korisnika traži unos brojeva (razdvojenih razmakom).
2.Koristi HashSet za izdvajanje samo jedinstvenih brojeva (bez ponavljanja).
3.Ispisuje sve jedinstvene brojeve.
4.Traži najveći i najmanji broj koristeći odgovarajuće metode skupa.

* */


import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    //TODO 1. Od korisnika traži unos brojeva (razdvojenih razmakom).
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite nekoliko brojeva razdvojenih razmakom");
        String nizBrojeva = scanner.nextLine();
        String[] brojevi  = nizBrojeva.split(" ");
        
    //TODO 2. Koristi HashSet za izdvajanje samo jedinstvenih brojeva (bez ponavljanja).
        HashSet<Integer> jedinstveniBrojevi = new HashSet<>();

        for (String string : brojevi) {
            jedinstveniBrojevi.add(Integer.valueOf(string));
        }

    //TODO 3.  Ispisuje sve jedinstvene brojeve.
        System.out.println("Jedinstveni borjevi su:");
        for (Integer i : jedinstveniBrojevi) {
            System.out.println(i);
        }
    //TODO 4. Traži najveći i najmanji broj koristeći odgovarajuće metode skupa.
        System.out.println("\nNajveci jedinstveni borj je "+ Collections.max(jedinstveniBrojevi));
        System.out.println("\nNajmanji jedinstveni borj je "+ Collections.min(jedinstveniBrojevi));

        
    }   
}

