package jatekok.raft.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Jatekos
{
    private final Cselekves cselekves;
    private final int cselekvesekSzama;

    public Jatekos(Cselekves cselekves, int cselekvesekSzama)
    {
        this.cselekves = cselekves;
        this.cselekvesekSzama = cselekvesekSzama;
    }

    public Cselekves getCselekves()
    {
        return cselekves;
    }

    public int getCselekvesekSzama()
    {
        return cselekvesekSzama;
    }
}
