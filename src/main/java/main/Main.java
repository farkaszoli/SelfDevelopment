package main;

import egypercesek.egyszerubbFeladatok.Nevek;
import komplex.evfolyam.Beolvas;
import komplex.evfolyam.Evfolyam;
import komplex.idojaras.IdojarasFeladat;
import komplex.novenyek.Noveny;
import komplex.novenyek.NovenyekFeladat;
import komplex.robotok.RobotokFeladat;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Self Development Home project");

//        RobotokFeladat.hataronTulmegy();
//        Nevek nevek = new Nevek();
//        nevek.egymasAlatt();

        NovenyekFeladat.legtobbNovenytGyujtikAHonapban();
    }
}
