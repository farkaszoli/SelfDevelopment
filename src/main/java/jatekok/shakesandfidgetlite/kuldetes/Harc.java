package jatekok.shakesandfidgetlite.kuldetes;

import jatekok.shakesandfidgetlite.model.kaszt.Kaszt;
import org.springframework.stereotype.Component;

@Component
public class Harc
{
    private int jatekosEllenallasa;
    private int gepEllenallasa;

    // TODO kerdeses
    private boolean kiteres = false;
    private boolean elsoKor = true;
    private Kaszt gepiEllenfel;

    public void harcAKetJatekosKozott(Kaszt jatekos)
    {
        if (elsoKor)
        {
            gepiEllenfel = gepiEllenfelLetrehozasa(jatekos);
            elsoKor = false;

            gepiEllenfel.setSebzes(gepiEllenfel.getSebzes() - jatekosEllenallasa);
            jatekos.setSebzes(jatekos.getSebzes() - gepEllenallasa);
        }
            jatekosEllenallasa = jatekos.getErtelem() / 2;
            gepEllenallasa = gepiEllenfel.getErtelem() / 2;

            gepiEllenfel.setSebzes(gepiEllenfel.getSebzes() - (jatekosEllenallasa / 2));
            jatekos.setSebzes(jatekos.getSebzes() - (gepEllenallasa / 2));

        // kitérés
        if(kiteres)
        {
            jatekos.setUgyesseg(jatekos.getUgyesseg() - gepEllenallasa);
            gepiEllenfel.setUgyesseg(gepiEllenfel.getUgyesseg() - jatekosEllenallasa);
        }
    }

    private Kaszt gepiEllenfelLetrehozasa(Kaszt jatekos)
    {
        int ero = jatekos.getEro() - 1;
        int ugyesseg = jatekos.getUgyesseg() + 2;
        int ertelem = jatekos.getErtelem() + 1;
        int kitartas = jatekos.getKitartas() + 1;

        return new Kaszt(jatekos.getFajModel(), ero, ugyesseg, ertelem, kitartas);
    }
}
