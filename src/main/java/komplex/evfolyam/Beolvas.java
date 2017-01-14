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
                String irodalom = evfolyamFilebol[4];
                String nyelvtan = evfolyamFilebol[5];
                String tortenelem = evfolyamFilebol[6];
                String matematika = evfolyamFilebol[7];
                String angol = evfolyamFilebol[8];
                String nemet = evfolyamFilebol[9];
                String informatika = evfolyamFilebol[10];

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
