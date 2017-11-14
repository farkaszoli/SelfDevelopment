package jatekok.wumpus.model.room;

import jatekok.wumpus.model.Feeling;
import jatekok.wumpus.model.table.Status;
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
    private boolean isEmpty;

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

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }
}
