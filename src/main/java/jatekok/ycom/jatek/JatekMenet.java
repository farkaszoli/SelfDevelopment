package jatekok.ycom.jatek;

import jatekok.ycom.model.karakter.Karakter;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class JatekMenet
{
    // false = elsojatekos
    private boolean kijon = false;

    public void jatekosKaraktereinekASzama(Karakter elsoJatekos, Karakter masodikJatekos)
    {
        while(elsoJatekos.getKarakterekSzama() > 0 || masodikJatekos.getKarakterekSzama() > 0)
        {
            if (kijon)
            {
                elsoJatekos.setEletero(elsoJatekos.getEletero() - sebzes());

                if (elsoJatekos.getEletero() <= 0)
                {
                    elsoJatekos.setKarakterekSzama(elsoJatekos.getKarakterekSzama() - 1);
                }
            } else
            {
                masodikJatekos.setEletero(masodikJatekos.getEletero() - sebzes());
                
                if (masodikJatekos.getEletero() <= 0)
                {
                    masodikJatekos.setKarakterekSzama(masodikJatekos.getKarakterekSzama() - 1);
                }
            }

            jatekosCsere(kijon);
        }
    }

    private int sebzes()
    {
        Random r = new Random();
        return r.nextInt(35) + 30;
    }

    private boolean jatekosCsere(boolean kiJon)
    {
        return kiJon == true ? false : true;
    }
}
