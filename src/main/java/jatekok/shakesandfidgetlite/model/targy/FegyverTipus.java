package jatekok.shakesandfidgetlite.model.targy;

public enum FegyverTipus
{
    KOZELHARCI("kozelharci"),
    TAVOLSAGI("tavolsagi"),
    MAGIKUS("magikus"),
    EGYEB("egyeb");

    private String fegyverTipus;

    FegyverTipus(String fegyverTipus)
    {
        this.fegyverTipus = fegyverTipus;
    }

    public String getFegyverTipus()
    {
        return fegyverTipus;
    }
}
