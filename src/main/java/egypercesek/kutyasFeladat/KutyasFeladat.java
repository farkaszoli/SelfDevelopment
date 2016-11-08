package egypercesek.kutyasFeladat;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class KutyasFeladat
{

    // A feladat tehát adott, töröld ki a vizslák adatait a listából.
    @Test
    public void test()
    {
        List<Kutya> kutyaList = kutyakList();
        List<Kutya> vizslaNelkuli = new ArrayList();

        for(Kutya kutya : kutyaList)
        {
            if("vizsla".equals(kutya.getFajta()))
            {
                vizslaNelkuli.add(kutya);
            }
        }

        for(Kutya dog : vizslaNelkuli)
        {
            System.out.println(dog);
        }
    }

    private List<Kutya> kutyakList()
    {
        List<Kutya> kutyak = new ArrayList();

        kutyak.add( new Kutya("tacsko", 3, "fekete") );
        kutyak.add( new Kutya("vizsla", 6, "arany") );
        kutyak.add( new Kutya("vizsla", 3, "fekete") );
        kutyak.add( new Kutya("labrador", 7, "zsemle") );
        kutyak.add( new Kutya("labrador", 5, "arany") );
        kutyak.add( new Kutya("vizsla", 3, "arany") );
        kutyak.add( new Kutya("labrador", 7, "fekete") );
        kutyak.add( new Kutya("vizsla", 3, "barna") );
        kutyak.add( new Kutya("labrador", 7, "barna") );
        kutyak.add( new Kutya("labrador", 1, "zsemle") );
        kutyak.add( new Kutya("tacsko", 2, "fekete") );

        return kutyak;
    }
}
