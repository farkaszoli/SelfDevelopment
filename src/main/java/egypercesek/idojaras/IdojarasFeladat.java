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

    public List<Idojaras> beolvas()
    {
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

                Idojaras idojaras = new Idojaras(idokep, homerseklet, szelirany, szelerosseg, legnyomas, paratartalom);
                idojarasLista.add(idojaras);
            }
        } catch (Exception e) {
            System.out.print("Error: " + e.getMessage());
        }
        System.out.print("ok: " + idojarasLista.size());
        return idojarasLista;
    }

}
