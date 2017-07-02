package jatekok.shakesandfidgetlite.kuldetes;

import jatekok.shakesandfidgetlite.model.kaszt.Kaszt;

public class Jatek
{
    public void jatekMenet(Kaszt jatekos, Kaszt gepiJatekos)
    {
        // kiJon = true akkor jatekos
        boolean kiJon = true;
        while(jatekos.getErtelem() <= 0 || gepiJatekos.getEletero() <= 0)
        {
            jatekosCsere(kiJon);
        }
    }

    private boolean jatekosCsere(boolean kiJon)
    {
        return kiJon == true ? false : true;
    }
}
