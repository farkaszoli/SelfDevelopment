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
        int jatekosEllenallasa = jatekos.getErtelem() / 2;
        int gepEllenallasa = gepiEllenfel.getErtelem() / 2;

        // 1. kör
        gepiEllenfel.setSebzes(gepiEllenfel.getSebzes() - jatekosEllenallasa);
        jatekos.setSebzes(jatekos.getSebzes() - gepEllenallasa);

        // 2. körtől
        gepiEllenfel.setSebzes(gepiEllenfel.getSebzes() - (jatekosEllenallasa / 2));
        jatekos.setSebzes(jatekos.getSebzes() - (gepEllenallasa / 2));
        /*
        Van lehetőség a kitérésre is, kitérni mindig a védekező fél tud,
        ami úgy alakul, hogy a védekező ügyességéből kivonjuk a támadó értelem értékét, amennyiben ez
        pozitív szám, akkor a védekező 25% eséllyel nem szenved el sebzést. Amennyiben ez az érték 0
        vagy kisebb lenne, akkor a támadó biztosan eltalálja a védekezőt.
         */

        // kitérés
        jatekos.setUgyesseg(jatekos.getUgyesseg() - gepEllenallasa);
        gepiEllenfel.setUgyesseg(gepiEllenfel.getUgyesseg() - jatekosEllenallasa);
    }

    private Kaszt ellenfelLetrehozasa(Kaszt jatekos)
    {
        return new Kaszt(jatekos.getFajModel(), jatekos.getEro(), jatekos.getUgyesseg(),
                jatekos.getErtelem(), jatekos.getKitartas(), jatekos.getSzint() - 1, null,
                jatekos.getSebzes(), jatekos.getEletero() );
    }
}
