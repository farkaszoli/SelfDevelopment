package komplex.novenyek;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NovenyekValogatasa
{
    private NovenyekFeladat novenyekFeladat = new NovenyekFeladat();
    private List<Noveny> novenyLista = novenyekFeladat.beolvas();

    private List<String> gyujtikLista = new ArrayList();

    public List<String> valogat()
    {
        for(Noveny noveny : novenyLista)
        {
            if(!gyujtikLista.contains(noveny.getGyujtik()))
            {
                gyujtikLista.add(noveny.getGyujtik());
            }
        }
        gyujtikLista = gyujtikLista.stream().sorted().collect(Collectors.toList());

        return gyujtikLista;
    }

    //    A feladat az, hogy válogasd szét a növényeket aszerint, hogy melyiket milyen részéért gyűjtik.
    //    A gyűjtendő részek abc rendben kövessék egymást, a hozzá tartozó növények sorrendje lényegtelen.
    @Test
    public void kiir()
    {
        for(String gyujtik : gyujtikLista)
        {
            System.out.println(gyujtik + ": ");
            for(Noveny noveny : novenyLista)
            {
                if(gyujtik.equals(noveny.getGyujtik()))
                {
                    System.out.println(noveny.getNeve() + "," +  noveny.getGyujtik() + "," +
                            noveny.getKezdikElGyujteni() + "," + noveny.getFejezikBeGyujteni());
                }
            }
        }
    }
}
