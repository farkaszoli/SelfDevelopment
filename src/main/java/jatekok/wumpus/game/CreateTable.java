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
    public Table[][] createTable(int tableSize,Status status, RoomLevel roomLevel)
    {
        Table[][] gameTable = new Table[tableSize][tableSize];

//        6*6-os pálya, 2 denevér, 5 verem, 3 nyíl, 2 hús
        for(int i = 0; i < tableSize; i++)
        {
            for(int j = 0; j < tableSize; j++)
            {
                // TODO i will create a random generator, it is a dummy data
                gameTable[i][j].setRoom(new Room(status, Collections.emptyList(), roomLevel, null, false));
            }
        }

        return gameTable;
    }
}
