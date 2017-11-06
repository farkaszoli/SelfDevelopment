package jatekok.wumpus.game;

import jatekok.wumpus.model.Feeling;
import jatekok.wumpus.model.table.Room;
import jatekok.wumpus.model.table.Status;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GamePlay
{
    public GamePlay()
    {
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
