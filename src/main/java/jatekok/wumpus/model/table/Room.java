package jatekok.wumpus.model.table;

import jatekok.wumpus.model.Feeling;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@ToString
@EqualsAndHashCode
public class Room
{
    private final Status status;
    private final List<Feeling> feelings;
    private final RoomLevel roomLevel;

    public Room(Status status, List<Feeling> feelings, RoomLevel roomLevel)
    {
        this.status = status;
        this.feelings = feelings;
        this.roomLevel = roomLevel;
    }

    public Status getStatus()
    {
        return status;
    }

    public List<Feeling> getFeelings()
    {
        return feelings;
    }

    public RoomLevel getRoomLevel()
    {
        return roomLevel;
    }
}
