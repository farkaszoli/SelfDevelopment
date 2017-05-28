package jatekok.shakesandfidgetlite.model.kaszt;

import jatekok.shakesandfidgetlite.model.faj.Faj;

public class Kaszt
{
    private Faj faj;
    private int ero;
    private int ugyesseg;
    private int ertelem;
    private int kitartas;

    public Kaszt(Faj faj, int ero, int ugyesseg, int ertelem, int kitartas)
    {
        this.faj = faj;
        this.ero = ero;
        this.ugyesseg = ugyesseg;
        this.ertelem = ertelem;
        this.kitartas = kitartas;
    }

    public Faj getFaj()
    {
        return faj;
    }

    public void setFaj(Faj faj)
    {
        this.faj = faj;
    }

    public int getEro() {
        return ero;
    }

    public void setEro(int ero)
    {
        this.ero = ero;
    }

    public int getUgyesseg()
    {
        return ugyesseg;
    }

    public void setUgyesseg(int ugyesseg)
    {
        this.ugyesseg = ugyesseg;
    }

    public int getErtelem()
    {
        return ertelem;
    }

    public void setErtelem(int ertelem)
    {
        this.ertelem = ertelem;
    }

    public int getKitartas()
    {
        return kitartas;
    }

    public void setKitartas(int kitartas)
    {
        this.kitartas = kitartas;
    }
}
