package jatekok.shakesandfidgetlite;

import jatekok.shakesandfidgetlite.model.faj.FajModel;
import jatekok.shakesandfidgetlite.model.kaszt.Felderito;
import jatekok.shakesandfidgetlite.model.kaszt.Harcos;
import jatekok.shakesandfidgetlite.model.kaszt.Kaszt;
import jatekok.shakesandfidgetlite.model.kaszt.Magus;

public class TulajdonsagokBeallitasa
{
    public Kaszt tulajdonsagokBeallitasa(String kaszt, String faj)
    {
        if ("felderito".equals(kaszt))
        {
            return new Felderito(fajBeallitasa(faj));

        } else if ("harcos".equals(kaszt))
        {
            return new Harcos(fajBeallitasa(faj));

        } else if ("magus".equals(kaszt))
        {
            return new Magus(fajBeallitasa(faj));
        }

        return null;

    }

    private FajModel fajBeallitasa(String faj)
    {
        return null;
    }
}
