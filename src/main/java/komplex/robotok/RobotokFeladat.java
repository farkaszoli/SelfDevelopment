package komplex.robotok;

import java.util.List;
import java.util.stream.Collectors;

//  http://www.webotlet.hu/?p=906
public class RobotokFeladat
{
    private static final List<Robot> ROBOTOK_LISTAJA = Beolvas.beolvas();

    Robot legnagyobbTeruletuRobot = new Robot(0, 0, 0, 0, 0, 0);
    Robot legmesszebbLevoRobot = new Robot(0, 0, 0, 0, 0, 0);
    Robot legkisebbTeruletuRobot = new Robot(0, 0, 0, 0, 0, 0);
    Robot legmesszebbLevoRobotXkoordinatan = new Robot(0, 0, 0, 0, 0, 0);

    int legnagyobbTerulet = 0;
    int terulet = 0;
    int legmesszebb = 0;
    int legmesszebbLevoKoordinata = 0;
    int legkisebbTerulet = Integer.MAX_VALUE;

    //    Add meg minden robot útvonalának vég koordinátáit, ha azt feltételezzük, hogy a 0;0 pontból indultak!
    public static void koordinataSzamitas()
    {
    }

    // 2. Add meg, hogy melyik robot milyen messze került a kezdőponttól az út végére!

    //    3. Melyik robot áll vízszintes irányban a legmesszebb a kezdőpontjától az út végén?
    public void legmesszebbVizszintesen()
    {
        for (Robot robot : ROBOTOK_LISTAJA)
        {
            if (robot.getX() > legmesszebbLevoKoordinata)
            {
                legmesszebbLevoKoordinata = robot.getX();
                legmesszebbLevoRobotXkoordinatan = robot;
            }
        }

        System.out.print("legmesszebb levo robot viszintesen: " + legmesszebbLevoRobotXkoordinatan.toString());
    }

    public void legmesszebbVizszintesenJava8()
    {
        System.out.print(ROBOTOK_LISTAJA.stream().map(this::legmesszebbXKoordinatan).findFirst());
    }

    private Robot legmesszebbXKoordinatan(Robot robot)
    {
        if(robot.getX() > legmesszebb)
        {
            legmesszebbLevoRobotXkoordinatan  = robot;
            legmesszebb = robot.getX();
        }

        return legmesszebbLevoRobotXkoordinatan;
    }

    //    4. Melyik robot jutott útvonala során legmesszebbre a kezdőpontjától?
    public void legmesszebbjutott()
    {
        for (Robot robot : ROBOTOK_LISTAJA)
        {
            int robotTavolsaga = Math.abs(robot.getX()) + Math.abs(robot.getY());

            if (robotTavolsaga > legmesszebb)
            {
                legmesszebb = robotTavolsaga;
                legmesszebbLevoRobotXkoordinatan = robot;
            }
        }

        System.out.print("legtavolabbi robot: " + legmesszebbLevoRobotXkoordinatan + ", megtett ut: " + legmesszebb);
    }

    public void legmesszebbJutoRobotJava8()
    {
        ROBOTOK_LISTAJA.stream().map(this::legnagyobbTavolsag).forEach(System.out::print);
    }

    private Robot legnagyobbTavolsag(Robot robot)
    {
        int robotTavolsaga = Math.abs(robot.getX()) + Math.abs(robot.getY());

        if (robotTavolsaga > legmesszebb)
        {
            legmesszebb = robotTavolsaga;
            legmesszebbLevoRobotXkoordinatan = robot;
        }

        return legmesszebbLevoRobotXkoordinatan;
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
    public void legkisebbTerulet()
    {
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

    public void setLegkisebbTeruletJava8()
    {
        ROBOTOK_LISTAJA.stream().map(this::legkisebbTeruletSzamitasa).forEach(System.out::print);
    }

    private Robot legkisebbTeruletSzamitasa(Robot robot)
    {
        terulet = Math.abs(robot.getX()) * Math.abs(robot.getX());

        if ( terulet > legkisebbTerulet)
        {
            legkisebbTerulet = terulet;
            legkisebbTeruletuRobot = robot;
        }

        return legkisebbTeruletuRobot;
    }

    //    9. Melyik roboté a legnagyobb terület?
    public void legnagyobbTerulet()
    {
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

    public void legnagyobbteruletJava8()
    {
        ROBOTOK_LISTAJA.stream().map(this::teruletetSzamol).findFirst();
    }

    private Object teruletetSzamol(Robot robot)
    {
        terulet = Math.abs(robot.getX()) * Math.abs(robot.getX());

        if ( terulet > legnagyobbTerulet)
        {
            legnagyobbTerulet = terulet;
            legnagyobbTeruletuRobot = robot;
        }

        return null;
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
