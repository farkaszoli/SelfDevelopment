package egypercesek.kombinaltMegszamlalas;

public class HivasIdopont
{
    private int ora;
    private int perc;
    private int masodperc;

    public HivasIdopont(int ora, int perc, int masodperc)
    {
        this.ora = ora;
        this.perc = perc;
        this.masodperc = masodperc;
    }

    public int getOra()
    {
        return ora;
    }

    public void setOra(int ora)
    {
        this.ora = ora;
    }

    public int getPerc()
    {
        return perc;
    }

    public void setPerc(int perc) {
        this.perc = perc;
    }

    public int getMasodperc()
    {
        return masodperc;
    }

    public void setMasodperc(int masodperc)
    {
        this.masodperc = masodperc;
    }
}
