package egypercesek.kezilabda;

import egypercesek.kombinaltMegszamlalas.HivasIdopont;
import javafx.geometry.Pos;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//  http://www.webotlet.hu/?p=1129
public class Kezilabda {
    private static final File FILE
            = new File("E:\\Epam\\repok\\SelfDevelopmentProject\\src\\main\\resources\\kezilabda.csv");
    private List<Jatekos> jatekosokLista = new ArrayList<>();

    public List<Jatekos> beolvas()
    {
        try (Scanner scanner = new Scanner(FILE)) {
            scanner.nextLine();
            boolean elsoSor = scanner.hasNextLine();

            while (scanner.hasNextLine()) {
                String sor = scanner.nextLine();
                String[] jatekosAdatok = sor.split(";");

                String jatekosNev = jatekosAdatok[0];
                Poszt poszt = getPozicio(jatekosAdatok[1]);
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

    private Poszt getPozicio(String jatekosPozicio) {
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

    public void kiir() {
        List<Jatekos> jatekosLista = beolvas();

        for (Jatekos jatekos : jatekosLista) {
            System.out.println(jatekos.getNev() + ", " + jatekos.getPoszt());
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
        double szazalek;

        for (Jatekos jatekos : jatekosLista)
        {
            String[] osszesMeccsLista = jatekos.getMeccsek().split(",");
            int meccsekSzama = 0;
            int golokSzama = 0;

            for (String adottMeccs : osszesMeccsLista) {
                try
                {
                    if(!"".equals(adottMeccs))
                    {
                        golokSzama += Integer.parseInt(adottMeccs);
                        meccsekSzama++;
                    }
                } catch (NumberFormatException ex) {
                    System.out.print("Error: " + ex.getMessage());
                }

                jatekos.setMeccsekSzama(meccsekSzama);
                jatekos.setGolokSzama(golokSzama);
            }

            if (jatekos.getHetesekSzama() == 0)
            {
                szazalek = 0;
            } else
            {
                szazalek = ((double) jatekos.getErtekesitettHetes() / (double) jatekos.getHetesekSzama()) * 100;
            }

            jatekos.setSikeresHetesekSzazaleka(szazalek);

            System.out.print(jatekos.getNev() + jatekos.getMeccsekSzama() +", "+ jatekos.getGolokSzama() +
                    ", " + jatekos.getHetesekSzama() +", " + szazalek + "\n");
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
        kiszamol();
        List<Jatekos> jatekosPozicioAlapjanAJatekos = new ArrayList<>();
        int golokSzama = 0;

        for (Poszt jatekosPoz : Poszt.values())
        {
            for (Jatekos jatekos : jatekosLista)
            {
                if (jatekosPoz.equals(jatekos.getPoszt()))
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
        List<Jatekos> jatekosLista = beolvas();
        kiszamol();
        Jatekos legjobbanDoboJatekos = null;
        double szazalek = 0;
        double legjobbSzazalek = 0.0d;

        for (Jatekos jatekos : jatekosLista)
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

    //    Dobott-e jobbszélső hetest?
    public void legkevesebbetJatszott() {
        List<Jatekos> jatekosLista = beolvas();
        List<Jatekos> jobbszelso = jatekosLista.stream()
                .filter(x -> "jobbszelso".equals(x.getPoszt())).collect(Collectors.toList());

        for (Jatekos jatekos : jobbszelso) {
            String[] meccsek = jatekos.getMeccsek().split(",");
            try {
                for (String meccs : meccsek) {
                    if (!meccs.contains("")) {
                        int golokSzama = Integer.parseInt(meccs);
                        if (golokSzama >= 0) {
                            System.out.print("dobott");
                            break;
                        }
                    }
                }
            } catch (NumberFormatException ex) {
                System.out.print("Error: " + ex.getMessage());
            }
        }
    }

    //    Ki volt a legeredményesebb átlövő?
    public void legeredmenyesebbAtlovo() {
        List<Jatekos> jatekosLista = beolvas();
        List<Jatekos> jobbszelso = jatekosLista.stream()
                .filter(x -> "atlovo".equals(x.getPoszt())).collect(Collectors.toList());


    }
}

