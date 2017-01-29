package komplex.robotok;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Beolvas
{
    private static final File FILE
            = new File("E:\\Epam\\repok\\SelfDevelopmentProject\\src\\main\\resources\\utvonalak.txt");

    private static final List<String> robotokIranya = new ArrayList<>();

    // 1. beolvasas
    public static List<String> beolvas()
    {
        try (Scanner scanner = new Scanner(FILE))
        {
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String sor = scanner.nextLine();

                String irany = sor;
                robotokIranya.add(irany);
            }
        } catch (Exception e) {
            System.out.print("Error: " + e.getMessage());
        }
        System.out.print("ok:" + robotokIranya.size());
        return robotokIranya;
    }
}
