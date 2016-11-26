package egypercesek.folyo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Átkelés a folyón:
 * Kérjen be egy N és egy M egészet, ahol N>M. Töltsön fel egy NxM kétdimenziós tömböt véletlenszerű 0 és 1 értékekkel.
 * Ezzel egy N hosszúságú, M szélességű folyót modellezünk, melyben az egyik part a tömb N hosszúságú első sora,
 * a másik az utolsó (M-edik) sora. A program állapítsa meg, hogy átjuthatunk-e száraz lábbal a folyó egyik partjáról
 * a másikra, miközben mindig valamelyik szomszédos elemre lépünk, és mindig csak 1-esekre.
 * Jelenítse meg a képernyőn a tömböt a számokkal, majd úgy, hogy az útvonalat # jelekkel tüntesse fel.
 */
public class FolyoFeladat {

    public static void main(String[] args)
    {
        Scanner beolvasas = new Scanner(System.in);
        int n = 0;
        int m = 0;
        Mezo mezo;

        do {
            System.out.println("Elso szam: ");
            n = beolvasas.nextInt();
            System.out.println("Masodik szam: ");
            m = beolvasas.nextInt();
        } while (n < m);

        beolvasas.close();

        Random rand = new Random();
        Palya palya = new Palya(n, m);

        List<Mezo> mezoList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mezo = new Mezo(i, j, rand.nextInt((1 - 0) + 1));
                mezoList.add(mezo);
            }
        }

    }

}

