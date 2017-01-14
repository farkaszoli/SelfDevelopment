package komplex.idojaras;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader
{
    private static final File FILE
            = new File("E:\\Epam\\repok\\SelfDevelopmentProject\\src\\main\\resources\\idojaras.csv");

    private IdojarasFeladat idojarasFeladat = new IdojarasFeladat();
    private static final List<Idojaras> idojarasLista = new ArrayList<>();

    // 1. beolvasas
    public List<Idojaras> beolvas()
    {
        int oraSzam = 0;

        try (Scanner scanner = new Scanner(FILE))
        {
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String sor = scanner.nextLine();
                String[] idojarasFilebol = sor.split(";");

                Idokep idokep = idojarasFeladat.getIdokep(idojarasFilebol[0]);
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
}
