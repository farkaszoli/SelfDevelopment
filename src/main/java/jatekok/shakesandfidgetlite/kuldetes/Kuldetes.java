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
    private double qp = 80;

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
            // TODO next commit
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

    public void harc(int eletero, int maxEletero, int szint, int kuldetesSzint)
    {
        if ( eletero / maxEletero >= 0.3)
        {
            if (kuldetesSzint == 1)
            {
                csata();
                qp = qp * 1.12;
            } else
            {
                csata();
                qp = qp * 1.20;
            }
        }
        else
        {
            System.out.println("keves az eleteronk!");
        }
    }

    public double qpSzamitasa(int szint)
    {
        return szint * 0.66;
    }

    private void csata()
    {
        aranySzama++; tapasztalatiPont++;
    }


}
