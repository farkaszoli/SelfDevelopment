package jatekok.campercrew;

import jatekok.campercrew.model.Robber;
import org.springframework.stereotype.Component;

@Component
public class GamePlay
{
    public void gamePlay()
    {
        int numberOfRobberies = 20;

        while (numberOfRobberies > 0)
        {

            numberOfRobberies--;
        }
    }

    private Robber chooseARobber()
    {
        return null;
    }

    private boolean isWin()
    {
        return false;
    }
}
