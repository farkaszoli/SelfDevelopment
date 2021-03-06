package komplex.kezilabda;

import java.io.File;
import java.util.ArrayList;
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
                double golAtlag = (double) golokSzama / (double) meccsekSzama;
                double sikeresHetesekSzazaleka = getErtekesitettHetesSzazalek(ertekesitettHetes, dobottHetes);


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

    private double getErtekesitettHetesSzazalek(int ertekesitettHetes, int dobottHetes)
    {
        if(dobottHetes != 0 || ertekesitettHetes != 0)
        {
            return ((double) ertekesitettHetes / (double) dobottHetes) * 100;
        }

        return 0.0;
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
     * Hány akciógólt dobott? (nem hetesekből)? ok
     * Hány százalékát dobta be a heteseinek? Ha valaki nem dobott hetest, azt az esetet is oldd meg valahogy! ok
     */

    /**
     * A csapatban a következő posztokon játszanak a játékosok: irányító, átlövő, beálló, jobbszélső, balszélső, kapus
     * Írd ki, hogy az adott posztokon játszó játékosok kicsodák, hányan vannak, és összesen mennyi gólt lőttek.
     * A játékosok nevei vesszővel legyenek elválasztva a felsorolásban.  ok
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
        double legjobbSzazalek = 0.0d;

        for (Jatekos jatekos : jatekosokLista)
        {
            if(jatekos.getHetesekSzama() > 5)
            {
                if (jatekos.getSikeresHetesekSzazaleka() > legjobbSzazalek)
                {
                    legjobbSzazalek = jatekos.getSikeresHetesekSzazaleka();
                    legjobbanDoboJatekos = jatekos;
                }
            }

        }
        System.out.println(legjobbanDoboJatekos.getNev() + " " + legjobbSzazalek);
    }

//    Melyik szélsőnek legjobb a gólátlaga?
    public void legjobbSzelsoGolatlag()
    {
        List<Jatekos> szelsok = getSzelsoJatekosokLista();

        Jatekos legjobbGolatlaguJatekos = null;
        double legjobbGolatlag = 0.0;

        for (Jatekos jatekos : szelsok)
        {
            if(jatekos.getGolAtlag() > legjobbGolatlag)
            {
                legjobbGolatlaguJatekos = jatekos;
                legjobbGolatlag = jatekos.getGolAtlag();
            }
        }

        System.out.print("legjobb golatlagu szelso: " + legjobbGolatlaguJatekos.getNev() );
    }

//    Bal vagy jobbszélső dobott több gólt?
    public void jobbVagyBalszelsoSzerzettTobbGolt()
    {
        List<Jatekos> szelsok = getSzelsoJatekosokLista();

        Jatekos tobbGoltSzerzo = null;
        int legtobbGol = 0;

        for (Jatekos jatekos : szelsok)
        {
            if (jatekos.getGolokSzama() > legtobbGol)
            {
                tobbGoltSzerzo = jatekos;
                legtobbGol = jatekos.getGolokSzama();
            }
        }

        System.out.print("legtobb golt szerzo szelso: " + tobbGoltSzerzo.getNev() + ", posztja: "
                    + tobbGoltSzerzo.getPoszt());
    }

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

    public void legkevesebbetJatszottIranyitoJava8()
    {
        String legkevesebbetJatszo =
            beolvas().stream()
                .filter(jatekos -> Poszt.IRANYITO.equals(jatekos.getPoszt()))
                .filter(jatekos ->
                {
                    int jatszottMeccsekSzama = 0;
                    String neve = "";
                    if(jatekos.getMeccsekSzama() > jatszottMeccsekSzama)
                    {
                        jatszottMeccsekSzama = jatekos.getMeccsekSzama();
                        neve = jatekos.getNev()
                    }
                    return neve;
                });
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

    public void jobbSzelsoHetesJava8()
    {
        beolvas().stream()
                .filter(jatekos -> Poszt.JOBBSZELSO.equals(jatekos.getPoszt()))
                .filter(jatekos -> jatekos.getHetesekSzama() > 0)
                .forEach(jatekos -> System.out.print(jatekos));
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

    public String legeredmenyesebbAtlovoJava8()
    {
        return beolvas().stream()
                .filter(jatekos -> Poszt.ATLOVO.equals(jatekos.getPoszt()))
                .map(jatekos ->
                    {
                        int legtobbGol = 0;
                        String jatekosNeve = "";

                        if(jatekos.getGolokSzama() > legtobbGol)
                        {
                            legtobbGol = jatekos.getGolokSzama();
                            jatekosNeve = jatekos.getNev();
                        }

                        return jatekosNeve;
                    }).toString();
    }

    private List<Jatekos> getSzelsoJatekosokLista()
    {
        List<Jatekos> jatekosLista = beolvas();
        return jatekosLista.stream()
                .filter(x -> Poszt.JOBBSZELSO.equals(x.getPoszt()))
                .filter(y -> Poszt.BALSZELSO.equals(y.getPoszt()))
                .collect(Collectors.toList());
    }
}