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

//    3. Írd ki, hány gyerek kitűnő az egész évfolyamban!
    public void kitunoTanulokSzama()
    {
        EVFOLYAM_LISTA.stream()
                .filter(tanulo -> "peldas".equals(tanulo.getMagatartas()))
                .filter(tanulo -> "peldas".equals(tanulo.getSzorgalom()))
                .filter(tanulo -> "5".equals(tanulo.getIrodalom()))
                .filter(tanulo -> "5".equals(tanulo.getNyelvtan()))
                .filter(tanulo -> "5".equals(tanulo.getTortenelem()))
                .filter(tanulo -> "5".equals(tanulo.getMatematika()))
                .filter(tanulo -> "5".equals(tanulo.getIrodalom()))
                .filter(tanulo -> "5".equals(tanulo.getAngol()) && "".equals(tanulo.getNemet())
                                || "".equals(tanulo.getAngol()) &&  "5".equals(tanulo.getNemet()))
                .filter(tanulo -> "5".equals(tanulo.getInformatika()))
                .forEach(tanulo -> System.out.println(tanulo.getNev()));
    }

//    5. Írd ki a bukott tanulók neveit névsorban!
    public void bukottTanulok()
    {
        EVFOLYAM_LISTA.stream()
                .filter(tanulo ->
                        "1".equals(tanulo.getIrodalom()) ||
                                "1".equals(tanulo.getNyelvtan()) ||
                                "1".equals(tanulo.getTortenelem()) ||
                                "1".equals(tanulo.getMatematika()) ||
                                "1".equals(tanulo.getAngol()) && "".equals(tanulo.getNemet()) ||
                                "".equals(tanulo.getAngol()) && "1".equals(tanulo.getNemet()) ||
                                "1".equals(tanulo.getInformatika())
                ).forEach(tanulo -> System.out.println(tanulo.getNev()));
    }
}