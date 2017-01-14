package komplex.evfolyam;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Beolvas
{
    private static final File FILE
            = new File("E:\\Epam\\repok\\SelfDevelopmentProject\\src\\main\\resources\\evfolyam.csv");

    private static List<Tanulo> evfolyamLista = new ArrayList<>();

    // 1. beolvasas
    public List<Tanulo> beolvas()
    {
        try (Scanner scanner = new Scanner(FILE))
        {
            scanner.nextLine();

            while (scanner.hasNextLine())
            {
                String sor = scanner.nextLine();
                String[] evfolyamFilebol = sor.split(";");

                String nev = evfolyamFilebol[0];
                String osztaly = evfolyamFilebol[1];
                String magatartas = evfolyamFilebol[2];
                String szorgalom = evfolyamFilebol[3];
                int irodalom = Integer.valueOf(evfolyamFilebol[4]);
                int nyelvtan = Integer.valueOf(evfolyamFilebol[5]);
                int tortenelem = Integer.valueOf(evfolyamFilebol[6]);
                int matematika = Integer.valueOf(evfolyamFilebol[7]);
                int angol = Integer.valueOf(evfolyamFilebol[8]);
                int nemet = Integer.valueOf(evfolyamFilebol[9]);
                int informatika = Integer.valueOf(evfolyamFilebol[10]);

                Tanulo tanulo = new Tanulo(nev, osztaly, magatartas, szorgalom, irodalom, nyelvtan, tortenelem,
                        matematika, angol, nemet, informatika);
                evfolyamLista.add(tanulo);
            }
        } catch (Exception e)
        {
            System.out.print("Error: " + e.getMessage());
        }
        return evfolyamLista;
    }
}
