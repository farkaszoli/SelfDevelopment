package egypercesek.egyszerubbFeladatok;


import org.testng.annotations.Test;

import java.util.Scanner;

public class Nevek
{
    private String name = "proba test";
    private String[] splitName = name.split(" ");

    //  Kérd be a nevedet (csak egy keresztnévvel) és tárold el.
    public String inputName()
    {
        String name;

        Scanner inputReader = new Scanner(System.in);

        System.out.println("please write your name: " );
        name = inputReader.nextLine();
        System.out.println("Your name:" + name);

        return name;
    }

    // Írd ki csupa nagybetűvel!
    @Test
    public void upperCaseName() {
        System.out.println("nagybetuvel a nev: " + name.toUpperCase());
    }

    // Írd ki betűnként egymás alá!
    @Test
    public void egymasAlatt()
    {
        for (int i = 0; i < name.length(); i++) {
            System.out.println(name.charAt(i));
        }
    }

    // Írd ki, található-e benne ’a’ betű!
    @Test
    public void containsA()
    {
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == 'a') {
                System.out.println("tartalmaz 'a' betut a nev");
                break;
            }

        }
    }


    //    Írd ki csak a vezetékneved!
    @Test
    public void vezeteknev()
    {
        System.out.println("vezeteknev: " + splitName[0]);
    }

    //    Írd ki csak a keresztneved!
    @Test
    public void keresztnev()
    {
        System.out.println("keresztnev: " + splitName[1]);
    }

    // Írd ki a képernyőre úgy, hogy a vezeték és keresztneved külön sorban legyen!
    @Test
    public void kulonsorban()
    {
        System.out.println(splitName[0]);
        System.out.println(splitName[1]);
    }

    //    Írd ki, hány karakterből áll a vezetékneved!
    //    Írd ki, hány karakterből áll a keresztneved!
    @Test
    public void nevhossza()
    {
        System.out.println("vezeteknev hossza: " + splitName[0].length());
        System.out.println("keresztnev hossza: " + splitName[1].length());
    }
}