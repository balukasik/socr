package Data;

public class Szpital {

    private int id;
    private String nazwa;
    private double x;
    private double y;
    private int lozka;
    private int wolneMiejsca;


    public Szpital(int id, String nazwa, double x, double y, int lozka, int wolneMiejsca) {
        this.id = id;
        this.nazwa = nazwa;
        this.x = x;
        this.y = y;
        this.lozka = lozka;
        this.wolneMiejsca = wolneMiejsca;
    }

    public Szpital(String[] data) throws NumberFormatException {
        this.id = Integer.parseInt(data[0]);
        this.nazwa = data[1];
        this.x = Integer.parseInt(data[2]);
        this.y = Integer.parseInt(data[3]);
        this.lozka = Integer.parseInt(data[4]);
        this.wolneMiejsca = Integer.parseInt(data[5]);
    }


    public Szpital(String[] data, int id) throws NumberFormatException {
        this.id = id;
        this.nazwa = data[1];
        this.x = Integer.parseInt(data[2]);
        this.y = Integer.parseInt(data[3]);
        this.lozka = 0;
        this.wolneMiejsca = 0;
    }

    public Szpital(int id, String nazwa, int x, int y, int wolne_lozka) {
    }

    public Szpital(Szpital obiekt) {
        this.id = obiekt.getId();
        this.nazwa = obiekt.getNazwa();
        this.x = obiekt.getX();
        this.y = obiekt.getY();
        this.lozka = obiekt.getLozka();
        this.wolneMiejsca = obiekt.getWolne_lozka();
    }

    public String getNazwa() {
        return nazwa;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getLozka() {
        return lozka;
    }

    public int getWolne_lozka() {
        return wolneMiejsca;
    }

    public void setWolne_lozka(int wolneMiejsca) {
        this.wolneMiejsca = wolneMiejsca;
    }

    public int getId() {
        return id;
    }

    public void decreaseWolneMiejsca() {
        wolneMiejsca--;
    }
}
