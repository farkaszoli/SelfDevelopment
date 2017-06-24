package jatekok.shakesandfidgetlite.model.targy;

public class Fegyver extends Targy
{
    private FegyverTipus fegyverTipus;

    public Fegyver(boolean isAktiv, FegyverTipus fegyverTipus)
    {
        super(isAktiv);
        this.fegyverTipus = fegyverTipus;
    }

    public FegyverTipus getFegyverTipus()
    {
        return fegyverTipus;
    }
}
