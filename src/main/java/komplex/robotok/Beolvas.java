package komplex.robotok;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Beolvas
{
    private static final File FILE
            = new File("E:\\Epam\\repok\\SelfDevelopmentProject\\src\\main\\resources\\utvonalak.txt");

    private static final List<Robot> robotokIranya = new ArrayList<>();

    // 1. beolvasas
    public static List<Robot> beolvas()
    {
        try (Scanner scanner = new Scanner(FILE))
        {
            scanner.nextLine();

            int eszak = 0;
            int kelet = 0;
            int del = 0;
            int nyugat = 0;
            int x = 0;
            int y = 0;

            while (scanner.hasNextLine())
            {
                String sor = scanner.nextLine();

                for(char egyirany : sor.toCharArray())
                {
                    if('E' == egyirany)
                    {
                        eszak++;
                    } else if('K' == egyirany)
                    {
                        kelet++;
                    } else if('D' == egyirany)
                    {
                        del++;
                    } else
                    {
                        nyugat++;
                    }
                }

                x = kelet - nyugat;
                y = eszak - del;

             robotokIranya.add(new Robot(eszak, kelet, del, nyugat, x, y));
            }
        } catch (Exception e)
        {
            System.out.print("Error: " + e.getMessage());
        }

        for(Robot robot : robotokIranya)
        {
            System.out.println("robot x, y koordinata: " + robot.getX() + ", " + robot.getY());
        }

        return robotokIranya;
    }
}
