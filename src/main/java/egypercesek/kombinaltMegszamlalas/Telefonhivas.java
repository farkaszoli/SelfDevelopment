package egypercesek.kombinaltMegszamlalas;

public class Telefonhivas
{
    private String telefonszam;
    private HivasIdopont hivasHivasIdopont;

    public Telefonhivas(String telefonszam, HivasIdopont hivasHivasIdopont)
    {
        this.telefonszam = telefonszam;
        this.hivasHivasIdopont = hivasHivasIdopont;
    }

    public String getTelefonszam()
    {
        return telefonszam;
    }

    public HivasIdopont getHivasHivasIdopont()
    {
        return hivasHivasIdopont;
    }

    public void setTelefonszam(String telefonszam)
    {
        this.telefonszam = telefonszam;
    }

    public void setHivasHivasIdopont(HivasIdopont hivasHivasIdopont)
    {
        this.hivasHivasIdopont = hivasHivasIdopont;
    }
}
