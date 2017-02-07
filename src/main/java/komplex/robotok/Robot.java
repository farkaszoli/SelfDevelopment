package komplex.robotok;


import java.util.List;

public class Robot
{
    private final int eszak;
    private final int kelet;
    private final int del;
    private final int nyugat;
    private final int x;
    private final int y;

    public Robot(int eszak, int kelet, int del, int nyugat, int x, int y)
    {
        this.eszak = eszak;
        this.kelet = kelet;
        this.del = del;
        this.nyugat = nyugat;
        this.x = x;
        this.y = y;
    }

    public int getEszak() {
        return eszak;
    }

    public int getKelet() {
        return kelet;
    }

    public int getDel() {
        return del;
    }

    public int getNyugat() {
        return nyugat;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "eszak=" + eszak +
                ", kelet=" + kelet +
                ", del=" + del +
                ", nyugat=" + nyugat +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
