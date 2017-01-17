package komplex.evfolyam;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
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

//    6. Írd ki a 10B osztály tanulmányi átlagát!
    public void tizBTanulmanyiAtlaga()
    {
     List<Tanulo> tizBOsztaly = EVFOLYAM_LISTA.stream()
                .filter(tanulo -> "10B".equals(tanulo.getOsztaly())).collect(Collectors.toList());

        BigDecimal osszeg = BigDecimal.valueOf(0);

        for (Tanulo tanulo : tizBOsztaly)
        {
            osszeg = osszeg.add(tanulo.getAtlag());
        }

        BigDecimal tanulokSzamaAzOsztalyban = BigDecimal.valueOf(tizBOsztaly.size());

        System.out.print("atlag: " + osszeg.divide(tanulokSzamaAzOsztalyban, 3, RoundingMode.CEILING));
    }

//    7. Melyik tantárgyból a legjobb a 10C osztály átlaga?
    public void targybolLegjobbAzAtlagaATizCNek() {
        List<Tanulo> tizBOsztaly = EVFOLYAM_LISTA.stream()
                .filter(tanulo -> "10C".equals(tanulo.getOsztaly())).collect(Collectors.toList());

        int irodalom = 0;

        int nyelvtan = 0;

        int tortenelem = 0;

        int matematika = 0;

        int angol = 0;
        int angol_db = 0;

        int nemet = 0;
        int nemet_db = 0;

        int informatika = 0;

        for (Tanulo tanulo : tizBOsztaly) {
            irodalom += Integer.valueOf(tanulo.getIrodalom());
            nyelvtan += Integer.valueOf(tanulo.getNyelvtan());
            tortenelem += Integer.valueOf(tanulo.getTortenelem());
            matematika += Integer.valueOf(tanulo.getMatematika());

            if (!tanulo.getAngol().isEmpty()) {
                angol += Integer.valueOf(tanulo.getAngol());
                angol_db++;
            } else if (!tanulo.getNemet().isEmpty()) {
                nemet += Integer.valueOf(tanulo.getNemet());
                nemet_db++;
            }

            informatika += Integer.valueOf(tanulo.getInformatika());
        }

        HashMap<String, BigDecimal> atlagok = new HashMap<String, BigDecimal>();
        atlagok.put("irodalom", BigDecimal.valueOf(irodalom).divide(BigDecimal.valueOf(tizBOsztaly.size())));
        atlagok.put("nyelvtan", BigDecimal.valueOf(nyelvtan).divide(BigDecimal.valueOf(tizBOsztaly.size())));
        atlagok.put("tortenelem", BigDecimal.valueOf(tortenelem).divide(BigDecimal.valueOf(tizBOsztaly.size())));
        atlagok.put("matematika", BigDecimal.valueOf(matematika).divide(BigDecimal.valueOf(tizBOsztaly.size())));
        atlagok.put("angol", BigDecimal.valueOf(angol).divide(BigDecimal.valueOf(angol_db)));
        atlagok.put("nemet", BigDecimal.valueOf(nemet).divide(BigDecimal.valueOf(nemet_db)));
        atlagok.put("informatika", BigDecimal.valueOf(informatika).divide(BigDecimal.valueOf(tizBOsztaly.size())));

    }

//    8. Melyik tantárgyból legrosszabb a 10D osztály átlaga?
        public void legrosszabbAtlaguTargyATizDben()
        {
            List<Tanulo> tizDLista = EVFOLYAM_LISTA.stream()
                    .filter(tanulo -> "10D".equals(tanulo.getOsztaly())).collect(Collectors.toList());


        }
}
