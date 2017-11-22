package jatekok.wumpus.model.table;

import jatekok.wumpus.model.TableElement;
import jatekok.wumpus.model.room.Room;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Table
{
    private TableElement tableElement;

    public TableElement getTableElement()
    {
        return tableElement;
    }

    public void setTableElement(TableElement tableElement)
    {
        this.tableElement = tableElement;
    }
}
