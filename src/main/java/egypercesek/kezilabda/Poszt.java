package egypercesek.kezilabda;

public enum Poszt
{
    IRANYITO("iranyito"),
    ATLOVO("atlovo"),
    BEALLO("beallo"),
    JOBBSZELSO("jobbszelso"),
    BALSZELSO("balszelso"),
    KAPUS("kapus");

    private String poszt;

    private Poszt(String poszt)
    {
        this.poszt = poszt;
    }
}
