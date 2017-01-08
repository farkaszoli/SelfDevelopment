package egypercesek.kezilabda;

import egypercesek.kombinaltMegszamlalas.HivasIdopont;
import javafx.geometry.Pos;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//  http://www.webotlet.hu/?p=1129
public class Kezilabda
{
    private static final File FILE
            = new File("E:\\Epam\\repok\\SelfDevelopmentProject\\src\\main\\resources\\kezilabda.csv");
    private static final List<Jatekos> jatekosokLista = new ArrayList<>();

    public List<Jatekos> beolvas()
    {
        try (Scanner scanner = new Scanner(FILE))
        {
            scanner.nextLine();
            boolean fejlec = scanner.hasNextLine();

            while (scanner.hasNextLine())
            {
                String sor = scanner.nextLine();
                String[] jatekosAdatok = sor.split(";");

                String jatekosNev = jatekosAdatok[0];
                Poszt poszt = getPozicio(jatekosAdatok[1]);
                int dobottHetes = Integer.valueOf(jatekosAdatok[2]);
                int ertekesitettHetes = Integer.valueOf(jatekosAdatok[3]);
                String meccsek = jatekosAdatok[4];
                int meccsekSzama = getMeccsekSzama(jatekosAdatok[4]);
                int golokSzama = getGolokSzama(jatekosAdatok[4]);
                BigDecimal golAtlag = BigDecimal.valueOf(golokSzama / meccsekSzama );
                BigDecimal sikeresHetesekSzazaleka = getErtekesitettHetesSzazalek(ertekesitettHetes, dobottHetes);


                Jatekos jatekos = new Jatekos(jatekosNev, poszt, dobottHetes, ertekesitettHetes, meccsek, meccsekSzama,
                        golokSzama, golAtlag, sikeresHetesekSzazaleka);
                jatekosokLista.add(jatekos);
            }
        } catch (Exception e) {
            System.out.print("Error: " + e.getMessage());
        }
        return jatekosokLista;
    }

    private static Poszt getPozicio(String jatekosPozicio)
    {
        Poszt poszt = null;
        switch (jatekosPozicio) {
            case "iranyito":
                poszt = Poszt.IRANYITO;
                break;
            case "atlovo":
                poszt = Poszt.ATLOVO;
                break;
            case "beallo":
                poszt = Poszt.BEALLO;
                break;
            case "balszelso":
                poszt = Poszt.BALSZELSO;
                break;
            case "jobbszelso":
                poszt = Poszt.JOBBSZELSO;
                break;
            case "kapus":
                poszt = Poszt.KAPUS;
                break;
        }
        return poszt;
    }

    private int getMeccsekSzama(String meccsek)
    {
        String[] osszesMeccsLista = meccsek.split(",");
        int meccsekSzama = 0;

        for (String adottMeccs : osszesMeccsLista) {
            try {
                if (!"".equals(adottMeccs)) {
                    meccsekSzama++;
                }
            } catch (NumberFormatException ex) {
                System.out.print("Error: " + ex.getMessage());
            }
        }

        return meccsekSzama;
    }

    private int getGolokSzama(String meccsek)
    {
        String[] osszesMeccsLista = meccsek.split(",");
        int golokSzama = 0;

        for (String adottMeccs : osszesMeccsLista)
        {
            try
            {
                if (!"".equals(adottMeccs))
                {
                    golokSzama += Integer.valueOf(adottMeccs);
                }
            } catch (NumberFormatException ex)
            {
                System.out.print("Error: " + ex.getMessage());
            }
        }

        return golokSzama;
    }

    private BigDecimal getErtekesitettHetesSzazalek(int ertekesitettHetes, int dobottHetes)
    {
        if(dobottHetes != 0 && ertekesitettHetes != 0)
        {
            return BigDecimal.valueOf( (ertekesitettHetes / dobottHetes) * 100);
        }

        return BigDecimal.ZERO;
    }

    public void kiir()
    {
        List<Jatekos> jatekosokLista = beolvas();

        for (Jatekos jatekos : jatekosokLista)
        {
            System.out.println(jatekos.getNev() + ", " + jatekos.getPoszt() + ", " + jatekos.getMeccsekSzama()
            + ", " + jatekos.getGolokSzama() + ", " + jatekos.getGolAtlag() + ", " + jatekos.getSikeresHetesekSzazaleka());
        }
    }

    /**
     * Minden játékosnál számítsd ki a következő adatokat és tárold el ezeket is:
     * Hány mérkőzésen játszott a bajnokságban? ok
     * Hány gólt dobott a bajnokságban? ok
     * Mennyi volt a meccsenkénti gólátlaga? ok
     * Hány akciógólt dobott? (nem hetesekből)?
     * Hány százalékát dobta be a heteseinek? Ha valaki nem dobott hetest, azt az esetet is oldd meg valahogy!
     */
/*
  public void kiszamol()
    {
        List<Jatekos> jatekosokLista = beolvas();
        double szazalek;

        for (Jatekos jatekos : jatekosokLista)
        {

            }

            if (jatekos.getHetesekSzama() == 0)
            {
                szazalek = 0;
            } else
            {
                szazalek = ((double) jatekos.getErtekesitettHetes() / (double) jatekos.getHetesekSzama()) * 100;
            }

            System.out.print(jatekos.getNev() + jatekos.getMeccsekSzama() +", "+ jatekos.getGolokSzama() +
                    ", " + jatekos.getHetesekSzama() +", " + szazalek + "\n");
        }
    }
*/
    /**
     * A csapatban a következő posztokon játszanak a játékosok: irányító, átlövő, beálló, jobbszélső, balszélső, kapus
     * Írd ki, hogy az adott posztokon játszó játékosok kicsodák, hányan vannak, és összesen mennyi gólt lőttek.
     * A játékosok nevei vesszővel legyenek elválasztva a felsorolásban.
     */
    public void pozicio()
    {
        List<Jatekos> jatekosokLista = beolvas();
        List<Jatekos> jatekosPozicioAlapjanAJatekos = new ArrayList<>();
        int golokSzama = 0;

        for (Poszt jatekosPoz : Poszt.values())
        {
            for (Jatekos jatekos : jatekosokLista)
            {if (jatekosPoz.equals(jatekos.getPoszt()))
                {
                    jatekosPozicioAlapjanAJatekos.add(jatekos);
                }
            }
        }

        for (Poszt jatekospozicio : Poszt.values())
        {
            System.out.print(jatekospozicio + ": ");
            golokSzama = 0;

            for (Jatekos jatekos : jatekosPozicioAlapjanAJatekos)
            {
                if (jatekospozicio.equals(jatekos.getPoszt()))
                {
                    golokSzama += jatekos.getGolokSzama();
                    System.out.print(jatekos.getNev() + ", ");
                }
            }

            System.out.print("golok szama: " + golokSzama);
            System.out.println();
        }
    }


    /**
     * Írd ki, hogy ki a legjobb hetes lövő azok közül, akik legalább 5 hetest dobtak (bedobott hetesek arányának megfelelően)!
     */

    public void legjobbHetesDobo()
    {
        List<Jatekos> jatekosokLista = beolvas();
        Jatekos legjobbanDoboJatekos = null;
        double szazalek = 0;
        double legjobbSzazalek = 0.0d;

        for (Jatekos jatekos : jatekosokLista)
        {
            if (jatekos.getErtekesitettHetes() != 0 && jatekos.getHetesekSzama() != 0 && jatekos.getHetesekSzama() > 4)
            {
                szazalek = ( (double)jatekos.getErtekesitettHetes() / (double) jatekos.getHetesekSzama()) * 100;

                if (szazalek > legjobbSzazalek)
                {
                    legjobbSzazalek = szazalek;
                    legjobbanDoboJatekos = jatekos;
                }
            } else
            {
                szazalek = 0.0d;
            }

        }
        System.out.println(legjobbanDoboJatekos.getNev() + " " + szazalek);
    }

    /*
    Melyik szélsőnek legjobb a gólátlaga?
    Bal vagy jobbszélső dobott több gólt?
    */


    // Melyik irányító játszott a legkevesebbet?

    public void legkevesebbetJatszoIranyito()
    {
        List<Jatekos> jatekosLista = beolvas();
        List<Jatekos> iranyito = jatekosLista.stream()
                .filter(x -> Poszt.IRANYITO.equals(x.getPoszt())).collect(Collectors.toList());

        int legkevesebbMeccs = 100;
        Jatekos legkevesebbetJatszott = null;

        for (Jatekos jatekos : iranyito)
        {
            if(jatekos.getMeccsekSzama() < legkevesebbMeccs)
            {
                legkevesebbMeccs = jatekos.getMeccsekSzama();
                legkevesebbetJatszott = jatekos;
            }
        }
        System.out.print(legkevesebbetJatszott.getNev() + " " + legkevesebbetJatszott.getMeccsekSzama());

    }

    //    Dobott-e jobbszélső hetest?
    public void jobbSzelsoHetestDobottE()
    {
        List<Jatekos> jatekosLista = beolvas();
        List<Jatekos> jobbszelso = jatekosLista.stream()
                .filter(x -> Poszt.JOBBSZELSO.equals(x.getPoszt())).collect(Collectors.toList());

        for (Jatekos jatekos : jobbszelso)
        {
           if(jatekos.getHetesekSzama() > 0)
           {
               System.out.print("dobott");
           }
        }
    }

    //    Ki volt a legeredményesebb átlövő?
    public void legeredmenyesebbAtlovo()
    {
        List<Jatekos> jatekosLista = beolvas();
        List<Jatekos> atlovo = jatekosLista.stream()
                .filter(jatekos -> Poszt.ATLOVO.equals(jatekos.getPoszt())).collect(Collectors.toList());
        Jatekos legeredmenyesebbJatekos = null;
        int legtobbGol = 0;
        for(Jatekos jatekos : atlovo)
        {
            if(jatekos.getGolokSzama() > legtobbGol)
            {
                legtobbGol = jatekos.getGolokSzama();
                legeredmenyesebbJatekos = jatekos;
            }
        }
        System.out.print("legeredmenyesebb atlovo: " + legeredmenyesebbJatekos + ", goljai szama: " +
                legeredmenyesebbJatekos.getGolokSzama());
    }


}