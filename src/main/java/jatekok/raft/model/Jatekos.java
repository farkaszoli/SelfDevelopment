package jatekok.raft.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Jatekos
{
    private final Cselekves cselekves;
    private final int cselekvesekSzama;
    private final Hajo hajo;
    private final int ehseg;
    private final int szomjusag;

    public Jatekos(Cselekves cselekves, int cselekvesekSzama, Hajo hajo)
    {
        this.cselekves = cselekves;
        this.cselekvesekSzama = cselekvesekSzama;
        this.hajo = hajo;
        this.ehseg = 100;
        this.szomjusag = 100;
    }

    public Cselekves getCselekves()
    {
        return cselekves;
    }

    public int getCselekvesekSzama()
    {
        return cselekvesekSzama;
    }

    public Hajo getHajo()
    {
        return hajo;
    }

    public int getEhseg()
    {
        return ehseg;
    }

    public int getSzomjusag()
    {
        return szomjusag;
    }
}
