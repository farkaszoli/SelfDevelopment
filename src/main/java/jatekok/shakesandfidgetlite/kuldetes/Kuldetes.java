package jatekok.shakesandfidgetlite.kuldetes;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Kuldetes
{
    private int kultedesSzint;
    private int tapasztalatiPont = 0;
    private int kuldetesSzam = 0;
    private int aranySzama;

    public Kuldetes(int kultedesSzint)
    {
        this.kultedesSzint = kultedesSzint;
    }

    public int getKultedesSzint()
    {
        return kultedesSzint;
    }

    public void tapasztalatiPontSzamitasa()
    {
        if( tapasztalatiPont > 100)
        {

        }
    }

    public int getKuldetesSzam()
    {
        return kuldetesSzam;
    }

    private int kuldetesertJaroArany(int kuldetesSzint)
    {
        Random r = new Random();

        if( kuldetesSzint == 1)
        {
         return r.nextInt(10) + 30;
        }

        return r.nextInt(15) + 30;
    }
}
