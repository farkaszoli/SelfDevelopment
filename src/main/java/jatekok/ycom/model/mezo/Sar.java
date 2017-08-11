package jatekok.ycom.model.mezo;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Sar extends Mezo
{
    private final boolean jarhatoe;
    private final int lepesPontKoltsege;

    public Sar()
    {
        this.jarhatoe = true;
        this.lepesPontKoltsege = 2;
    }

    public boolean isJarhatoe()
    {
        return jarhatoe;
    }

    public int getLepesPontKoltsege()
    {
        return lepesPontKoltsege;
    }
}
