package jatekok.wumpus.model.room;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class RoomProperty
{
    private final RoomLevel roomLevel;

    private final int tableSize;
    private final int numberOfBat;
    private final int numberOfStack;
    private final int numberOfArrow;
    private final int numberOfMeat;

    public RoomProperty(RoomLevel roomLevel, int tableSize, int numberOfBat, int numberOfStack, int numberOfArrow, int numberOfMeat)
    {
        this.roomLevel = roomLevel;
        this.tableSize = tableSize;
        this.numberOfBat = numberOfBat;
        this.numberOfStack = numberOfStack;
        this.numberOfArrow = numberOfArrow;
        this.numberOfMeat = numberOfMeat;
    }

    public RoomLevel getRoomLevel()
    {
        return roomLevel;
    }

    public int getTableSize()
    {
        return tableSize;
    }

    public int getNumberOfBat()
    {
        return numberOfBat;
    }

    public int getNumberOfStack()
    {
        return numberOfStack;
    }

    public int getNumberOfArrow()
    {
        return numberOfArrow;
    }

    public int getNumberOfMeat()
    {
        return numberOfMeat;
    }
}
