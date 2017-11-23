package jatekok.wumpus;

import jatekok.wumpus.game.CreateTable;
import jatekok.wumpus.game.GamePlay;

import java.io.IOException;

public class Main
{
    // TODO: add pmd check style, create unit tests and add mocks, use testng, log4j

    private static CreateTable createTable = new CreateTable();
    private final static GamePlay gamePlay = new GamePlay(createTable);

    public static void main(String[] args) throws IOException
    {
        System.out.println("Wampus world");

        gamePlay.createTable();

        // todo controller settings
    }


}
