package jatekok.ycom.model.karakter;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

@EqualsAndHashCode
@ToString
public class Karakter
{
    private int eletero;
    private int karakterekSzama;
    private int granatokSzam;

    public Karakter()
    {
        this.eletero = 100;
        this.karakterekSzama = 3;
        this.granatokSzam = 3;
    }

    public int getEletero()
    {
        return eletero;
    }

    public void setEletero(int eletero)
    {
        this.eletero = eletero;
    }

    public int getKarakterekSzama()
    {
        return karakterekSzama;
    }

    public void setKarakterekSzama(int karakterekSzama)
    {
        this.karakterekSzama = karakterekSzama;
    }

    public int getGranatokSzam()
    {
        return granatokSzam;
    }

    public void setGranatokSzam(int granatokSzam)
    {
        this.granatokSzam = granatokSzam;
    }
}
