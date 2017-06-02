package jatekok.shakesandfidgetlite;

import jatekok.shakesandfidgetlite.model.kaszt.Kaszt;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // http://www.inf.u-szeged.hu/~antal/okt/prog1/kotprog/07feladat.pdf

        TulajdonsagokBeallitasa tulajdonsagokBeallitasa = new TulajdonsagokBeallitasa();
        Scanner input = new Scanner(System.in);

        System.out.println("Shakes and Fidget Lite");

        System.out.println();
        System.out.println("Kaszt megadasa: ");

        String kaszt = input.next();

        System.out.println("Faj megadasa: ");
        String faj = input.next();

        Kaszt tesztKaszt = tulajdonsagokBeallitasa.tulajdonsagokBeallitasa(kaszt, faj);

        System.out.print("Kivalasztott kaszt: " + tesztKaszt.toString());
    }
}
