package komplex.evfolyam;

public class Tantargy
{
    private final String nev;
    private final double atlag;


    public Tantargy(String nev, double atlag) {
        this.nev = nev;
        this.atlag = atlag;
    }

    public String getNev() {
        return nev;
    }

    public double getAtlag() {
        return atlag;
    }
}
