package jatekok.wumpus.game;

import jatekok.wumpus.model.table.Table;
import org.springframework.stereotype.Component;

@Component
public class CreateTable
{
    public Table createATable(int tableSize)
    {
        Table gameTable = new Table(tableSize);

        return gameTable;
    }
}
