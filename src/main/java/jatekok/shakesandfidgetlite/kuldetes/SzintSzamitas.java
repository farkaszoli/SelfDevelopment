package jatekok.shakesandfidgetlite.kuldetes;

public class SzintSzamitas
{
    private int szint;
    private int tapasztalatiPont;


    // TOOD teszt osztaly
    public int szintMegadasaTapasztalatiPontAlapjan(int tapasztalatiPont)
    {
        if(tapasztalatiPont > 100)
        {
            return 1;
        }
        else if(tapasztalatiPont > 150)
        {
            return 2;
        }
        else
            return 3;
    }
}
