package egypercesek.nagykezdobetus;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Egypercesek
{
    /**
     * Alakíts át egy mondatot úgy, hogy minden szó kezdőbetűjét alakítsd nagybetűssé.
     */
    private static final String TEXT = "ez egy mondat lenne, melynek minden szavat nagy kezdobetusse kellene alakitani.";

    @Test
    public void firstCharIsCapital()
    {
        String[] parts = TEXT.split(" ");
        String newString;

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
    @Test
    public void overrideProperty() {
        System.out.print("hello world");
    }
}


