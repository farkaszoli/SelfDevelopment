package jatekok.wumpus.model.room;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class MediumLevel extends RoomProperty
{
    public MediumLevel()
    {
        super(RoomLevel.MEDIUM, 9, 5, 8, 2, 1);
    }
}
