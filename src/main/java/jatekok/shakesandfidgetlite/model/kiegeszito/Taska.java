package jatekok.shakesandfidgetlite.model.kiegeszito;

import java.util.List;

public class Taska
{
    private List<String> targyak;
    private List<Integer> penz;

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
}
