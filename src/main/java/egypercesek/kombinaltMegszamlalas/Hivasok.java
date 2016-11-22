package egypercesek.kombinaltMegszamlalas;

import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hivasok
{
    private static final File FILE
            = new File("E:\\Epam\\repok\\SelfDevelopmentProject\\src\\main\\resources\\kombihivasok.csv");
    private List<Telefonhivas> telefonhivasLista = new ArrayList();

    public List<Telefonhivas> fileBeolvasas() {

        try {
            Scanner scanner = new Scanner(FILE);
            while (scanner.hasNextLine()) {
                String elsoSor = scanner.nextLine();
                HivasIdopont telefonHivasKezdete = new HivasIdopont(0, 0, 0);
                Telefonhivas telefonhivas = new Telefonhivas("", telefonHivasKezdete);

                String sor = scanner.nextLine();
                String[] hivasAdatok = sor.split(";");

                telefonhivas.setTelefonszam(hivasAdatok[0]);

                String[] hivasIdopont = hivasAdatok[1].split(":");

                telefonHivasKezdete.setOra(Integer.valueOf(hivasIdopont[0]));
                telefonHivasKezdete.setPerc(Integer.valueOf(hivasIdopont[1]));
                telefonHivasKezdete.setMasodperc(Integer.valueOf(hivasIdopont[2]));

                telefonhivas.setHivasHivasIdopont(telefonHivasKezdete);

                telefonhivasLista.add(telefonhivas);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.print("Error: " + e.getMessage());
        }
        return telefonhivasLista;
    }

//    http://www.webotlet.hu/?p=1461
    @Test
    public void telefonhivasokSzamitasa()
    {
        List<Telefonhivas> hivasLista = fileBeolvasas();
        int csucsidejuHivasDarabSzama = 0;
        int nemcsucsIdejuHivasDarabSzama = 0;
        int mobilHivasDarabSzama = 0;
        int vezetekesHivasDarabSzama = 0;

        for (int i = 0; i <= 23; i++)
        {
            csucsidejuHivasDarabSzama = 0;
            nemcsucsIdejuHivasDarabSzama = 0;
            mobilHivasDarabSzama = 0;
            vezetekesHivasDarabSzama = 0;

            for (Telefonhivas hivas : hivasLista)
            {
                 if (hivas.getHivasHivasIdopont().getOra() == i)
                 {
                    if (i > 7 && i < 18)
                    {
                        csucsidejuHivasDarabSzama++;
                    } else
                    {
                        nemcsucsIdejuHivasDarabSzama++;
                    }

                    String telefonszam = hivas.getTelefonszam();

                    if (telefonszam.startsWith("+3621") || telefonszam.startsWith("+3631")
                            || telefonszam.startsWith("+3671"))
                    {
                        mobilHivasDarabSzama++;
                    } else
                    {
                        vezetekesHivasDarabSzama++;
                    }
                }
            }

            System.out.println(i + ".ora: " + csucsidejuHivasDarabSzama + ", " + nemcsucsIdejuHivasDarabSzama +
                    ", " + mobilHivasDarabSzama + ", " + vezetekesHivasDarabSzama);
        }
    }
}
