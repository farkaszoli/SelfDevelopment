package jatekok.wumpus;

import jatekok.wumpus.model.room.RoomLevel;
import jatekok.wumpus.model.table.Table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static jatekok.wumpus.model.room.RoomLevel.*;

public class Main
{
    // TODO: add pmd check style, create unit tests and add mocks, use testng, log4j

    public static void main(String[] args) throws IOException
    {
        System.out.println("Wampus world");

        String gameLevel = getLevel();

        createTable(gameLevel);
    }

    // TODO: create new class for this method
    private static String getLevel() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter game level(easy, medium, hard): ");

        return br.readLine();
    }

    // TODO: refactor this and create random generator for this method (generate table structure), create unit tests
    private static void createTable(String gameLevel)
    {
        switch (valueOf(gameLevel))
        {
            case EASY:
                new Table(6);
                break;
            case MEDIUM:
                new Table(9);
                break;
            case HARD:
                new Table(11);
                break;
        }
    }
}
