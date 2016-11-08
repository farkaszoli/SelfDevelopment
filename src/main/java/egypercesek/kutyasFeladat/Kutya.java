package egypercesek.kutyasFeladat;

public class Kutya
{
    private String fajta;
    private int kor;
    private String szin;

    public Kutya(String f, int k, String sz) {
        fajta = f;
        kor = k;
        szin = sz;
    }

    public String getFajta() {
        return fajta;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public String getSzin() {
        return szin;
    }

    @Override
    public String toString() {
        return "Kutya{" + "fajta=" + fajta + ", kor=" + kor +
                ", szin=" + szin + '}';
    }

}
