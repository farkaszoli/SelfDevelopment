package jatekok.shakesandfidgetlite;

import jatekok.shakesandfidgetlite.model.faj.*;
import jatekok.shakesandfidgetlite.model.kaszt.*;

public class TulajdonsagokBeallitasa
{
    // TODO create unit test

    public Kaszt tulajdonsagokBeallitasa(String valasztottKasztTipus, String valasztottFaj)
    {
        Kaszt kaszt = null;

        switch (KasztModel.valueOf(valasztottFaj))
        {
            case FELDERITO:
                kaszt = new Felderito(fajBeallitasa(valasztottFaj)); break;
            case HARCOS:
                kaszt = new Harcos(fajBeallitasa(valasztottFaj)); break;
            case MAGUS:
                kaszt = new Magus(fajBeallitasa(valasztottFaj)); break;
        }

        kasztTulajdonsagokBeallitasa(kaszt);
        return kaszt;

    }

    private FajModel fajBeallitasa(String valasztottFaj)
    {
        if(Faj.DEMON.getFajTipus().equals(valasztottFaj))
        {
            return new Demon();

        } else if(Faj.ELF.getFajTipus().equals(valasztottFaj))
        {
            return new Elf();

        } else if(Faj.EMBER.getFajTipus().equals(valasztottFaj))
        {
            return new Ember();

        } else if(Faj.ORK.getFajTipus().equals(valasztottFaj))
        {
            return new Ork();

        } else if(Faj.TORP.getFajTipus().equals(valasztottFaj))
        {
            return new Torp();
        }

        return null;
    }

    private void kasztTulajdonsagokBeallitasa(Kaszt kaszt)
    {
        FajModel fajModel = kaszt.getFajModel();

        kaszt.setEro(kaszt.getEro() + fajModel.getEro());
        kaszt.setUgyesseg(kaszt.getUgyesseg() + fajModel.getUgyesseg());
        kaszt.setErtelem(kaszt.getErtelem() + fajModel.getErtelem());
        kaszt.setKitartas(kaszt.getKitartas() + fajModel.getKitartas());
        kaszt.setSebzes(1 * (1 + kaszt.getEro() / 10));
        kaszt.setKitartas(kaszt.getKitartas() * 5 * (kaszt.getSzint() + 1));
    }
}
