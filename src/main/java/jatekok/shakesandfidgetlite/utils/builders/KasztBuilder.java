package jatekok.shakesandfidgetlite.utils.builders;

import jatekok.shakesandfidgetlite.model.faj.FajModel;
import jatekok.shakesandfidgetlite.model.kaszt.Kaszt;
import jatekok.shakesandfidgetlite.model.kiegeszito.Taska;

public class KasztBuilder
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

    private KasztBuilder()
    {
    }

    public static KasztBuilder aKaszt()
    {
        return new KasztBuilder();
    }

    public KasztBuilder withFajModel(FajModel fajModel)
    {
        this.fajModel = fajModel;
        return this;
    }

    public KasztBuilder withEro(int ero)
    {
        this.ero = ero;
        return this;
    }

    public KasztBuilder withUgyesseg(int ugyesseg)
    {
        this.ugyesseg = ugyesseg;
        return this;
    }

    public KasztBuilder withErtelem(int ertelem)
    {
        this.ertelem = ertelem;
        return this;
    }

    public KasztBuilder withKitartas(int kitartas)
    {
        this.kitartas = kitartas;
        return this;
    }

    public KasztBuilder withSzint(int szint)
    {
        this.szint = szint;
        return this;
    }

    public KasztBuilder withTaska(Taska taska)
    {
        this.taska = taska;
        return this;
    }

    public KasztBuilder withSebzes(double sebzes)
    {
        this.sebzes = sebzes;
        return this;
    }

    public KasztBuilder withEletero(int eletero)
    {
        this.eletero = eletero;
        return this;
    }

    public Kaszt buildKaszt()
    {
        return new Kaszt(fajModel, ero, ugyesseg, ertelem, kitartas, szint, taska, sebzes, eletero);
    }

}
