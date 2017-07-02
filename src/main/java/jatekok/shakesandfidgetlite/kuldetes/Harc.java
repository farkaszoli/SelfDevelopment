package jatekok.shakesandfidgetlite.kuldetes;

import jatekok.shakesandfidgetlite.model.kaszt.Kaszt;

public class Harc
{
    public static void harc(Kaszt jatekos, Kaszt gepiEllenfel)
    {
        int jatekosEllenallasa = jatekos.getErtelem() / 2;
        int gepEllenallasa = gepiEllenfel.getErtelem() / 2;

        // 1. kör
        gepiEllenfel.setSebzes(gepiEllenfel.getSebzes() - jatekosEllenallasa);
        jatekos.setSebzes(jatekos.getSebzes() - gepEllenallasa);

        // 2. körtől
        gepiEllenfel.setSebzes(gepiEllenfel.getSebzes() - (jatekosEllenallasa / 2));
        jatekos.setSebzes(jatekos.getSebzes() - (gepEllenallasa / 2));

        // kitérés
        jatekos.setUgyesseg(jatekos.getUgyesseg() - gepEllenallasa);
        gepiEllenfel.setUgyesseg(gepiEllenfel.getUgyesseg() - jatekosEllenallasa);
    }
}