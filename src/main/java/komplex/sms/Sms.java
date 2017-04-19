package komplex.sms;

public class Sms
{
    private final int ora;
    private final int perc;
    private final int telefonszam;
    private final String uzenet;

    public Sms(int ora, int perc, int telefonszam, String uzenet)
    {
        this.ora = ora;
        this.perc = perc;
        this.telefonszam = telefonszam;
        this.uzenet = uzenet;
    }

    public int getOra()
    {
        return ora;
    }

    public int getPerc()
    {
        return perc;
    }

    public int getTelefonszam()
    {
        return telefonszam;
    }

    public String getUzenet()
    {
        return uzenet;
    }

    @Override
    public String toString() {
        return "Sms{" +
                "ora=" + ora +
                ", perc=" + perc +
                ", telefonszam=" + telefonszam +
                ", uzenet='" + uzenet + '\'' +
                '}';
    }
}
