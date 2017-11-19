package jatekok.wumpus.game;

import jatekok.wumpus.model.room.*;
import jatekok.wumpus.model.room.elements.*;
import jatekok.wumpus.model.table.Status;
import jatekok.wumpus.model.table.Table;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Random;

@Component
public class CreateTable
{

    // TODO separate this class and method
    public Table[][] createTable(Status status, RoomLevel roomLevel)
    {
        RoomProperty roomProperty = getLevel(roomLevel);

        int tableSize = roomProperty.getTableSize();

        Table[][] gameTable = new Table[tableSize][tableSize];

        int numberOfProperty = numberOfProperties(roomProperty);

        int x,y;

        while(numberOfProperty > 0)
        {
            x = randomCoordinate(tableSize);
            y = randomCoordinate(tableSize);

            //TODO count number of properties?
            if (gameTable[x][y].getRoom().isEmpty())
            {
                gameTable[x][y].setRoom(randomRoom(status, roomLevel));
            }

            numberOfProperty--;
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

    private int numberOfProperties(RoomProperty roomProperty)
    {
        //  example  6*6-os pálya, 2 denevér, 5 verem, 3 nyíl, 2 hús
        int bats = roomProperty.getNumberOfBat();
        int stacks = roomProperty.getNumberOfStack();
        int arrows = roomProperty.getNumberOfArrow();
        int meat = roomProperty.getNumberOfMeat();

        return bats + stacks + arrows + meat;
    }

    private Room randomRoom(Status status, RoomLevel roomLevel)
    {
        Random r = new Random();
        /*

        bats = 1
        stack = 2
        arrow = 3
        meat = 4
        empty room = 5
         */

        int number = r.nextInt(4) + 1;

        Property property = null;

        switch (number)
        {
            case 1:
                property = new Bat();
            case 2:
                property = new Stack();
            case 3:
                property = new Arrow();
            case 4:
                property = new Meat();
        }

        return new Room(status, Collections.emptyList(), roomLevel, property, false);
    }

    private int randomCoordinate(int tableSize)
    {
        Random r = new Random();

        return r.nextInt(tableSize - 1) + 1;
    }
}
