package jatekok.shakesandfidgetlite.model.kiegeszito;

import java.util.List;

public class Taska
{
    private List<String> targyak;
    private List<Integer> penz;
    private int taskaMerete = 12;

    public Taska(List<String> targyak, List<Integer> penz)
    {
        this.targyak = targyak;
        this.penz = penz;
    }

    public List<String> getTargyak()
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

    private int taskaMeretBeallitasa(int mekkorara)
    {
        return taskaMerete = 12;
    }
}
