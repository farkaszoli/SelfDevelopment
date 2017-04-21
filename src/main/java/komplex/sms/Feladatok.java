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
}
