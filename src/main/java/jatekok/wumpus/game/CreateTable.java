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
    public Table[][] createTable(Status status, RoomLevel roomLevel)
    {
        RoomProperty roomProperty = getLevel(roomLevel);

        Property randomProperty;

        boolean isEmpty;

        int tableSize = roomProperty.getTableSize();

        Table[][] gameTable = new Table[tableSize][tableSize];

        createRandomGenerator(roomProperty);

        for(int i = 0; i < tableSize; i++)
        {
            for(int j = 0; j < tableSize; j++)
            {
                // TODO i will create a random generator, it is a dummy data

                randomProperty = randomProperty();

                // TODO create method or object (property + boolean)
                isEmpty = false;

                gameTable[i][j].setRoom(new Room(status, Collections.emptyList(), roomLevel, randomProperty, isEmpty));
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

    private Property randomProperty()
    {
        Random r = new Random();
        /*
        empty room = 1
        bats = 2
        stack = 3
        arrow = 4
        meat = 5
         */

        int number = r.nextInt(4) + 1;

        switch (number)
        {
            case 1:
                return null;
            case 2:
                return new Bat();
            case 3:
                return new Stack();
            case 4:
                return new Arrow();
            case 5:
                return new Meat();
        }

        return null;
    }
}
