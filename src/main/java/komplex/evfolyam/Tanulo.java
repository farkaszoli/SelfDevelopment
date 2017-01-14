package komplex.evfolyam;
//tanulo;osztaly;magatartas;szorgalom;irodalom;nyelvtan;tortenelem;matematika;angol;nemet;informatika
public class Tanulo
{
    private final String nev;
    private final String osztaly;
    private final String magatartas;
    private final String szorgalom;
    private final int irodalom;
    private final int nyelvtan;
    private final int tortenelem;
    private final int matematika;
    private final int angol;
    private final int nemet;
    private final int informatika;

    public Tanulo(String nev, String osztaly, String magatartas, String szorgalom, int irodalom, int nyelvtan,
                  int tortenelem, int matematika, int angol, int nemet, int informatika)
    {
        this.nev = nev;
        this.osztaly = osztaly;
        this.magatartas = magatartas;
        this.szorgalom = szorgalom;
        this.irodalom = irodalom;
        this.nyelvtan = nyelvtan;
        this.tortenelem = tortenelem;
        this.matematika = matematika;
        this.angol = angol;
        this.nemet = nemet;
        this.informatika = informatika;
    }

    public String getNev()
    {
        return nev;
    }

    public String getOsztaly() {
        return osztaly;
    }

    public String getMagatartas() {
        return magatartas;
    }

    public String getSzorgalom() {
        return szorgalom;
    }

    public int getIrodalom() {
        return irodalom;
    }

    public int getNyelvtan() {
        return nyelvtan;
    }

    public int getTortenelem() {
        return tortenelem;
    }

    public int getMatematika() {
        return matematika;
    }

    public int getAngol() {
        return angol;
    }

    public int getNemet() {
        return nemet;
    }

    public int getInformatika() {
        return informatika;
    }
}
