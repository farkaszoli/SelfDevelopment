package jatekok.shakesandfidgetlite.model.kiegeszito;

import jatekok.shakesandfidgetlite.model.targy.Targy;

import java.util.List;

public class Taska
{
    private List<Targy> targyak;
    private List<Integer> penz;
    private int taskaMerete = 12;

    public Taska(List<Targy> targyak, List<Integer> penz)
    {
        this.targyak = targyak;
        this.penz = penz;
    }

    public List<Targy> getTargyak()
    {
        return targyak;
    }

    public List<Integer> getPenz()
    {
        return penz;
    }

    public int getTaskaMerete()
    {
        return targyak.size();
    }

    public int getTaskaJelenlegiMerete()
    {
        return taskaMerete;
    }

    private int taskaMeretenekNovelese(int bovitesMerete)
    {
        return taskaMerete += bovitesMerete;
    }
}
