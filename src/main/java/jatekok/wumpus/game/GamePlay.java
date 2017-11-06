package jatekok.wumpus.game;

import jatekok.wumpus.model.table.Status;
import org.springframework.stereotype.Component;

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

        return "";
    }
}
