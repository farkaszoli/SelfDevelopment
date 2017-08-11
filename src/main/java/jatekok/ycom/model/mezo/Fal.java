package jatekok.ycom.model.mezo;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Fal extends Mezo
{
    private final boolean jarhatoe;

    public Fal()
    {
        this.jarhatoe = false;
    }

    public boolean isJarhatoe()
    {
        return jarhatoe;
    }
}
