package jatekok.shakesandfidgetlite.model.kaszt;

import jatekok.shakesandfidgetlite.model.faj.Faj;
import jatekok.shakesandfidgetlite.model.faj.FajModel;

public class Kaszt
{
    private FajModel fajModel;
    private int ero;
    private int ugyesseg;
    private int ertelem;
    private int kitartas;

    public Kaszt(FajModel fajModel, int ero, int ugyesseg, int ertelem, int kitartas)
    {
        this.fajModel = fajModel;
        this.ero = ero;
        this.ugyesseg = ugyesseg;
        this.ertelem = ertelem;
        this.kitartas = kitartas;
    }

    public FajModel getFaj()
    {
        return fajModel;
    }

    public void setFaj(Faj faj)
    {
        this.fajModel = fajModel;
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

    @Override
    public String toString() {
        return "Kaszt{" +
                "fajModel=" + fajModel +
                ", ero=" + ero +
                ", ugyesseg=" + ugyesseg +
                ", ertelem=" + ertelem +
                ", kitartas=" + kitartas +
                '}';
    }
}
