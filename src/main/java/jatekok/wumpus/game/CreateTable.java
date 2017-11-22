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

        // wampus position
        gameTable[0][0].setTableElement(new Room(null, null, null, null, false));

        int x,y;

        int bats = roomProperty.getNumberOfBat();
        int stacks = roomProperty.getNumberOfStack();
        int arrows = roomProperty.getNumberOfArrow();
        int meat = roomProperty.getNumberOfMeat();

        int sum = bats + stacks + arrows + meat;

        while(sum > 0)
        {
            x = randomCoordinate(tableSize);
            y = randomCoordinate(tableSize);

            //TODO use simple method
            if (gameTable[x][y].getTableElement().isEmpty())
            {
                if(bats > 0)
                {
                    gameTable[x][y].setTableElement(addRoom(status, roomLevel, new Bat()));
                    sum--;
                    bats--;
                } else if (stacks > 0 && bats == 0)
                {
                    gameTable[x][y].setTableElement(addRoom(status, roomLevel, new Stack()));
                    sum--;
                    stacks--;
                } else if (arrows > 0 && bats == 0 && stacks == 0 )
                {
                    gameTable[x][y].setTableElement(addRoom(status, roomLevel, new Arrow()));
                    sum--;
                    arrows--;
                } else if (meat > 0 && bats == 0 && stacks == 0 && arrows == 0)
                {
                    gameTable[x][y].setTableElement(addRoom(status, roomLevel, new Meat()));
                    sum--;
                    meat--;
                }
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

    private Room addRoom(Status status, RoomLevel roomLevel, Property property)
    {
        return new Room(status, Collections.emptyList(), roomLevel, property, false);
    }

    private int randomCoordinate(int tableSize)
    {
        Random r = new Random();

        return r.nextInt(tableSize - 1) + 1;
    }
}
