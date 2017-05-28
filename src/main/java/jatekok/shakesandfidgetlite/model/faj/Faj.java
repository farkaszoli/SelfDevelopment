package jatekok.shakesandfidgetlite.model.faj;

public enum Faj
{
    EMBER("ember"),
    ORK("ork"),
    ELF("elf"),
    TORP("törp"),
    DEMON("démon");

    private String fajTipus;

    Faj(String url)
    {
        this.fajTipus = fajTipus;
    }

    public String getFajTipus()
    {
        return fajTipus;
    }

}
