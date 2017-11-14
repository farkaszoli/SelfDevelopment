package jatekok.wumpus.game;

import jatekok.wumpus.model.room.Room;
import jatekok.wumpus.model.room.RoomLevel;
import jatekok.wumpus.model.table.Status;
import jatekok.wumpus.model.table.Table;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class CreateTable
{
    public Table createTable(int tableSize,Status status, RoomLevel roomLevel)
    {
        Table gameTable = new Table(tableSize);

        return gameTable;
    }
}
