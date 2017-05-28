package jatekok.shakesandfidgetlite;

import jatekok.shakesandfidgetlite.model.faj.Faj;
import jatekok.shakesandfidgetlite.model.kaszt.Felderito;
import jatekok.shakesandfidgetlite.model.kaszt.Harcos;
import jatekok.shakesandfidgetlite.model.kaszt.Kaszt;
import komplex.sms.Feladatok;

public class TulajdonsagokBeallitasa
{
    public static Kaszt tulajdonsagokBeallitasa(String kaszt, String faj)
    {
        if ("felderito".equals(kaszt))
        {
            Kaszt felderito = new Felderito(Faj.EMBER);

            if (faj.equals(Faj.EMBER.getFajTipus()))
            {

                felderito.setEro(felderito.getEro() - 0);
                felderito.setUgyesseg(felderito.getUgyesseg() - 0);
                felderito.setErtelem(felderito.getErtelem() - 0);
                felderito.setKitartas(felderito.getKitartas() -0 );

                return felderito;

            } else if (Faj.ORK.equals(faj))
            {
                return null;

            } else if (Faj.ELF.equals(faj))
            {
                return null;

            } else if (Faj.TORP.equals(faj))
            {
                return null;

            } else if (Faj.DEMON.equals(faj))
            {
                return null;
            }
        }
        return null;
    }
}
