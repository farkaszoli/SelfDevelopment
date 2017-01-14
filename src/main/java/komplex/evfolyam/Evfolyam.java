package komplex.evfolyam;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//http://www.webotlet.hu/?p=921
public class Evfolyam
{
    private static Beolvas beolvas = new Beolvas();

    private static final List<Tanulo> EVFOLYAM_LISTA = beolvas.beolvas();

    public void kiir()
    {
        for(Tanulo tanulo : EVFOLYAM_LISTA)
        {
            System.out.println(tanulo);
        }
    }

//   1. Írd ki a 10A osztályos tanulók neveit névsorban a képernyőre!
    public void kiirTizAOsztalyTanuloit()
    {
        EVFOLYAM_LISTA.stream()
                .filter(tanulo -> "10A".equals(tanulo.getOsztaly()))
                .sorted(Comparator.comparing(Tanulo::getNev))
                .forEach(tanulo -> System.out.println(tanulo.getNev()));
    }

}
