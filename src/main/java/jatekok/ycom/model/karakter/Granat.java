package jatekok.ycom.model.karakter;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Granat
{
    private int granatokSzama;
    private int sebzes;

    public Granat()
    {
        this.granatokSzama = 3;
        this.sebzes = 40;
    }

    public int getGranatokSzama()
    {
        return granatokSzama;
    }

    public void setGranatokSzama(int granatokSzama)
    {
        this.granatokSzama = granatokSzama;
    }

    public int getSebzes()
    {
        return sebzes;
    }
}
