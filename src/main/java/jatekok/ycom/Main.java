package jatekok.ycom;

import jatekok.ycom.jatek.JatekMenet;
import jatekok.ycom.model.karakter.Karakter;
import org.springframework.beans.factory.annotation.Autowired;

public class Main
{
    private final JatekMenet jatekMenet;
    private final Karakter jatekos1;
    private final Karakter jatekos2;

    @Autowired
    public Main(JatekMenet jatekMenet, Karakter jatekos1, Karakter jatekos2)
    {
        this.jatekMenet = jatekMenet;
        this.jatekos1 = jatekos1;
        this.jatekos2 = jatekos2;
    }

    public void main(String[] args)
    {
        System.out.println("YCOM game!");

        jatek();
    }

    private void jatek()
    {
        jatekMenet.jatekosKaraktereinekASzama(jatekos1, jatekos2);
    }
}
