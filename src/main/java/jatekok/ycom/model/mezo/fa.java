package jatekok.ycom.model.mezo;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Fa extends Mezo
{
    private final boolean jarhatoe;

    public Fa()
    {
        this.jarhatoe = false;
    }

    public boolean isJarhatoe()
    {
        return jarhatoe;
    }
}
