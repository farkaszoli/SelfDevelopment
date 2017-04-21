package komplex.sms;

import com.google.common.base.Strings;
import com.sun.deploy.util.StringUtils;
import komplex.evfolyam.*;

import java.util.List;

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
        Sms leghosszabbSms = new Sms(0, 0, 0, "");
        Sms legrovidebbSms = new Sms(0, 0, 0, Strings.repeat("z", 1000));

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
}
