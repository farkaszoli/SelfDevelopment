package jatekok.shakesandfidgetlite.kuldetes;

import jatekok.shakesandfidgetlite.model.kaszt.Kaszt;

public class Jatek
{
    public void jatekMenet(Kaszt jatekos)
    {
        Kaszt gepiJatekos = ellenfelLetrehozasa(jatekos);

        // kiJon = true akkor jatekos
        boolean kiJon = true;

        while(jatekos.getErtelem() <= 0 || gepiJatekos.getEletero() <= 0)
        {
            // TODO: jatek kiszamitasa
            if( kiJon)
            {
                Harc.harc(jatekos, null);
            } else
            {
                Harc.harc(null, gepiJatekos);
            }

            jatekosCsere(kiJon);
        }

        // TODO: gyoztes
    }

    public static Kaszt ellenfelLetrehozasa(Kaszt jatekos)
    {
        return new Kaszt(jatekos.getFajModel(), jatekos.getEro(), jatekos.getUgyesseg(),
                jatekos.getErtelem(), jatekos.getKitartas(), jatekos.getSzint() - 1, null,
                jatekos.getSebzes(), jatekos.getEletero() );
    }

    private boolean jatekosCsere(boolean kiJon)
    {
        return kiJon == true ? false : true;
    }
}
