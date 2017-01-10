package egypercesek.idojaras;

public class Idojaras
{
    private final String idokep;
    private final int homerseklet;
    private final int szelirany;
    private final int szelerosseg;
    private final int legnyomas;
    private final double paratartalom;
    private final int ora;

    public Idojaras(String idokep, int homerseklet, int szelirany, int szelerosseg, int legnyomas, double paratartalom,
                int ora)
    {
        this.idokep = idokep;
        this.homerseklet = homerseklet;
        this.szelirany = szelirany;
        this.szelerosseg = szelerosseg;
        this.legnyomas = legnyomas;
        this.paratartalom = paratartalom;
        this.ora = ora;
    }

    public String getIdokep() {
        return idokep;
    }

    public int getHomerseklet() {
        return homerseklet;
    }

    public int getSzelirany() {
        return szelirany;
    }

    public int getSzelerosseg() {
        return szelerosseg;
    }

    public int getLegnyomas() {
        return legnyomas;
    }

    public double getParatartalom() {
        return paratartalom;
    }

    public int getOra() {
        return ora;
    }
}
