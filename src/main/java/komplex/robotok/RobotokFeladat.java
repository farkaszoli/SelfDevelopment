package komplex.robotok;

import java.util.List;

//http://www.webotlet.hu/?p=906
public class RobotokFeladat
{
    private static final List<Robot> ROBOTOK_LISTAJA = Beolvas.beolvas();

//    Add meg minden robot útvonalának vég koordinátáit, ha azt feltételezzük, hogy a 0;0 pontból indultak!
    public static void koordinataSzamitas()
    {

    }

// 2. Add meg, hogy melyik robot milyen messze került a kezdőponttól az út végére!

//    3. Melyik robot áll vízszintes irányban a legmesszebb a kezdőpontjától az út végén?
    public static void legmesszebbVizszintesen()
    {
        Robot legmesszebbLevoRobot = new Robot(0,0,0,0,0,0);
        int legmesszebbLevoKoordinata = 0;

        for(Robot robot : ROBOTOK_LISTAJA)
        {
            if(robot.getX() > legmesszebbLevoKoordinata)
            {
                legmesszebbLevoKoordinata = robot.getX();
                legmesszebbLevoRobot = robot;
            }
        }

        System.out.print("legmesszebb levo robot viszintesen: " + legmesszebbLevoRobot.toString());
    }

//    4. Melyik robot jutott útvonala során legmesszebbre a kezdőpontjától?
    public static void legmesszebbjutott()
    {
        Robot legmesszebbLevoRobot = new Robot(0,0,0,0,0,0);

        int legmesszebb = 0;

        for(Robot robot : ROBOTOK_LISTAJA)
        {
            int robotTavolsaga = Math.abs(robot.getX()) + Math.abs(robot.getY());

            if(robotTavolsaga > legmesszebb)
            {
                legmesszebb = robotTavolsaga;
                legmesszebbLevoRobot = robot;
            }
        }

        System.out.print("legtavolabbi robot: " + legmesszebbLevoRobot + ", megtett ut: " + legmesszebb);

    }


}
