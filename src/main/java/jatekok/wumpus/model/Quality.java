package jatekok.wumpus.model;

public enum Quality
{
    NORMAL("normal"),
    BRAVE("brave"),
    QUIET("quiet");

    private final String playerQuality;

    Quality(String playerQuality)
    {
        this.playerQuality = playerQuality;
    }

    public String getPlayerQuality()
    {
        return playerQuality;
    }
}
