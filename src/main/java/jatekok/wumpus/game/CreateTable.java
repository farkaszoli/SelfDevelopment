package jatekok.wumpus.game;

import jatekok.wumpus.model.room.*;
import jatekok.wumpus.model.table.Status;
import jatekok.wumpus.model.table.Table;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class CreateTable
{
    public Table[][] createTable(Status status, RoomLevel roomLevel)
    {
       RoomProperty roomProperty = getLevel(roomLevel);

       int tableSize = roomProperty.getTableSize();

       Table[][] gameTable = new Table[tableSize][tableSize];

       createRandomGenerator(roomProperty);

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

    private RoomProperty getLevel(RoomLevel roomLevel)
    {
        switch (roomLevel)
        {
            case EASY:
                return new EasyLevel();
            case MEDIUM:
                return new MediumLevel();
            case HARD:
                return new HardLevel();
        }

        return null;
    }

    private void createRandomGenerator(RoomProperty roomProperty)
    {
        //  example  6*6-os pálya, 2 denevér, 5 verem, 3 nyíl, 2 hús
        int bats = roomProperty.getNumberOfBat();
        int stacks = roomProperty.getNumberOfStack();
        int arrows = roomProperty.getNumberOfArrow();
        int meat = roomProperty.getNumberOfMeat();
    }
}
