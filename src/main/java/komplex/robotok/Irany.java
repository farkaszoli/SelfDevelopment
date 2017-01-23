package komplex.robotok;

public enum Irany
{
    ESZAK("eszak"),
    KELET("kelet"),
    DEL("del"),
    NYUGAT("nyugat");

    private String irany;

    private Irany(String irany)
    {
        this.irany = irany;
    }
}
