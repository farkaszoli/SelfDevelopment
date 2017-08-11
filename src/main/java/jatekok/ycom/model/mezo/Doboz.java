package jatekok.ycom.model.mezo;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Doboz extends Mezo
{
    private final boolean jarhatoe;

    public Doboz()
    {
        this.jarhatoe = true;
    }

    public boolean isJarhatoe()
    {
        return jarhatoe;
    }
}
