package jatekok.shakesandfidgetlite.kuldetes;

import jatekok.shakesandfidgetlite.model.kaszt.Kaszt;

public class Harc
{
    private int jatekosEllenallasa;
    private int gepEllenallasa;
    private int korokSzama = 0;
    // TODO kerdeses
    private boolean kiteres = false;

    public void harcAKetJatekosKozott(Kaszt jatekos, Kaszt gepiEllenfel)
    {
        if( korokSzama > 2)
        {
            jatekosEllenallasa = jatekos.getErtelem() / 2;
            gepEllenallasa = gepiEllenfel.getErtelem() / 2;

            gepiEllenfel.setSebzes(gepiEllenfel.getSebzes() - jatekosEllenallasa);
            jatekos.setSebzes(jatekos.getSebzes() - gepEllenallasa);
        }

        gepiEllenfel.setSebzes(gepiEllenfel.getSebzes() - (jatekosEllenallasa / 2));
        jatekos.setSebzes(jatekos.getSebzes() - (gepEllenallasa / 2));

        // kitérés
        if(kiteres)
        {
            jatekos.setUgyesseg(jatekos.getUgyesseg() - gepEllenallasa);
            gepiEllenfel.setUgyesseg(gepiEllenfel.getUgyesseg() - jatekosEllenallasa);
        }
        korokSzama++;
    }
}
