package jatekok.shakesandfidgetlite.model.kaszt;

import jatekok.shakesandfidgetlite.model.faj.FajModel;
import jatekok.shakesandfidgetlite.model.kiegeszito.Taska;

import java.util.Collections;

public class Felderito extends Kaszt
{
    public Felderito(FajModel fajModel)
    {
        super(fajModel, 1, 7, 1, 4, 0, new Taska(Collections.emptyList(), Collections.emptyList()), 0, 0);
    }
}
