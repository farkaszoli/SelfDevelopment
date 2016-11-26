package egypercesek.folyo;

public class Mezo
{
    private final int pozicio_n;
    private final int pozicio_m;
    private final int erteke;

    public Mezo(int pozicio_n, int pozicio_m, int erteke) {
        this.pozicio_n = pozicio_n;
        this.pozicio_m = pozicio_m;
        this.erteke = erteke;
    }

    public int getPozicio_n() {
        return pozicio_n;
    }

    public int getPozicio_m() {
        return pozicio_m;
    }

    public int getErteke() {
        return erteke;
    }
}
