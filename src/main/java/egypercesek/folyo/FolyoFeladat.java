package egypercesek.folyo;

import java.util.Random;
import java.util.Scanner;

/**
 * Átkelés a folyón: Kérjen be egy N és egy M egészet, ahol N>M. Töltsön fel egy
 * NxM kétdimenziós tömböt véletlenszerű 0 és 1 értékekkel. Ezzel egy N
 * hosszúságú, M szélességű folyót modellezünk, melyben az egyik part a tömb N
 * hosszúságú első sora, a másik az utolsó (M-edik) sora. A program állapítsa
 * meg, hogy átjuthatunk-e száraz lábbal a folyó egyik partjáról a másikra,
 * miközben mindig valamelyik szomszédos elemre lépünk, és mindig csak 1-esekre.
 * Jelenítse meg a képernyőn a tömböt a számokkal, majd úgy, hogy az útvonalat #
 * jelekkel tüntesse fel.
 */
public class FolyoFeladat {

    // pl tomb
    static int[][] folyo = new int[][] {
            { 1, 0, 0 },
            { 0, 0, 0 },
            { 0, 1, 1 },
            { 1, 1, 1 } };

    static int n_max = 0;
    static int m_max = 0;
    static boolean nyertelMar = false;
    static int eredmeny = 0;

    public static void main(String[] args) {
        Scanner beolvasas = new Scanner(System.in);
        Random rand = new Random();

        // belolvasas
        // do {
        // System.out.println("Elso szam: ");
        // n_max = beolvasas.nextInt();
        // System.out.println("Masodik szam: ");
        // m_max = beolvasas.nextInt();
        // } while (n_max < m_max);
        // beolvasas.close();
        // folyo = new int[n_max][m_max];

        n_max = 4;
        m_max = 3;

        // tomb feltoltese
        // for (int i = 0; i < n_max; i++)
        // {
        // for (int j = 0; j < m_max; j++)
        // {
        // folyo[i][j] = rand.nextInt(2);
        // }
        // }

        for (int i = 0; i < n_max; i++) {
            if (folyo[i][0] == 1) {
                System.out.println(nez(i, 0));
            } else {
                System.out.println(false);
            }
        }
    }

    // { 1, 0, 0 },
    // { 1, 0, 1 },
    // { 1, 0, 1 },
    // { 1, 1, 1 };

    public static boolean nez(int i, int j) {

        if (i + 1 < n_max) {
            // alatta, egymas alatt 2 db egyes
            if (folyo[i + 1][j] == 1) {
                return nez(i + 1, j);
            }
        }

        if (j + 1 < m_max) {
            // soros, egymas mellett 2 db 1es
            if (folyo[i][j + 1] == 1) {
                return nez(i, j + 1);
            }
        }

        return nyertelE(i, j);
    }

    private static boolean nyertelE(int i, int j) {
        if (folyo[i][j] == 1 && j + 1 == m_max) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean beulVanE(int i, int j) {
        if (i < n_max && j < m_max) {
            return true;
        } else {
            return false;
        }

    }
}
