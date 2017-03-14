package egypercesek.nagykezdobetus;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.AssertJUnit.assertEquals;

public class Egypercesek
{
    /**
     * Alakíts át egy mondatot úgy, hogy minden szó kezdőbetűjét alakítsd nagybetűssé.
     */
    private static final String TEXT = "ez egy mondat lenne, melynek minden szavat nagy kezdobetusse kellene alakitani.";
    private String[] parts = TEXT.split(" ");
    private String newString;

    @Test
    public void firstCharIsCapital()
    {
        for (String word : parts)
        {
            if (word.length() == 1)
            {
                newString = word.toUpperCase();
            } else
            {
                newString = Character.toUpperCase(word.charAt(0)) + word.substring(1);
            }
            System.out.print(newString + " ");
        }
    }

    public void firstCharIsCapitalWithJava8()
    {
        Arrays.stream(parts)
                .filter(word -> word.length() == 1)
                .map(word -> newString = word.toUpperCase())
                .forEach(word -> System.out.print(word));
    }

    @Test
    public void overrideProperty() {
        System.out.print("hello world");
    }
}


