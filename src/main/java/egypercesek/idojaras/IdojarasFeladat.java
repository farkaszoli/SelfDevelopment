package egypercesek.idojaras;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//http://www.webotlet.hu/?p=1112
public class IdojarasFeladat
{
    private static final File FILE
            = new File("E:\\Epam\\repok\\SelfDevelopmentProject\\src\\main\\resources\\idojaras.csv");
    private static final List<Idojaras> idojarasLista = new ArrayList<>();

    public static List<Idojaras> beolvas()
    {
        int oraSzam = 0;

        try (Scanner scanner = new Scanner(FILE))
        {
            scanner.nextLine();

            while (scanner.hasNextLine())
            {
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

    // Hány órakor volt a legmelegebb?
    public void legmelegebb()
    {
        List<Idojaras> idojarasLista = beolvas();
        int legmelegebb = 0;
        int legmelegebbOra = 0;
        for(Idojaras idojaras : idojarasLista)
        {
            if (idojaras.getHomerseklet() > legmelegebb)
            {
                legmelegebb = idojaras.getHomerseklet();
                legmelegebbOra = idojaras.getOra();

            }
        }

        System.out.print("legmelegebb ora: " + legmelegebbOra + " orakkor!");
    }

//    Mikor fújt a legerősebben a szél?
    public void legerosebbSzel()
    {
        List<Idojaras> idojarasLista = beolvas();
        int legerosebben = 0;
        int legmelegebbOra = 0;
        for(Idojaras idojaras : idojarasLista)
        {
            if (idojaras.getSzelerosseg() > legerosebben)
            {
                legerosebben = idojaras.getSzelerosseg();
                legmelegebbOra = idojaras.getOra();

            }
        }

        System.out.print("legerosebben fujt: " + legmelegebbOra + " orakkor!");
    }

//    Mikor fújt ÉNY a szél?

    //  Hányszor volt borult az ég?
    public void borultEg()
    {
        List<Idojaras> idojarasLista = beolvas();
        int borultEg = 0;
        for(Idojaras idojaras : idojarasLista)
        {
            if ("borult".equals(idojaras.getIdokep()))
            {
                borultEg++;
            }
        }

        System.out.print("borult: " + borultEg + " alkalommal!");
    }
}
