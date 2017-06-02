package jatekok.shakesandfidgetlite.model.kaszt;

import jatekok.shakesandfidgetlite.model.faj.FajModel;
import jatekok.shakesandfidgetlite.model.kiegeszito.Taska;

import java.util.Collections;

public class Magus extends Kaszt
{
    public Magus(FajModel fajModel)
    {
        super(fajModel, 0, 0, 8, 2, 0, new Taska(Collections.emptyList(), Collections.emptyList()), 0, 0);
    }
}
