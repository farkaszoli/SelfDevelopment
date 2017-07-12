package jatekok.shakesandfidgetlite.kuldetes;

import jatekok.shakesandfidgetlite.model.kaszt.Kaszt;

public class Jatek
{
    Harc harc = new Harc();

    public void jatekMenet(Kaszt jatekos)
    {
        Kaszt gepiJatekos = ellenfelLetrehozasa(jatekos);

        // kiJon = true akkor jatekos
        boolean kiJon = true;

        while(gepiJatekos.getEletero() >= 0)
        {
            // TODO: jatek kiszamitasa
            if( kiJon)
            {
                harc.harcAKetJatekosKozott(jatekos, null);
            } else
            {
                harc.harcAKetJatekosKozott(null, gepiJatekos);
            }

            jatekosCsere(kiJon);
        }

        // TODO: gyoztes
    }

    // hasonlo erossegu kell legyen mint a mi jatekosunk
    public static Kaszt ellenfelLetrehozasa(Kaszt jatekos)
    {
        return new Kaszt(jatekos.getFajModel(), jatekos.getEro(), jatekos.getUgyesseg(),
                jatekos.getErtelem(), jatekos.getKitartas());
    }

    private boolean jatekosCsere(boolean kiJon)
    {
        return kiJon == true ? false : true;
    }
}
