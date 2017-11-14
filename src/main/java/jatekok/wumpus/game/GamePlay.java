package jatekok.wumpus.game;

import jatekok.wumpus.model.Feeling;
import jatekok.wumpus.model.room.RoomLevel;
import jatekok.wumpus.model.table.Status;
import jatekok.wumpus.model.table.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static jatekok.wumpus.model.room.RoomLevel.valueOf;

@Component
public class GamePlay
{
    private static CreateTable createATable;
    private static Table gameTable;

    private final CreateTable createTable;

    @Autowired
    public GamePlay(CreateTable createTable)
    {
        this.createTable = createTable;
    }

    public Table createTalbe() throws IOException
    {
        String gameLevel = getLevel();

        gameTable = createATable.createTable(6, Status.EMPTY, RoomLevel.EASY);

        return gameTable;
    }

    // TODO: create new class for this method
    private static String getLevel() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter game level(easy, medium, hard): ");

        return br.readLine();
    }

    // TODO: refactor this and create random generator for this method (generate table structure), create unit tests
    private static int createTable(String gameLevel)
    {
        switch (valueOf(gameLevel))
        {
            case EASY:
                return 6;
            case MEDIUM:
                return 9;
            case HARD:
                return 11;
        }

        // TODO add default value
        return 6;
    }

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
        }

        return "test";
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
        }
        return "feeling test";
    }
}
