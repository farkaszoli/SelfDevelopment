package jatekok.shakesandfidgetlite.kuldetes;

import jatekok.shakesandfidgetlite.model.kaszt.Kaszt;

public class Harc
{
    public void csata(Kaszt jatekos)
    {
        Kaszt gepiEllenfel = ellenfelLetrehozasa(jatekos);

        harc(jatekos, gepiEllenfel);
    }

    private void harc(Kaszt jatekos, Kaszt gepiEllenfel)
    {

    }

    private Kaszt ellenfelLetrehozasa(Kaszt jatekos)
    {
        return new Kaszt(jatekos.getFajModel(), jatekos.getEro(), jatekos.getUgyesseg(),
                jatekos.getErtelem(), jatekos.getKitartas(), jatekos.getSzint() - 1, null,
                jatekos.getSebzes(), jatekos.getEletero() );
    }
}
