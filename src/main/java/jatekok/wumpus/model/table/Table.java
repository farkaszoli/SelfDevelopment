package jatekok.wumpus.model.table;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Table
{
    // table size: n x n
    private final Room[][] table;

    public Table(int size)
    {
        this.table = new Room[size][size];
    }

    public Room[][] getTable()
    {
        return table;
    }
}
