package jatekok.shakesandfidgetlite.model.kaszt;

import jatekok.shakesandfidgetlite.model.faj.Faj;

public class Harcos
{
    private final Faj faj;
    private final int ero;
    private final int ugyesseg;
    private final int ertelem;
    private final int kitartas;

    public Harcos(Faj faj, int ero, int ugyesseg, int ertelem, int kitartas)
    {
        this.faj = faj;
        this.ero = ero;
        this.ugyesseg = ugyesseg;
        this.ertelem = ertelem;
        this.kitartas = kitartas;
    }

    public Faj getFaj() {
        return faj;
    }

    public int getEro() {
        return ero;
    }

    public int getUgyesseg() {
        return ugyesseg;
    }

    public int getErtelem() {
        return ertelem;
    }

    public int getKitartas() {
        return kitartas;
    }
}
