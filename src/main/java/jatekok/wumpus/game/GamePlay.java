package jatekok.wumpus.game;

import jatekok.wumpus.model.Feeling;
import jatekok.wumpus.model.room.Room;
import jatekok.wumpus.model.room.RoomLevel;
import jatekok.wumpus.model.table.Status;
import jatekok.wumpus.model.table.Table;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static jatekok.wumpus.model.room.RoomLevel.EASY;
import static jatekok.wumpus.model.room.RoomLevel.valueOf;

@Component
public class GamePlay
{
    private static CreateTable createATable;
    private static Table[][] gameTable;

    private final CreateTable createTable;

    @Autowired
    public GamePlay(CreateTable createTable)
    {
        this.createTable = createTable;
    }

    public Table[][] createTable() throws IOException
    {
        gameTable = createATable.createTable(Status.EMPTY, getLevel());

        return gameTable;
    }

    // TODO: create new class for this method
    private static RoomLevel getLevel() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter game level(easy, medium, hard): ");

        String roomLevel = br.readLine();

        if(StringUtils.isNotBlank(roomLevel))
        {
            switch (RoomLevel.valueOf(roomLevel))
            {
                case EASY:
                    return RoomLevel.EASY;
                case MEDIUM:
                    return RoomLevel.MEDIUM;
                case HARD:
                    return RoomLevel.HARD;
                default:
                    throw new IllegalArgumentException("wrong room levelType: " + roomLevel);
            }
        }

        return null;
    }

    // todo this will be used later
    public String step(Status status)
    {
        switch (status)
        {
            case WAMPUS:
                System.out.print("Game over");
                break;
            case BAT:
                System.out.print("teleport");
                break;
            case MEAT:
                System.out.print("meat");
                break;
            default:
                throw new IllegalArgumentException("wrong status: " + status.getRoomType());
        }

        return null;
    }

    public String getNextRoomInformation(Feeling feeling)
    {
        switch (feeling)
        {
            case NOTFEEL:
                System.out.println("next rooms are empty");
                break;
            case SMELL:
                System.out.println("Wampus is in the next room");
                break;
            case BREEZE:
                System.out.println("maybe the next room is stack");
                break;
            case NOISE:
                System.out.println("there is a bat in the next room");
                break;
            default:
                throw new IllegalArgumentException("wrong feeling: " + feeling.getFeelings());
        }

        return null;
    }

    public void game(Table[][] table)
    {
        int life = 0;
        while(life > 0)
        {
            step(Status.EMPTY);
        }
    }
}
