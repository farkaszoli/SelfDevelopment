package jatekok.wumpus.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Player extends TableElement
{
    private int startXPosition;
    private int startYPosition;
    private final Quality quality;

    public Player(Quality quality)
    {
        this.quality = quality;
        this.startXPosition = 1;
        this.startYPosition = 1;
    }

    public int getStartXPosition()
    {
        return startXPosition;
    }

    public void setStartXPosition(int startXPosition)
    {
        this.startXPosition = startXPosition;
    }

    public int getStartYPosition()
    {
        return startYPosition;
    }

    public void setStartYPosition(int startYPosition)
    {
        this.startYPosition = startYPosition;
    }

    public Quality getQuality()
    {
        return quality;
    }
}
