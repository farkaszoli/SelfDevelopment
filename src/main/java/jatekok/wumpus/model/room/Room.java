package jatekok.wumpus.model.room;

import jatekok.wumpus.model.Feeling;
import jatekok.wumpus.model.TableElement;
import jatekok.wumpus.model.room.elements.Property;
import jatekok.wumpus.model.table.Status;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@ToString
@EqualsAndHashCode
public class Room extends TableElement
{
    private final Status status;
    private final List<Feeling> feelings;
    private final RoomLevel roomLevel;
    private final Property roomProperty;
    private final boolean isEmpty;

    public Room(Status status, List<Feeling> feelings, RoomLevel roomLevel, Property roomProperty, boolean isEmpty)
    {
        this.status = status;
        this.feelings = feelings;
        this.roomLevel = roomLevel;
        this.roomProperty = roomProperty;
        this.isEmpty = isEmpty;
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

    public Property getProperty() {
        return roomProperty;
    }

    public boolean isEmpty() {
        return isEmpty;
    }
}
