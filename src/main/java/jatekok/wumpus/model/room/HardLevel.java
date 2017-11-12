package jatekok.wumpus.model.room;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class HardLevel extends RoomProperty
{
    public HardLevel()
    {
        super(RoomLevel.HARD, 11, 8, 10, 1, 1);
    }
}
