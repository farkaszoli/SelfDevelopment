package egypercesek.egyszerubbFeladatok;

import org.testng.annotations.Test;

import java.util.Arrays;

public class Szoveg
{
    /**
     *  Adott a következő String: “Indul a gorog aludni”
     Írd ki fordítva!
     Írd ki szavanként külön sorba!
     */
    private static final String TASK_WORD = "Indul a gorog aludni";

    @Test
    public void task()
    {
        for(int i = TASK_WORD.length()-1; i >= 0; i--)
        {
            System.out.print(TASK_WORD.charAt(i));
        }

        System.out.println();

        String[] words = TASK_WORD.split(" ");
        for (String word : words)
        {
            System.out.println(word);
        }

        Arrays.stream(words).forEach(word -> System.out.print(word));
    }

    @Test
    public void fordiva()
    {
        System.out.println(new StringBuffer(TASK_WORD).reverse().toString());
    }
}
