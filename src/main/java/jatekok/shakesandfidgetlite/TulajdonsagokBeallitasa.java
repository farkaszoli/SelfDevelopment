package jatekok.shakesandfidgetlite;

import jatekok.shakesandfidgetlite.model.faj.Faj;
import jatekok.shakesandfidgetlite.model.kaszt.Felderito;
import jatekok.shakesandfidgetlite.model.kaszt.Harcos;
import jatekok.shakesandfidgetlite.model.kaszt.Kaszt;
import jatekok.shakesandfidgetlite.model.kaszt.Magus;

public class TulajdonsagokBeallitasa
{
    public static Kaszt tulajdonsagokBeallitasa(String kaszt, String faj)
    {
        if ("felderito".equals(kaszt))
        {
            Kaszt harcos;

            if (faj.equals(Faj.EMBER.getFajTipus()))
            {
                harcos = new Harcos(Faj.EMBER);
                harcos.setEro(harcos.getEro());
                harcos.setUgyesseg(harcos.getUgyesseg());
                harcos.setErtelem(harcos.getErtelem());
                harcos.setKitartas(harcos.getKitartas());

                return harcos;

            } else if (Faj.ORK.equals(faj))
            {
                harcos = new Harcos(Faj.ORK);
                harcos.setEro(harcos.getEro() + 1);
                harcos.setUgyesseg(harcos.getUgyesseg());
                harcos.setErtelem(harcos.getErtelem() - 1);
                harcos.setKitartas(harcos.getKitartas());

                return harcos;

            } else if (Faj.ELF.equals(faj))
            {
                harcos = new Harcos(Faj.ELF);
                harcos.setEro(harcos.getEro() - 1);
                harcos.setUgyesseg(harcos.getUgyesseg() + 2);
                harcos.setErtelem(harcos.getErtelem());
                harcos.setKitartas(harcos.getKitartas() - 1);

                return harcos;

            } else if (Faj.TORP.equals(faj))
            {
                harcos = new Harcos(Faj.TORP);
                harcos.setEro(harcos.getEro());
                harcos.setUgyesseg(harcos.getUgyesseg() - 2);
                harcos.setErtelem(harcos.getErtelem() - 1);
                harcos.setKitartas(harcos.getKitartas() + 2);

                return harcos;

            } else if (Faj.DEMON.equals(faj))
            {
                harcos = new Harcos(Faj.DEMON);
                harcos.setEro(harcos.getEro() + 3);
                harcos.setUgyesseg(harcos.getUgyesseg() - 1);
                harcos.setErtelem(harcos.getErtelem());
                harcos.setKitartas(harcos.getKitartas() + 1);

                return harcos;
            }
        } else if ("magus".equals(kaszt))
        {
            Kaszt magus;

            if (faj.equals(Faj.EMBER.getFajTipus()))
            {
                magus = new Magus(Faj.EMBER);
                magus.setEro(magus.getEro());
                magus.setUgyesseg(magus.getUgyesseg());
                magus.setErtelem(magus.getErtelem());
                magus.setKitartas(magus.getKitartas());

                return magus;

            } else if (Faj.ORK.equals(faj))
            {
                magus = new Magus(Faj.ORK);
                magus.setEro(magus.getEro() + 1);
                magus.setUgyesseg(magus.getUgyesseg());
                magus.setErtelem(magus.getErtelem() - 1);
                magus.setKitartas(magus.getKitartas());

                return magus;

            } else if (Faj.ELF.equals(faj))
            {
                magus = new Magus(Faj.ELF);
                magus.setEro(magus.getEro() - 1);
                magus.setUgyesseg(magus.getUgyesseg() + 2);
                magus.setErtelem(magus.getErtelem());
                magus.setKitartas(magus.getKitartas() - 1);

                return magus;

            } else if (Faj.TORP.equals(faj))
            {
                magus = new Magus(Faj.TORP);
                magus.setEro(magus.getEro());
                magus.setUgyesseg(magus.getUgyesseg() - 2);
                magus.setErtelem(magus.getErtelem() - 1);
                magus.setKitartas(magus.getKitartas() + 2);

                return magus;

            } else if (Faj.DEMON.equals(faj))
            {
                magus = new Magus(Faj.DEMON);
                magus.setEro(magus.getEro() + 3);
                magus.setUgyesseg(magus.getUgyesseg() - 1);
                magus.setErtelem(magus.getErtelem());
                magus.setKitartas(magus.getKitartas() + 1);

                return magus;
            }
        } else if ("felderito".equals(kaszt))
        {
            Kaszt felderito;

            if (faj.equals(Faj.EMBER.getFajTipus()))
            {
                felderito = new Felderito(Faj.EMBER);
                felderito.setEro(felderito.getEro());
                felderito.setUgyesseg(felderito.getUgyesseg());
                felderito.setErtelem(felderito.getErtelem());
                felderito.setKitartas(felderito.getKitartas());

                return felderito;

            } else if (Faj.ORK.equals(faj))
            {
                felderito = new Felderito(Faj.ORK);
                felderito.setEro(felderito.getEro() + 1);
                felderito.setUgyesseg(felderito.getUgyesseg());
                felderito.setErtelem(felderito.getErtelem() - 1);
                felderito.setKitartas(felderito.getKitartas());

                return felderito;

            } else if (Faj.ELF.equals(faj))
            {
                felderito = new Felderito(Faj.ELF);
                felderito.setEro(felderito.getEro() - 1);
                felderito.setUgyesseg(felderito.getUgyesseg() + 2);
                felderito.setErtelem(felderito.getErtelem());
                felderito.setKitartas(felderito.getKitartas() - 1);

                return felderito;

            } else if (Faj.TORP.equals(faj))
            {
                felderito = new Felderito(Faj.TORP);
                felderito.setEro(felderito.getEro());
                felderito.setUgyesseg(felderito.getUgyesseg() - 2);
                felderito.setErtelem(felderito.getErtelem() - 1);
                felderito.setKitartas(felderito.getKitartas() + 2);

                return felderito;

            } else if (Faj.DEMON.equals(faj))
            {
                felderito = new Felderito(Faj.DEMON);
                felderito.setEro(felderito.getEro() + 3);
                felderito.setUgyesseg(felderito.getUgyesseg() - 1);
                felderito.setErtelem(felderito.getErtelem());
                felderito.setKitartas(felderito.getKitartas() + 1);

                return felderito;
            }
        }

        return null;
    }
}
