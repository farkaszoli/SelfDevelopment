package jatekok.wumpus.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class TableElement
{
    private boolean isEmpty;

    public boolean isEmpty()
    {
        return isEmpty;
    }

    public void setEmpty(boolean isEmpty)
    {
        this.isEmpty = isEmpty;
    }
}
