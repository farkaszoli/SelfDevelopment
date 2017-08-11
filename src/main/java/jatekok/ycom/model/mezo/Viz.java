package jatekok.ycom.model.mezo;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Viz extends Mezo
{
    private final boolean jarhatoe;

    public Viz()
    {
        this.jarhatoe = false;
    }

    public boolean isJarhatoe()
    {
        return jarhatoe;
    }
}
