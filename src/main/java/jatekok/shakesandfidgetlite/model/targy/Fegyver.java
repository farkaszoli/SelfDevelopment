package jatekok.shakesandfidgetlite.model.targy;

public class Fegyver extends Targy
{
    private final FegyverTipus fegyverTipus;

    public Fegyver(boolean isAktiv, int targyAra, int eladasiAra, FegyverTipus fegyverTipus)
    {
        super(isAktiv, targyAra, eladasiAra);
        this.fegyverTipus = fegyverTipus;
    }

    public FegyverTipus getFegyverTipus()
    {
        return fegyverTipus;
    }
}
