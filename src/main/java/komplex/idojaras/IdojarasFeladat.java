package komplex.idojaras;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

//  http://www.webotlet.hu/?p=1112
public class IdojarasFeladat
{
    // TODO: all task with java8
    // TODO: add unit tests

    private static Reader reader = new Reader();
    private static final List<Idojaras> IDOJARAS_LISTA = reader.beolvas();

    public void kiir()
    {
        IDOJARAS_LISTA.stream()
                .forEach(idojaras -> System.out.println(idojaras.toString()));
    }

    // 2. Hány órakor volt a legmelegebb?
    public int legmelegebb()
    {
        int legmelegebb = 0;
        int legmelegebbOra = 0;

        for (Idojaras idojaras : IDOJARAS_LISTA) {
            if (idojaras.getHomerseklet() > legmelegebb) {
                legmelegebb = idojaras.getHomerseklet();
                legmelegebbOra = idojaras.getOra();

            }
        }

        System.out.print("legmelegebb ora: " + legmelegebbOra + " orakkor!");

        return legmelegebbOra;
    }

    //   3. Mikor fújt a legerősebben a szél?
    public void legerosebbSzel()
    {
        int legerosebben = 0;
        int legmelegebbOra = 0;

        for (Idojaras idojaras : IDOJARAS_LISTA) {
            if (idojaras.getSzelerosseg() > legerosebben)
            {
                legerosebben = idojaras.getSzelerosseg();
                legmelegebbOra = idojaras.getOra();
            }
        }

        System.out.print("legerosebben fujt: " + legmelegebbOra + " orakkor!");
    }

//    4. Mikor fújt ÉNY a szél?
    public void fujtENySzel()
    {
        IDOJARAS_LISTA.stream()
                .filter(idojaras -> idojaras.getSzelirany() > 270)
                .filter(idojaras -> idojaras.getSzelirany() < 360)
                .forEach(idojaras -> System.out.print(idojaras.getOra() + ", "));
    }

    // 5. Hányszor volt borult az ég?
    public void borultEg()
    {
        int borultEg = 0;
        for (Idojaras idojaras : IDOJARAS_LISTA) {
            if ("borult".equals(idojaras.getIdokep())) {
                borultEg++;
            }
        }

        System.out.print("borult: " + borultEg + " alkalommal!");
    }

    //   6. Mennyi volt a napi hőingás?
    public void napiHoIngas()
    {
        int leghidegebb = 0;
        int legmelegebb = 0;

        for (Idojaras idojaras : IDOJARAS_LISTA)
        {
            if (idojaras.getHomerseklet() > legmelegebb)
            {
                legmelegebb = idojaras.getHomerseklet();
            }

            if (idojaras.getHomerseklet() < leghidegebb) {
                leghidegebb = idojaras.getHomerseklet();
            }
        }

        int osszeg = abs(leghidegebb) + legmelegebb;
        System.out.print("hoingas: " + osszeg + " fok");
    }

    //    7. Hányszor volt fagypont?
    public void fagypontokSzam()
    {
        int fagypontokSzama = IDOJARAS_LISTA.stream()
                .filter(idojaras -> idojaras.getHomerseklet() == 0)
                .collect(Collectors.toList()).size();

        System.out.print(fagypontokSzama);
    }

    // 8. Hány olyan időszak volt, amikor fagyott? (amikor tartósan negatív a hőmérséklet)
    public void fagyott()
    {
        int fagyott = IDOJARAS_LISTA.stream()
                .filter(idojaras -> idojaras.getHomerseklet() <= 0)
                .collect(Collectors.toList()).size();

        System.out.print(fagyott);
    }

    //   9. Hányszor emelkedett a hőmérséklet az előző órához képest?
    public void emelkedett()
    {
        int db = 0;
        int elozo = 0;

        for (Idojaras idojaras : IDOJARAS_LISTA) {
            if (idojaras.getHomerseklet() > elozo) {
                db++;
            }
            elozo = idojaras.getHomerseklet();
        }

        System.out.print(db);
    }

    // 10. Milyen irányból fújt a szél, amikor a legmelegebb volt? (E, EK, K, DK, stb..)
    public void szelIrany()
    {
        int legmelegebbOra = legmelegebb();
        int szelirany = 0;

        for (Idojaras idojaras : IDOJARAS_LISTA) {
            if (idojaras.getOra() == legmelegebbOra) {
                szelirany = idojaras.getSzelirany();
            }
        }

        getSzelirany(szelirany);
    }

    //   11. Mennyi volt a nappali átlaghőmérséklet, ha tudjuk, hogy 7:01-kor volt napkelte és 16:48-kor volt napnyugta?
    public void nappaliAtlagHomerseklet()
    {
        int ossz = 0;
        int darab = 0;
        double atlag;

        for(Idojaras idojaras : IDOJARAS_LISTA)
        {
            if(idojaras.getOra() > 7 && idojaras.getOra() < 17)
            {
                ossz += idojaras.getHomerseklet();
                darab++;
            }
        }

        atlag = (double) ossz / (double) darab;
        System.out.print(atlag);
    }

    static Idokep getIdokep(String idokep)
    {
        switch (idokep)
        {
            case "derult":
                return Idokep.DERULT;
            case "valtozoan felhos":
                return Idokep.VALTOZOAN_FELHOS;
            case "borult":
                return Idokep.BORULT;
            case "szeles":
                return Idokep.SZELES;
            case "hozapor":
                return Idokep.HO_ZAPOR;
            default:
                return null;
        }
    }

    private void getSzelirany(int szelirany) {
        if(szelirany == 0 || szelirany == 360)
        {
            System.out.print("E");
        }
        else if(szelirany > 0 && szelirany < 90)
        {
            System.out.print("EK");
        }
        else if(szelirany == 90)
        {
            System.out.print("K");
        }
        else if(szelirany > 90 && szelirany < 180)
        {
            System.out.print("DK");
        }
        else if(szelirany == 180)
        {
            System.out.print("K");
        }
        else if(szelirany > 180 && szelirany < 270)
        {
            System.out.print("DNY");
        }
        else if(szelirany > 270)
        {
            System.out.print("NY");
        }
        else if(szelirany > 270 && szelirany < 360)
        {
            System.out.print("ENY");
        }
    }
}
