package komplex.novenyek;

import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.asList;

// http://www.webotlet.hu/?p=898
public class NovenyekFeladat
{
    private static final File FILE = new File("E:\\Epam\\repok\\SelfDevelopmentProject\\src\\main\\resources\\novenyek.txt");

    private List<Noveny> novenyList = new ArrayList();

    public List<Noveny> beolvas()
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
    @Test
    public void szamol() {
        int db = 0;
        for (Noveny noveny : novenyList) {
            if ("level".equals(noveny.getGyujtik())) {
                db++;
            }
        }
        System.out.println("gyujtik a leveleert db szama: " + db);
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
}
