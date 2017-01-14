package komplex.evfolyam;
//tanulo;osztaly;magatartas;szorgalom;irodalom;nyelvtan;tortenelem;matematika;angol;nemet;informatika
public class Tanulo
{
    private final String nev;
    private final String osztaly;
    private final String magatartas;
    private final String szorgalom;
    private final String irodalom;
    private final String nyelvtan;
    private final String tortenelem;
    private final String matematika;
    private final String angol;
    private final String nemet;
    private final String informatika;

    public Tanulo(String nev, String osztaly, String magatartas, String szorgalom, String irodalom, String nyelvtan,
                  String tortenelem, String matematika, String angol, String nemet, String informatika)
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

    public String getIrodalom() {
        return irodalom;
    }

    public String getNyelvtan() {
        return nyelvtan;
    }

    public String getTortenelem() {
        return tortenelem;
    }

    public String getMatematika() {
        return matematika;
    }

    public String getAngol() {
        return angol;
    }

    public String getNemet() {
        return nemet;
    }

    public String getInformatika() {
        return informatika;
    }

    @Override
    public String toString() {
        return "Tanulo{" +
                "nev='" + nev + '\'' +
                ", osztaly='" + osztaly + '\'' +
                ", magatartas='" + magatartas + '\'' +
                ", szorgalom='" + szorgalom + '\'' +
                ", irodalom='" + irodalom + '\'' +
                ", nyelvtan='" + nyelvtan + '\'' +
                ", tortenelem='" + tortenelem + '\'' +
                ", matematika='" + matematika + '\'' +
                ", angol='" + angol + '\'' +
                ", nemet='" + nemet + '\'' +
                ", informatika='" + informatika + '\'' +
                '}';
    }
}
