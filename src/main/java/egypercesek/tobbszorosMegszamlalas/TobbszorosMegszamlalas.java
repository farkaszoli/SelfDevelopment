package egypercesek.tobbszorosMegszamlalas;

import org.testng.annotations.Test;

import java.util.*;

// http://www.webotlet.hu/?p=1135
public class TobbszorosMegszamlalas
{
    private static final int[] TOMB = { 2,5,4,0,10,1,4,8,5,2,8,1,9,10,
            7,7,3,5,2,4,3,8,0,8,10,8,1,1,8,
            10,7,7,3,8,3,6,6,7,5,8,9,3,9,3,
            5,9,9,5,2,8,10,4,1,0,4,9,2,5,5 };


    // Írd ki, hogy melyik szám hányszor szerepel a tömbben!
    @Test
    public void szamol()
    {
        int szamol = 0;

        HashMap<Integer, Integer> test = new HashMap();
        for(int i = 0; i < 11; i++)
        {
            for(int j = 0; j < TOMB.length; j++) {
                if (i == TOMB[j]) {
                    szamol++;
                }
            }
            test.put(i, szamol);
            szamol = 0;
        }

        Set set = test.entrySet();
        Iterator iterator = set.iterator();

        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            System.out.println("szam: " + mentry.getKey() + " ennyit tartalmaz: " + mentry.getValue() + " db");
        }
    }

}
