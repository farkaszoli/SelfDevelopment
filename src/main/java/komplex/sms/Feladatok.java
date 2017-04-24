package komplex.sms;

import com.google.common.base.Strings;
import com.sun.deploy.util.StringUtils;
import komplex.evfolyam.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Feladatok
{
    /*
    1. Olvassa be az sms.txt állományban talált adatokat, s annak felhasználásával oldja meg a következő feladatokat!
    Ha az állományt nem tudja beolvasni, akkor a benne található adatok közül az első tíz üzenet adatait jegyezze be a
     programba, s úgy oldja meg a feladatokat!
     */
    private static final List<Sms> SMSEK = Beolvas.beolvas();

    public void elsoFeladat()
    {
        Beolvas.beolvas();
    }

    /*
    2. A fájlban tárolt utolsó üzenet érkezésekor melyik üzenet a legfrissebb a telefon memóriájában?
     Írja az üzenet szövegét a képernyőre!
     */
    public static void masodikFeladat()
    {
        int legfrissebb = 0;
        int legfrisebbPerc = 0;
        String uzenet = "";

        for(Sms sms : SMSEK)
        {
            if(sms.getOra() >= legfrissebb)
            {
                legfrissebb = sms.getOra();

                if( sms.getPerc() > legfrisebbPerc)
                {
                    legfrisebbPerc = sms.getPerc();
                }
                uzenet = sms.getUzenet();
            }
        }

        System.out.print(uzenet);
    }

    /*
    3. Adja meg a leghosszabb és a legrövidebb üzenetek adatait! Ha több azonos hosszúságú üzenet van,
    akkor elegendő csak egyet-egyet megadnia! A képernyőn óra, perc, telefonszám, üzenet formában jelenítse meg
    az adatokat!
     */
    public static void harmadikFeladat()
    {
        Sms leghosszabbSms = SMSEK.get(0);
        Sms legrovidebbSms = SMSEK.get(0);

        for(Sms sms : SMSEK)
        {
            if(sms.getUzenet().length() > leghosszabbSms.getUzenet().length())
            {
                leghosszabbSms = sms;
            }

            if(sms.getUzenet().length() < legrovidebbSms.getUzenet().length())
            {
                legrovidebbSms = sms;
            }
        }

        System.out.println("leghoszabb uzenet adatai: " + leghosszabbSms.toString());
        System.out.println("legrovidebb uzenet adatai: " + legrovidebbSms.toString());
    }

    /*
    4. Készítsen karakterhossz szerinti statisztikát: 1-20, 21-40, 41-60, 61-80, 81-100!
    Az intervallumok mellé a hozzájuk tartozó üzenetek darabszámát írja, mint eredményt a képernyőre!
     */
    public static void negyedikFeladat()
    {
        int smsHossza;
        int huszig = 0;
        int negyvenig = 0;
        int hatvanig = 0;
        int nyolcvanig = 0;
        int szazig = 0;

        for(Sms sms : SMSEK)
        {
            smsHossza = sms.getUzenet().length();
            if(smsHossza > 0 && smsHossza < 21)
            {
                huszig++;
            }
            else if(smsHossza > 20 && smsHossza < 41)
            {
                negyvenig++;
            }else if(smsHossza > 40 && smsHossza < 61)
            {
                hatvanig++;
            } else if(smsHossza > 60 && smsHossza < 81)
            {
                nyolcvanig++;
            }else if(smsHossza > 80 && smsHossza < 101)
            {
                szazig++;
            }
        }

        System.out.println("1-20: " + huszig + " db");
        System.out.println("21-40: " + negyvenig + " db");
        System.out.println("41-60: " + hatvanig + " db");
        System.out.println("61-80: " + nyolcvanig + " db");
        System.out.println("81-1000: " + szazig + " db");
    }

    /*
    5. Ha Ernő minden óra 0. percében elolvasná a memóriában lévő üzeneteket (az éppen ekkor érkező üzeneteket nem
    látja), majd ki is törölné, akkor hány olyan üzenet lenne, amelynek elolvasásához fel kellene hívnia a szolgáltatót?
    Írja ezt a számot a képernyőre! (Az üzeneteket először 1, utoljára 24 órakor olvassa el.)
    */
    public static void otodikFeladat()
    {
    List<Integer> ezekbenAzOrakbanErkezettUzenet = new ArrayList<>();

        for(Sms sms : SMSEK)
        {
            if(!ezekbenAzOrakbanErkezettUzenet.contains(sms.getOra()))
            {
                ezekbenAzOrakbanErkezettUzenet.add(sms.getOra());
            }
        }

        int db = 0;
        int osszesDb = 0;

        for (int ora : ezekbenAzOrakbanErkezettUzenet)
        {
            for (Sms sms : SMSEK)
            {
                if (ora == sms.getOra())
                {
                    db++;
                }
            }

            if(db > 10)
            {
                osszesDb += db - 10;
            }

            db = 0;
        }

        System.out.print("ennyi uzenet miatt kell hivni: " + osszesDb);
    }

    /*
    6. Ernő barátnője gyakran küld sms-t az 123456789-es számról. Mennyi volt a leghosszabb idő, amennyi eltelt két
    üzenete között? Ha legfeljebb 1 üzenet érkezett tőle, akkor írja ki, hogy „nincs elegendő üzenet”, egyébként pedig
    adja meg a leghosszabb időtartamot óra perc alakban!
    */
    public static void hatodikFeladat()
    {
        List<Sms> baratnoiSmsek = SMSEK.stream().filter(sms -> sms.getTelefonszam() == 123456789).collect(Collectors.toList());

        if( baratnoiSmsek.size() < 2)
        {
            System.out.print("nincs elegendo uzenet");
            return;
        }

        int legnagyobbKulonbseg = 0;

        for(int i = 0; i < baratnoiSmsek.size() - 1; i++)
        {
            int elsoIdopontOraja = baratnoiSmsek.get(i).getOra() * 60;
            int elsoIdopontjaPerc = baratnoiSmsek.get(i).getPerc();

            int elsoOraPercben = elsoIdopontOraja + elsoIdopontjaPerc;

            int masodikIdopontOraja = baratnoiSmsek.get(i + 1).getOra() * 60;
            int masodikIdopontPerc = baratnoiSmsek.get(i + 1).getPerc();

            int masodikOraPercben = masodikIdopontOraja + masodikIdopontPerc;

            int kulonbseg = masodikOraPercben - elsoOraPercben;

            if ( kulonbseg > legnagyobbKulonbseg)
            {
                legnagyobbKulonbseg = kulonbseg;
            }
        }

        int ora = legnagyobbKulonbseg / 60;
        int perc = legnagyobbKulonbseg % 60;

        System.out.println(ora + " ora"  + perc  + " perc");
    }

    /*
    7. Egy üzenet véletlenül késett. Olvassa be a billentyűzetről ennek az sms-nek az adatait, majd tárolja el a
    memóriában a többihez hasonlóan!
    */

    /*
    8. Az smski.txt állományban készítsen egy listát az üzenetekről telefonszám szerinti csoportosításban, telefonszám
    szerint növekvő sorrendben! Egy csoporthoz tartozó első sorban a feladó telefonszáma szerepeljen! Az alatta lévő
    sorokban a feladás ideje, majd a tőle újabb szóközzel elválasztva az üzenet szövege szerepeljen!
     */
}
