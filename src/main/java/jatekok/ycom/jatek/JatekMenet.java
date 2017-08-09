package jatekok.ycom.jatek;

import jatekok.ycom.model.karakter.Karakter;
import org.springframework.stereotype.Component;

@Component
public class JatekMenet
{
    public void jatekosKaraktereinekASzama(Karakter elsoJatekos, Karakter masodikJatekos)
    {
        int elsoJatekosKarakterSzama = 3;
        int masodikJatekosKarakterSzama = 3;

        while(elsoJatekosKarakterSzama > 0 || masodikJatekosKarakterSzama > 0)
        {
            if (elsoJatekos.getEletero() <= 0)
            {
                elsoJatekosKarakterSzama = elsoJatekos.getKarakterekSzama() - 1;
            }

            if(masodikJatekos.getEletero() <= 0)
            {
                masodikJatekosKarakterSzama = masodikJatekos.getKarakterekSzama() - 1;
            }
        }
    }
}
