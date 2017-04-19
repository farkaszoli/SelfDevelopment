package komplex.sms;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Beolvas
{
    private static final File FILE
            = new File("E:\\Epam\\repok\\SelfDevelopmentProject\\src\\main\\resources\\sms.txt");

    private static final List<Sms> smsek = new ArrayList<>();

    // 1. beolvasas
    public static List<Sms> beolvas()
    {
        try (Scanner scanner = new Scanner(FILE))
        {
            scanner.nextLine();

            while (scanner.hasNextLine())
            {
                String sor = scanner.nextLine();

                String[] felbontas = sor.split(";");
                String elsoResz = felbontas[0];

                String masodikResz[] = elsoResz.split(" ");

                int ora = Integer.valueOf(masodikResz[0]);
                int perc = Integer.valueOf(masodikResz[1]);
                int telefonszam = Integer.valueOf(masodikResz[2]);

                String uzenet = felbontas[1];

                smsek.add(new Sms(ora, perc, telefonszam, uzenet));
            }
        } catch (Exception e)
        {
            System.out.print("Error: " + e.getMessage());
        }

//        smsek.stream().forEach(sms -> System.out.println(sms));

        return smsek;
    }
}
