package jatekok.ycom.model.terkep;

import jatekok.ycom.model.mezo.Mezo;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Terkep
{
    private final Mezo[][] terkep;

    public Terkep()
    {
        this.terkep = new Mezo[39][39];
    }

    public Mezo[][] getTerkep()
    {
        return terkep;
    }
}
