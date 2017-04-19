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

                smsek.add(new Sms());
            }
        } catch (Exception e)
        {
            System.out.print("Error: " + e.getMessage());
        }

        return smsek;
    }
}
