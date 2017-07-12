package jatekok.shakesandfidgetlite.model.kaszt;

import jatekok.shakesandfidgetlite.model.faj.FajModel;
import jatekok.shakesandfidgetlite.model.kiegeszito.Taska;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Collections;

@EqualsAndHashCode
@ToString
public class Felderito extends Kaszt
{
    public Felderito(FajModel fajModel)
    {
        super(fajModel, 1, 7, 1, 4);
    }
}
