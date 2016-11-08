package egypercesek.novenyek;

public class Noveny
{
    private String neve;
    private String gyujtik;
    private int kezdikElGyujteni;
    private int fejezikBeGyujteni;

    public Noveny(String neve, String gyujtik, int kezdikElGyujteni, int fejezikBeGyujteni) {
        this.neve = neve;
        this.gyujtik = gyujtik;
        this.kezdikElGyujteni = kezdikElGyujteni;
        this.fejezikBeGyujteni = fejezikBeGyujteni;
    }

    public String getNeve() {
        return neve;
    }

    public void setNeve(String neve) {
        this.neve = neve;
    }

    public String getGyujtik() {
        return gyujtik;
    }

    public void setGyujtik(String gyujtik) {
        this.gyujtik = gyujtik;
    }

    public int getKezdikElGyujteni() {
        return kezdikElGyujteni;
    }

    public void setKezdikElGyujteni(int kezdikElGyujteni) {
        this.kezdikElGyujteni = kezdikElGyujteni;
    }

    public int getFejezikBeGyujteni() {
        return fejezikBeGyujteni;
    }

    public void setFejezikBeGyujteni(int fejezikBeGyujteni) {
        this.fejezikBeGyujteni = fejezikBeGyujteni;
    }
}
