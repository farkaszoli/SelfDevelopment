package jatekok.raft.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Palya
{
    private final int szelesseg;
    private final int magassag;

    public Palya()
    {
        this.szelesseg = 35;
        this.magassag = 25;
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
