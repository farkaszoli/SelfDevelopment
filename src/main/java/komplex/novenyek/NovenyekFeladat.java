package komplex.novenyek;

import org.testng.annotations.Test;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;

// http://www.webotlet.hu/?p=898
public class NovenyekFeladat
{
    private static final File FILE = new File("E:\\Epam\\repok\\SelfDevelopmentProject\\src\\main\\resources\\novenyek.txt");

    private static List<Noveny> novenyList = new ArrayList();

    public static List<Noveny> beolvas()
    {
        try
        {
            Scanner scanner = new Scanner(FILE);
            while (scanner.hasNextLine())
            {
                Noveny ujNoveny = new Noveny("", "", 0, 0);
                String sor = scanner.nextLine();
                String[] nov = sor.split(";");
                ujNoveny.setNeve(nov[0]);
                ujNoveny.setGyujtik(nov[1]);
                ujNoveny.setKezdikElGyujteni(Integer.parseInt(nov[2]));
                ujNoveny.setFejezikBeGyujteni(Integer.parseInt(nov[3]));
                novenyList.add(ujNoveny);
            }
            scanner.close();
        } catch (Exception e)
        {
            System.out.print("Error: " + e.getMessage());
        }
        return novenyList;
    }

    //  2. Írd ki, hogy a gyöngyvirág melyik részét gyűjtik!
    @Test
    public void gyujtik()
    {
        for (Noveny noveny : novenyList)
        {
            if ("Gyongyvirag".equals(noveny.getNeve()))
            {
                System.out.println(noveny.getGyujtik());
            }
        }
    }
    public void gyujtikWithFilter()
    {
        novenyList.stream().filter(noveny -> "Gyongyvirag".equals(noveny.getGyujtik())).forEach(System.out::print);
    }

    public void gyujtikWithForEach()
    {
        novenyList.stream().forEach(noveny ->
        {
            if ("Gyongyvirag".equals(noveny.getGyujtik()))
            {
                System.out.println(noveny);
            }
        });
    }

    //    3. Írd ki, hány növényt gyűjtenek a leveléért!
    public void szamol()
    {
        int db = 0;
        for (Noveny noveny : novenyList) {
            if ("level".equals(noveny.getGyujtik())) {
                db++;
            }
        }
        System.out.println("gyujtik a leveleert db szama: " + db);
    }

//    4. Írd ki, melyik hónapban kezdik gyűjteni a legtöbb növényt!
    public void kezdikGyujteniALegtobbNovenyt()
    {
        String honapNeve = "";
        long legtobb = 0;
        long szamol = 0;
        int honap;

        for(int i = 1; i < 13; i++)
        {
            honap = i;
            szamol = novenyList.stream().filter(noveny -> honap == noveny.getKezdikElGyujteni()).count();

            if(szamol > legtobb)
            {
                legtobb = szamol;
                honapNeve = String.valueOf(honap);
            }
        }

        System.out.print(honapNeve);
    }

    //    5.Írd ki azokat a hónapokat, amikor semmit nem kezdenek gyűjteni!
    public void semmitNemGyujtenekAHonapban()
    {
        List<Integer> honapok = asList(1,2,3,4,5,6,7,8,9,10,11,12);

        for(Noveny noveny : novenyList)
        {
            for(Integer honap : honapok)
            {
                if(noveny.getKezdikElGyujteni() == honap)
                {
                    honapok.remove(honap);
                }
            }
        }

        System.out.print("ezekben a honapokban nem gyujtenek semmit: " + honapok);
    }

    //6. Hány növény neve áll egy szóból?
    @Test
    public void egyszobol()
    {
        int db = 0;
        String[] nev;

        for (Noveny noveny : novenyList)
        {
            if (noveny.getNeve().split(" ").length > 1)
            {
                db++;
            }
        }

        System.out.println("db szam: " + db);
    }
//    7. Írd ki, hogy melyik növényeket kezdik el ősszel gyűjteni!
    public void osszelKezdikGyujteni()
    {
        novenyList.stream()
                .filter(noveny -> noveny.getKezdikElGyujteni() == 9)
                .filter(noveny -> noveny.getKezdikElGyujteni() == 10)
                .filter(noveny -> noveny.getKezdikElGyujteni() == 11)
                .forEach(System.out::println);
    }

    // 8. Hány növényt gyűjtenek a nyár elejétől kezdődően?
    public void nyarElejetolGyujtik() {
        novenyList.stream()
                .filter(noveny -> noveny.getKezdikElGyujteni() > 6)
                .count();
    }

    // 10. Miket gyűjtenek ugyanazon részéért, mint a csalánt?
    @Test
    public void gyujtikMintACsalant()
    {
        String gyujtik = "";
        for (Noveny noveny : novenyList)
        {
            if("Csalan".equals(noveny.getNeve()))
            {
                gyujtik = noveny.getGyujtik();
            }
        }

        for (Noveny noveny : novenyList)
        {
            if(gyujtik.equals(noveny.getGyujtik()))
            {
                System.out.println(noveny.getNeve());
            }
        }
    }

    // 11. Hány növényt gyűjtenek valamilyen virággal kapcsolatos részéért (virág, virágzat, stb)?
    public void gyujtikViragaMiatt()
    {
        novenyList.stream()
                .filter(noveny -> "virag".equals(noveny.getGyujtik()))
                .filter(noveny -> "viragzat".equals(noveny.getGyujtik()))
                .count();
    }

    //    12. Melyik növényrészeket gyűjtik a legtöbb esetben?
    public void legtobbetGyujtenek()
    {
        List<String> novenyReszek = asList();

        for(Noveny noveny : novenyList)
        {
            if ( !novenyReszek.contains(noveny.getGyujtik()))
            {
                novenyReszek.add(noveny.getGyujtik());
            }
        }

        String legtobbetGyujtotReszNeve = "";
        long szama = 0;
        long legtobb = 0;

        for ( String novenyResz : novenyReszek)
        {
            szama = novenyList.stream().filter(noveny -> novenyResz.equals(noveny.getGyujtik())).count();

            if( szama > legtobb)
            {
                legtobb = szama;
                legtobbetGyujtotReszNeve = novenyResz;
            }
        }

        System.out.print(legtobbetGyujtotReszNeve);
    }


    // 13. Van-e olyan hónap, amikor semmit nem gyűjtenek?
    public void honapMikorNemGyujtenekSemmit()
    {
        List<Integer> honapok = asList(1,2,3,4,5,6,7,8,9,10,11,12);

        for(Noveny noveny : novenyList)
        {
            for(Integer honap : honapok)
            {
                if(noveny.getKezdikElGyujteni() == honap)
                {
                    honapok.remove(honap);
                }
            }
        }
    }

    // 14. Melyik hónapban gyűjtik a legtöbb fajta növényt?
    public static void legtobbNovenytGyujtikAHonapban()
    {
        List<Noveny> novenyLista = beolvas();
        List<String> gyujtott;
        int mennyitGyujtottek = 0;
        String honap = "";

        for(int i = 1; i < 13; i++)
        {
            gyujtott = Collections.emptyList();
            for(Noveny noveny : novenyLista)
            {
                if(noveny.getKezdikElGyujteni() == i)
                {
                    if(!gyujtott.contains(noveny.getNeve()))
                    {
                        gyujtott.add(noveny.getNeve());
                    }
                }
            }

            if(gyujtott.size() > mennyitGyujtottek)
            {
                mennyitGyujtottek = gyujtott.size();
                honap = String.valueOf(i);
            }
        }

        System.out.print("legtobb novenyt ebben a honapban gyujtenek: " + honap);
    }

    //  15. Írd ki a növények adatait olyan sorrendben, hogy mikor kezdik gyűjteni őket!
    public void mikorKezdikGyujteni()
    {
        novenyList.sort((a, b) -> Integer.compare(a.getKezdikElGyujteni(), b.getKezdikElGyujteni()));
        novenyList.stream().forEach(noveny -> System.out.print(noveny));
    }

    //    16. Írd ki, hogy melyik növényt hány hónapig gyűjtenek!
    public void hanyHonapigGyujtik()
    {
        for(Noveny noveny : novenyList)
        {
            int honapokSzama = noveny.getKezdikElGyujteni() + (12 - noveny.getFejezikBeGyujteni());
            System.out.print(noveny + " gyujtik: " +  honapokSzama);
        }
    }
}
