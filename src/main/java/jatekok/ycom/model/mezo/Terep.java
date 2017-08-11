package jatekok.ycom.model.mezo;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Terep extends Mezo
{
    private final boolean jarhatoe;

    public Terep()
    {
        this.jarhatoe = true;
    }

    public boolean isJarhatoe()
    {
        return jarhatoe;
    }
}
