package jatekok.shakesandfidgetlite.model.kaszt;

public enum KasztModel
{
    FELDERITO("felderito"),
    HARCOS("harcos"),
    MAGUS("magus");

    private String kasztTipus;

    KasztModel(String kasztTipus)
    {
        this.kasztTipus = kasztTipus;
    }

    public String getKasztTipus()
    {
        return kasztTipus;
    }

}

