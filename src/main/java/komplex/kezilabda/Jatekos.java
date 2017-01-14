package komplex.kezilabda;

public class Jatekos
{
    private final String nev;
    private final Poszt poszt;
    private final int hetesekSzama;
    private final int ertekesitettHetes;
    private final String meccsek;
    private int meccsekSzama;
    private int golokSzama;
    private double golAtlag;
    private double sikeresHetesekSzazaleka;

    public Jatekos(String nev, Poszt poszt, int hetesekSzama, int ertekesitettHetes, String meccsek, int meccsekSzama,
                   int golokSzama, double golAtlag, double sikeresHetesekSzazaleka) {
        this.nev = nev;
        this.poszt = poszt;
        this.hetesekSzama = hetesekSzama;
        this.ertekesitettHetes = ertekesitettHetes;
        this.meccsek = meccsek;
        this.meccsekSzama = meccsekSzama;
        this.golokSzama = golokSzama;
        this.golAtlag = golAtlag;
        this.sikeresHetesekSzazaleka = sikeresHetesekSzazaleka;
    }

    public String getNev() {
        return nev;
    }

    public Poszt getPoszt() {
        return poszt;
    }

    public int getHetesekSzama() {
        return hetesekSzama;
    }

    public int getErtekesitettHetes() {
        return ertekesitettHetes;
    }

    public String getMeccsek() {
        return meccsek;
    }

    public int getMeccsekSzama() {
        return meccsekSzama;
    }

    public int getGolokSzama() {
        return golokSzama;
    }

    public double getGolAtlag() {
        return golAtlag;
    }

    public double getSikeresHetesekSzazaleka() {
        return sikeresHetesekSzazaleka;
    }

}
