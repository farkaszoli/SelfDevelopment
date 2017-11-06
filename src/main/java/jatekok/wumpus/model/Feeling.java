package jatekok.wumpus.model;

public enum Feeling
{
    NOTFEEL("notFeel"),
    BREEZE("breeze"),
    SMELL("smell"),
    NOISE("noise");

    private final String feelings;

    Feeling(String feelings)
    {
        this.feelings = feelings;
    }

    public String getFeelings() {
        return feelings;
    }
}
