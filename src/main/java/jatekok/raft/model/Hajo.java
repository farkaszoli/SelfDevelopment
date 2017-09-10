package jatekok.raft.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Hajo
{
    private final int szelesseg;
    private final int magassag;

    public Hajo()
    {
        this.szelesseg = 2;
        this.magassag = 2;
    }

    public int getSzelesseg()
    {
        return szelesseg;
    }

    public int getMagassag()
    {
        return magassag;
    }
}
