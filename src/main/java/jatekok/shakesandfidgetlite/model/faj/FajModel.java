package jatekok.shakesandfidgetlite.model.faj;

public class FajModel
{
    private int ero;
    private int ugyesseg;
    private int ertelem;
    private int kitartas;

    public FajModel(int ero, int ugyesseg, int ertelem, int kitartas)
    {
        this.ero = ero;
        this.ugyesseg = ugyesseg;
        this.ertelem = ertelem;
        this.kitartas = kitartas;
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
