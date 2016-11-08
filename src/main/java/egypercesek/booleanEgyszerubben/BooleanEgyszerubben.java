package egypercesek.booleanEgyszerubben;

import org.testng.annotations.Test;

public class BooleanEgyszerubben
{
    /**
     * Adott egy String. Deklaráljunk egy boolean változót, melynek értéke true legyen,
      * ha a String tartalma “1”, és false, ha “0”.
      Itt egy megoldás, amit a Java nyelvvel ismerkedők szoktak megadni:
          String s = "1";
          boolean b;
          if( s.equals("1") )
          {
             b = true;
          }
             else
          {
             b = false;
          }
     */
    private static final String SZOVEG = "1";

    @Test
    public void egyszerubb()
    {
        boolean valtozo = "1".equals(SZOVEG) ? true : false;

        System.out.println("erteke: " + valtozo);
    }

}
