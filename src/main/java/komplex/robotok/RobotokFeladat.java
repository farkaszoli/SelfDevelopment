package komplex.robotok;

import java.util.List;
import java.util.stream.Collectors;

//  http://www.webotlet.hu/?p=906
public class RobotokFeladat {
    private static final List<Robot> ROBOTOK_LISTAJA = Beolvas.beolvas();

    //    Add meg minden robot útvonalának vég koordinátáit, ha azt feltételezzük, hogy a 0;0 pontból indultak!
    public static void koordinataSzamitas() {

    }

// 2. Add meg, hogy melyik robot milyen messze került a kezdőponttól az út végére!

    //    3. Melyik robot áll vízszintes irányban a legmesszebb a kezdőpontjától az út végén?
    public static void legmesszebbVizszintesen() {
        Robot legmesszebbLevoRobot = new Robot(0, 0, 0, 0, 0, 0);
        int legmesszebbLevoKoordinata = 0;

        for (Robot robot : ROBOTOK_LISTAJA) {
            if (robot.getX() > legmesszebbLevoKoordinata) {
                legmesszebbLevoKoordinata = robot.getX();
                legmesszebbLevoRobot = robot;
            }
        }

        System.out.print("legmesszebb levo robot viszintesen: " + legmesszebbLevoRobot.toString());
    }

    //    4. Melyik robot jutott útvonala során legmesszebbre a kezdőpontjától?
    public static void legmesszebbjutott()
    {
        Robot legmesszebbLevoRobot = new Robot(0, 0, 0, 0, 0, 0);

        int legmesszebb = 0;

        for (Robot robot : ROBOTOK_LISTAJA) {
            int robotTavolsaga = Math.abs(robot.getX()) + Math.abs(robot.getY());

            if (robotTavolsaga > legmesszebb) {
                legmesszebb = robotTavolsaga;
                legmesszebbLevoRobot = robot;
            }
        }

        System.out.print("legtavolabbi robot: " + legmesszebbLevoRobot + ", megtett ut: " + legmesszebb);

    }

    //  5. Add meg, melyek azok a robotok, melyek túlmentek volna egy 21×21-es tábla határain, melynek
//  a középpontjából indultak!
    public static void tulmentek() {
        List<Robot> hataronBeluliRobotok = ROBOTOK_LISTAJA.stream()
                .filter(robot -> robot.getX() > 21)
                .filter(robot -> robot.getY() > 21)
                .collect(Collectors.toList());

        System.out.print("tulmentek: " + hataronBeluliRobotok);
    }


//  8.  A robot bejárt területének azt a négyszöget nevezzük, melybe befoglalható
//      a robot teljes útvonala. Melyik roboté a legkisebb terület?
    public static void legkisebbTerulet()
    {
        Robot legkisebbTeruletuRobot = new Robot(0, 0, 0, 0, 0, 0);
        int legkisebbTerulet = Integer.MAX_VALUE;
        int terulet;

        for (Robot robot : ROBOTOK_LISTAJA)
        {
            terulet = Math.abs(robot.getX()) * Math.abs(robot.getX());

            if ( terulet > legkisebbTerulet)
            {
                legkisebbTerulet = terulet;
                legkisebbTeruletuRobot = robot;
            }
        }

        System.out.print("legkisebbTeruletu robot: " + legkisebbTeruletuRobot);
    }

    //    9. Melyik roboté a legnagyobb terület?
    public static void legnagyobbTerulet()
    {
        Robot legnagyobbTeruletuRobot = new Robot(0, 0, 0, 0, 0, 0);
        int legnagyobbTerulet = 0;
        int terulet;

        for (Robot robot : ROBOTOK_LISTAJA)
        {
            terulet = Math.abs(robot.getX()) * Math.abs(robot.getX());

            if ( terulet > legnagyobbTerulet)
            {
                legnagyobbTerulet = terulet;
                legnagyobbTeruletuRobot = robot;
            }
        }

        System.out.print("legnagyobbTeruletu robot: " + legnagyobbTeruletuRobot);
    }

    // 10. Van-e olyan robot, melynek útvonala tartalmaz szabályos négyzetet?
    public static void szabalyosNegyzetAMegtettUt()
    {
        List<Robot> szabalyosTeruletuRobotok = ROBOTOK_LISTAJA.stream()
                .filter(robot -> robot.getX() == robot.getY())
                .collect(Collectors.toList());

        System.out.print("szabalyos negyzet teruletu robotok: " + szabalyosTeruletuRobotok);
    }

//  12. Van-e olyan robot, mely sehol nem helyezhető el egy 29×29-es táblán úgy, hogy ne menjen túl a határain?
    public static void hataronTulmegy()
    {
        List<Robot> hataronTul = ROBOTOK_LISTAJA
                .stream()
                .filter(robot -> robot.getX() > 29)
                .filter(robot -> robot.getY() > 29)
                .collect(Collectors.toList());

        System.out.println(hataronTul);
    }

}
