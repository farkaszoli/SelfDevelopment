package jatekok.shakesandfidgetlite.model.targy;

public class Targy
{
    private final boolean isAktiv;
    private final int targyAra;
    private final int eladasiAra;

    public Targy(boolean isAktiv, int targyAra, int eladasiAra)
    {
        this.isAktiv = isAktiv;
        this.targyAra = targyAra;
        this.eladasiAra = eladasiAra;
    }

    public boolean isAktiv()
    {
        return isAktiv;
    }

    public int getTargyAra() {
        return targyAra;
    }

    public int getEladasiAra() {
        return eladasiAra;
    }
}
