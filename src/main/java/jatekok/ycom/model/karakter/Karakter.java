package jatekok.ycom.model.karakter;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Karakter
{
    private int eletero;
    private int karakterekSzama;

    public Karakter()
    {
        this.eletero = 100;
        this.karakterekSzama = 3;
    }

    public int getEletero()
    {
        return eletero;
    }

    public int getKarakterekSzama()
    {
        return karakterekSzama;
    }
}
