package komplex.robotok;

import java.util.List;

//http://www.webotlet.hu/?p=906
public class RobotokFeladat
{
    private static final List<String> ROBOT_IRANY_LISTA = Beolvas.beolvas();

//    Add meg minden robot útvonalának vég koordinátáit, ha azt feltételezzük, hogy a 0;0 pontból indultak!
    public static void koordinataSzamitas()
    {
        int eszak = 0;
        int kelet = 0;
        int del = 0;
        int nyugat = 0;

        int x = 0;
        int y = 0;

        for(String irany : ROBOT_IRANY_LISTA)
        {
          if("E".equals(irany))
          {
              eszak++;
          } else if("K".equals(irany))
          {
              kelet++;
          } else if("D".equals(irany))
          {
              del++;
          } else
          {
              nyugat++;
          }
        }

        x = kelet - nyugat;
        y = eszak - del;

        System.out.print("koordinatak: " + x +", " + y);
    }
}
