package egypercesek.kezilabda;

public class Jatekos
{
    private final String nev;
    private final Poszt poszt;
    private final int hetesekSzama;
    private final int ertekesitettHetes;
    private final String meccsek;
    private int meccsekSzama;
    private int golokSzama;
    private int golAtlag;
    private double sikeresHetesekSzazaleka;

    public Jatekos(String nev, Poszt poszt, int hetesekSzama, int ertekesitettHetes, String meccsek, int meccsekSzama, int golokSzama, int golAtlag, double sikeresHetesekSzazaleka) {
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

    public void setMeccsekSzama(int meccsekSzama) {
        this.meccsekSzama = meccsekSzama;
    }

    public int getGolokSzama() {
        return golokSzama;
    }

    public void setGolokSzama(int golokSzama) {
        this.golokSzama = golokSzama;
    }

    public int getGolAtlag() {
        return golAtlag;
    }

    public void setGolAtlag(int golAtlag) {
        this.golAtlag = golAtlag;
    }

    public double getSikeresHetesekSzazaleka() {
        return sikeresHetesekSzazaleka;
    }

    public void setSikeresHetesekSzazaleka(double sikeresHetesekSzazaleka) {
        this.sikeresHetesekSzazaleka = sikeresHetesekSzazaleka;
    }
}
