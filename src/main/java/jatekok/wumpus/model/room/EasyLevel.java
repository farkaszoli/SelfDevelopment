package jatekok.wumpus.model.room;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class EasyLevel extends RoomProperty
{
    public EasyLevel()
    {
        super(RoomLevel.EASY, 6, 2, 5, 3, 2);
    }
}
