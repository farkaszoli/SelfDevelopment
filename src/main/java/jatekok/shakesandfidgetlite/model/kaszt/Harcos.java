package jatekok.shakesandfidgetlite.model.kaszt;

import jatekok.shakesandfidgetlite.model.faj.FajModel;
import jatekok.shakesandfidgetlite.model.kiegeszito.Taska;

import java.util.Collections;

public class Harcos extends Kaszt
{
    public Harcos(FajModel fajModel)
    {
        super(fajModel, 7, 3, 0, 5,0, new Taska(Collections.emptyList(), Collections.emptyList()), 0, 0);
    }
}
