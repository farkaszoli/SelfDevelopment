package jatekok.ycom.model.mezo;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Szikla extends Mezo
{
    private final boolean jarhatoe;

    public Szikla()
    {
        this.jarhatoe = false;
    }

    public boolean isJarhatoe()
    {
        return jarhatoe;
    }
}
