package komplex.novenyek;

import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// http://www.webotlet.hu/?p=898
public class NovenyekFeladat {
    private static final File FILE = new File("E:\\Epam\\repok\\SelfDevelopmentProject\\src\\main\\resources\\novenyek.txt");

    private List<Noveny> novenyList = new ArrayList();

    public List<Noveny> beolvas() {
        try {
            Scanner scanner = new Scanner(FILE);
            while (scanner.hasNextLine()) {
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
        } catch (Exception e) {
            System.out.print("Error: " + e.getMessage());
        }
        return novenyList;
    }

    //    Írd ki, hogy a gyöngyvirág melyik részét gyűjtik!
    @Test
    public void gyujtik() {
        for (Noveny noveny : novenyList) {
            if ("Gyongyvirag".equals(noveny.getNeve())) {
                System.out.println(noveny.getGyujtik());
            }
        }
    }

    //    Írd ki, hány növényt gyűjtenek a leveléért!
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

    //Hány növény neve áll egy szóból?
    @Test
    public void egyszobol() {
        int db = 0;
        String[] nev;

        for (Noveny noveny : novenyList) {
            if (noveny.getNeve().split(" ").length > 1) {
                db++;
            }

        }

        System.out.println("db szam: " + db);
    }

    //Miket gyűjtenek ugyanazon részéért, mint a csalánt?
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
}
