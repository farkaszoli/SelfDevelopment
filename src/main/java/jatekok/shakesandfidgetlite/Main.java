package jatekok.shakesandfidgetlite;

import jatekok.shakesandfidgetlite.model.kaszt.Kaszt;

public class Main
{
    public static void main(String[] args)
    {
        // http://www.inf.u-szeged.hu/~antal/okt/prog1/kotprog/07feladat.pdf

        TulajdonsagokBeallitasa tulajdonsagokBeallitasa = new TulajdonsagokBeallitasa();
        Kaszt tesztKaszt = tulajdonsagokBeallitasa.tulajdonsagokBeallitasa("harcos", "ork");

        System.out.println("Shakes and Fidget Lite");
        System.out.print("Kivalasztott kaszt: " + tesztKaszt.toString());
    }
}
