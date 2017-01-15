package komplex.evfolyam;

import java.io.File;
import java.math.BigDecimal;
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
                BigDecimal atlag = atlagSzamitas(irodalom, nyelvtan, tortenelem, matematika, angol, nemet, informatika);

                Tanulo tanulo = new Tanulo(nev, osztaly, magatartas, szorgalom, irodalom, nyelvtan, tortenelem,
                        matematika, angol, nemet, informatika, atlag);
                evfolyamLista.add(tanulo);
            }
        } catch (Exception e)
        {
            System.out.print("Error: " + e.getMessage());
        }
        return evfolyamLista;
    }

    private BigDecimal atlagSzamitas(String irodalom, String nyelvtan, String tortenelem, String matematika,
         String angol, String nemet, String informatika)
    {
        int jegyekOsszege = (Integer.valueOf(irodalom) + Integer.valueOf(nyelvtan) + Integer.valueOf(tortenelem)
                + Integer.valueOf(matematika) + idegenNyelvJegy(angol, nemet) + Integer.valueOf(informatika));
        return BigDecimal.valueOf( jegyekOsszege / 6);
    }

    private Integer idegenNyelvJegy(String angol, String nemet)
    {
        if(!angol.isEmpty())
        {
            return getJegy(angol);
        } else
        {
            return getJegy(nemet);
        }
    }

    private Integer getJegy(String tantargy)
    {
        if("1".equals(tantargy))
        {
            return Integer.valueOf(1);
        }
        else if("2".equals(tantargy))
        {
            return Integer.valueOf(2);
        }
        else if("3".equals(tantargy))
        {
            return Integer.valueOf(3);
        }
        else if("4".equals(tantargy))
        {
            return Integer.valueOf(4);
        }
        else
        {
            return Integer.valueOf(5);
        }
    }
}
