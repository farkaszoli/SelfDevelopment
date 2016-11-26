package egypercesek.kezilabda;

import egypercesek.kombinaltMegszamlalas.HivasIdopont;

import java.io.File;
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
    private List<Jatekos> jatekosokLista = new ArrayList<>();

    public List<Jatekos> beolvas() {
        try (Scanner scanner = new Scanner(FILE)) {
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String sor = scanner.nextLine();
                String[] jatekosAdatok = sor.split(";");

                String jatekosNev = jatekosAdatok[0];
                String poszt = jatekosAdatok[1];
                int dobottHetes = Integer.valueOf(jatekosAdatok[2]);
                int ertekesitettHetes = Integer.valueOf(jatekosAdatok[3]);
                String meccsek = jatekosAdatok[4];

                Jatekos jatekos = new Jatekos(jatekosNev, poszt, dobottHetes, ertekesitettHetes, meccsek, 0, 0, 0, 0.0);
                jatekosokLista.add(jatekos);
            }
        } catch (Exception e) {
            System.out.print("Error: " + e.getMessage());
        }
        return jatekosokLista;
    }

    public void kiir() {
        List<Jatekos> jatekosLista = beolvas();

        for (Jatekos jatekos : jatekosLista) {
            System.out.println(jatekos.getNev());
        }
    }

    /**
     * Minden játékosnál számítsd ki a következő adatokat és tárold el ezeket is:
     * Hány mérkőzésen játszott a bajnokságban?
     * Hány gólt dobott a bajnokságban?
     * Mennyi volt a meccsenkénti gólátlaga?
     * Hány akciógólt dobott? (nem hetesekből)?
     * Hány százalékát dobta be a heteseinek? Ha valaki nem dobott hetest, azt az esetet is oldd meg valahogy!
     */
    public void kiszamol()
    {
        List<Jatekos> jatekosLista = beolvas();

        for (Jatekos jatekos : jatekosLista)
        {
            String[] meccsek = jatekos.getMeccsek().split(",");
            int meccsekSzama = 0;
            int golokSzama = 0;

            for (String meccs : meccsek)
            {
                try {
                    golokSzama += Integer.parseInt(meccs);
                    meccsekSzama++;
                } catch (NumberFormatException ex)
                {
                        System.out.print("Error: " + ex.getMessage());
                }


            }
            jatekos.setMeccsekSzama(meccsekSzama);
            jatekos.setGolokSzama(golokSzama);
            double szazalek = jatekos.getErtekesitettHetes() / jatekos.getHetesekSzama();
            jatekos.setSikeresHetesekSzazaleka(szazalek);
        }
    }

    /**
     * A csapatban a következő posztokon játszanak a játékosok: irányító, átlövő, beálló, jobbszélső, balszélső, kapus
     * Írd ki, hogy az adott posztokon játszó játékosok kicsodák, hányan vannak, és összesen mennyi gólt lőttek.
     * A játékosok nevei vesszővel legyenek elválasztva a felsorolásban.
     */
    public void pozicio()
    {
        List<Jatekos> jatekosLista = beolvas();
        List<Jatekos> posztAlapjan = new ArrayList<>();
        String[] poszt = {"iranyito", "atlovo", "beallo", "jobbszelso", "balszelso", "kapus"};

        for (String pozicio : poszt)
        {
            for (Jatekos jatekos : jatekosLista)
            {
                if (pozicio.contains(jatekos.getPoszt()))
                {
                    posztAlapjan.add(jatekos);
                }
            }
            for (String jatekospozicio : poszt)
            {
                System.out.print(jatekospozicio + ": ");

                for (Jatekos jatekos : posztAlapjan)
                {
                    if (jatekospozicio.equals(jatekos.getPoszt()))
                    {
                        System.out.print(jatekos.getNev());
                    }
                }
                System.out.println();
            }
        }
    }

    /**
     * Írd ki, hogy ki a legjobb hetes lövő azok közül, akik legalább 5 hetest dobtak (bedobott hetesek arányának megfelelően)!
     */

    public void legjobbHetesDobo()
    {
        List<Jatekos> jatekosLista = beolvas();
        Jatekos legjobbanDoboJatekos = new Jatekos("", "", 0, 0, "", 0, 0, 0, 0.0d);
        double szazalek;
        double legjobbSzazalek = 0.0d;

        for (Jatekos jatekos : jatekosLista)
        {
            if (jatekos.getErtekesitettHetes() != 0 && jatekos.getHetesekSzama() != 0 && jatekos.getHetesekSzama() > 4)
            {
                szazalek = (jatekos.getErtekesitettHetes() / jatekos.getHetesekSzama()) * 100;

                if (szazalek > legjobbSzazalek)
                {
                    legjobbSzazalek = szazalek;
                    legjobbanDoboJatekos = jatekos;
                }
            } else
            {
                szazalek = 0.0d;
            }
            System.out.println(legjobbanDoboJatekos.getNev() + " " + szazalek);
        }
    }

    //    Dobott-e jobbszélső hetest?
    public void legkevesebbetJatszott()
    {
        List<Jatekos> jatekosLista = beolvas();
        List<Jatekos> jobbszelso = jatekosLista.stream()
                .filter(x -> "jobbszelso".equals(x.getPoszt())).collect(Collectors.toList());

        for (Jatekos jatekos : jobbszelso)
        {
            String[] meccsek = jatekos.getMeccsek().split(",");
            try
            {
                for (String meccs : meccsek)
                {
                    if(!meccs.contains(""))
                    {
                        int golokSzama = Integer.parseInt(meccs);
                        if (golokSzama >= 0) {
                            System.out.print("dobott");
                            break;
                        }
                    }
                }
            } catch (NumberFormatException ex)
            {
                System.out.print("Error: " + ex.getMessage());
            }

        }
    }

//    Ki volt a legeredményesebb átlövő?
    public void legeredmenyesebbAtlovo()
    {
        List<Jatekos> jatekosLista = beolvas();
        List<Jatekos> jobbszelso = jatekosLista.stream()
                .filter(x -> "atlovo".equals(x.getPoszt())).collect(Collectors.toList());


    }
}

