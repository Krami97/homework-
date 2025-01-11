/*
* Zadatak 1: Brojanje riječi u tekstu koristeći Map
Napišite program koji:
1.Traži od korisnika unos teksta.
2.Koristi HashMap za brojanje koliko se puta svaka riječ pojavljuje u tekstu.
3.Ignorira velika/mala slova i interpunkcijske znakove.
4.Prikazuje rezultat (svaka riječ i broj pojavljivanja).
*
* */

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //TODO 1. Traži od korisnika unos teksta.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite neki tekst:");
        String tekst  = scanner.nextLine();

        //TODO 2. Koristi HashMap za brojanje koliko se puta svaka riječ pojavljuje u tekstu.
        //TODO 3.Ignorira velika/mala slova i interpunkcijske znakove.
        String[] rijeci = tekst.toLowerCase().replaceAll("[^3a-zA-Z0-9 ]","").split(" ");
        HashMap<String, Integer> brojRijeci = new HashMap<>();


        for (String string : rijeci) {
            if (brojRijeci.containsKey(string)){
                brojRijeci.put(string,brojRijeci.get(string)+1);
            }else {
                brojRijeci.put(string,1);
            }
        }

        //TODO 4. Prikazuje rezultat (svaka riječ i broj pojavljivanja).
        for (String string : brojRijeci.keySet()) {
            System.out.printf("Rijec %s pojavljuje se %d puta u tekatu\n",string,brojRijeci.get(string));
        }




    }
}

