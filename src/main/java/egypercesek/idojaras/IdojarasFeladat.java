package egypercesek.idojaras;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

//  http://www.webotlet.hu/?p=1112
public class IdojarasFeladat {
    // TODO: all task with java8
    // TODO: add unit tests
    // TODO: use enum
    private static final File FILE
            = new File("E:\\Epam\\repok\\SelfDevelopmentProject\\src\\main\\resources\\idojaras.csv");
    private static final List<Idojaras> idojarasLista = new ArrayList<>();

    // 1. beolvasas
    public static List<Idojaras> beolvas() {
        int oraSzam = 0;

        try (Scanner scanner = new Scanner(FILE)) {
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String sor = scanner.nextLine();
                String[] idojarasFilebol = sor.split(";");

                String idokep = idojarasFilebol[0];
                int homerseklet = Integer.valueOf(idojarasFilebol[1]);
                int szelirany = Integer.valueOf(idojarasFilebol[2]);
                int szelerosseg = Integer.valueOf(idojarasFilebol[3]);
                int legnyomas = Integer.valueOf(idojarasFilebol[4]);
                double paratartalom = Double.valueOf(idojarasFilebol[5]);
                int ora = oraSzam;

                Idojaras idojaras = new Idojaras(idokep, homerseklet, szelirany, szelerosseg, legnyomas, paratartalom, ora);
                idojarasLista.add(idojaras);
                oraSzam++;
            }
        } catch (Exception e) {
            System.out.print("Error: " + e.getMessage());
        }
        return idojarasLista;
    }

    // 2. Hány órakor volt a legmelegebb?
    public int legmelegebb() {
        List<Idojaras> idojarasLista = beolvas();
        int legmelegebb = 0;
        int legmelegebbOra = 0;
        for (Idojaras idojaras : idojarasLista) {
            if (idojaras.getHomerseklet() > legmelegebb) {
                legmelegebb = idojaras.getHomerseklet();
                legmelegebbOra = idojaras.getOra();

            }
        }

        System.out.print("legmelegebb ora: " + legmelegebbOra + " orakkor!");

        return legmelegebbOra;
    }

    //   3. Mikor fújt a legerősebben a szél?
    public void legerosebbSzel() {
        List<Idojaras> idojarasLista = beolvas();
        int legerosebben = 0;
        int legmelegebbOra = 0;
        for (Idojaras idojaras : idojarasLista) {
            if (idojaras.getSzelerosseg() > legerosebben) {
                legerosebben = idojaras.getSzelerosseg();
                legmelegebbOra = idojaras.getOra();

            }
        }

        System.out.print("legerosebben fujt: " + legmelegebbOra + " orakkor!");
    }

//    4. Mikor fújt ÉNY a szél?
    public void fujtENySzel()
    {
        List<Idojaras> idojarasLista = beolvas();

        idojarasLista.stream()
                .filter(idojaras -> idojaras.getSzelirany() > 270)
                .filter(idojaras -> idojaras.getSzelirany() < 360)
                .forEach(idojaras -> System.out.print(idojaras.getOra() + ", "));
    }


    // 5. Hányszor volt borult az ég?
    public void borultEg() {
        List<Idojaras> idojarasLista = beolvas();
        int borultEg = 0;
        for (Idojaras idojaras : idojarasLista) {
            if ("borult".equals(idojaras.getIdokep())) {
                borultEg++;
            }
        }

        System.out.print("borult: " + borultEg + " alkalommal!");
    }

    //   6. Mennyi volt a napi hőingás?
    public void napiHoIngas() {
        List<Idojaras> idojarasLista = beolvas();
        int leghidegebb = 0;
        int legmelegebb = 0;
        for (Idojaras idojaras : idojarasLista) {
            if (idojaras.getHomerseklet() > legmelegebb) {
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
    public void fagypontokSzam() {
        List<Idojaras> idojarasLista = beolvas();

        int fagypontokSzama = idojarasLista.stream()
                .filter(idojaras -> idojaras.getHomerseklet() == 0)
                .collect(Collectors.toList()).size();

        System.out.print(fagypontokSzama);
    }

    // 8. Hány olyan időszak volt, amikor fagyott? (amikor tartósan negatív a hőmérséklet)
    public void fagyott() {
        List<Idojaras> idojarasLista = beolvas();

        int fagyott = idojarasLista.stream()
                .filter(idojaras -> idojaras.getHomerseklet() <= 0)
                .collect(Collectors.toList()).size();

        System.out.print(fagyott);
    }

    //   9. Hányszor emelkedett a hőmérséklet az előző órához képest?
    public void emelkedett() {
        List<Idojaras> idojarasLista = beolvas();
        int db = 0;
        int elozo = 0;

        for (Idojaras idojaras : idojarasLista) {
            if (idojaras.getHomerseklet() > elozo) {
                db++;
            }
            elozo = idojaras.getHomerseklet();
        }

        System.out.print(db);
    }

    // 10. Milyen irányból fújt a szél, amikor a legmelegebb volt? (E, EK, K, DK, stb..)
    public void szelIrany() {
        List<Idojaras> idojarasLista = beolvas();

        int legmelegebbOra = legmelegebb();
        int szelirany = 0;

        for (Idojaras idojaras : idojarasLista) {
            if (idojaras.getOra() == legmelegebbOra) {
                szelirany = idojaras.getSzelirany();
            }
        }

        getSzelirany(szelirany);
    }

    //   11. Mennyi volt a nappali átlaghőmérséklet, ha tudjuk, hogy 7:01-kor volt napkelte és 16:48-kor volt napnyugta?
    public void nappaliAtlagHomerseklet()
    {
        List<Idojaras> idojarasLista = beolvas();

        int ossz = 0;
        int darab = 0;
        double atlag;
        for(Idojaras idojaras : idojarasLista)
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
