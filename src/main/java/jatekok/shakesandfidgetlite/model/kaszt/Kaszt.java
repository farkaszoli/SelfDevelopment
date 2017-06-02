package jatekok.shakesandfidgetlite.model.kaszt;

import jatekok.shakesandfidgetlite.model.faj.FajModel;
import jatekok.shakesandfidgetlite.model.kiegeszito.Taska;

public class Kaszt
{
    private FajModel fajModel;
    private int ero;
    private int ugyesseg;
    private int ertelem;
    private int kitartas;
    private int szint;
    private Taska taska;
    private double sebzes;
    private int eletero;

    public Kaszt(FajModel fajModel, int ero, int ugyesseg, int ertelem, int kitartas, int szint, Taska taska,
                 double sebzes, int eletero)
    {
        this.fajModel = fajModel;
        this.ero = ero;
        this.ugyesseg = ugyesseg;
        this.ertelem = ertelem;
        this.kitartas = kitartas;
        this.szint = szint;
        this.taska = taska;
        this.sebzes = sebzes;
        this.eletero = eletero;
    }

    public FajModel getFajModel() {
        return fajModel;
    }

    public void setFajModel(FajModel fajModel) {
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

    public int getSzint() {
        return szint;
    }

    public void setSzint(int szint) {
        this.szint = szint;
    }

    public Taska getTaska() {
        return taska;
    }

    public void setTaska(Taska taska) {
        this.taska = taska;
    }

    public double getSebzes() {
        return sebzes;
    }

    public void setSebzes(double sebzes) {
        this.sebzes = sebzes;
    }

    public int getEletero() {
        return eletero;
    }

    public void setEletero(int eletero) {
        this.eletero = eletero;
    }

    @Override
    public String toString() {
        return "Kaszt{" +
                "fajModel=" + fajModel +
                ", ero=" + ero +
                ", ugyesseg=" + ugyesseg +
                ", ertelem=" + ertelem +
                ", kitartas=" + kitartas +
                ", szint=" + szint +
                ", taska=" + taska +
                ", sebzes=" + sebzes +
                ", eletero=" + eletero +
                '}';
    }
}
