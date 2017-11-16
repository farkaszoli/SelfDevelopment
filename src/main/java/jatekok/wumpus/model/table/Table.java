package jatekok.wumpus.model.table;

import jatekok.wumpus.model.room.Room;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Table
{
    private Room room;

    public Room getRoom()
    {
        return room;
    }

    public void setRoom(Room room)
    {
        this.room = room;
    }
}
