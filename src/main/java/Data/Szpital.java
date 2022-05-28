package Data;

public class Szpital {

    private int id;
    private String nazwa;
    private double x;
    private double y;



    public Szpital(int id, String nazwa, double x, double y) {
        this.id = id;
        this.nazwa = nazwa;
        this.x = x;
        this.y = y;

    }

    public Szpital(String[] data) throws NumberFormatException {
        this.id = Integer.parseInt(data[0]);
        this.nazwa = data[1];
        this.x = Integer.parseInt(data[2]);
        this.y = Integer.parseInt(data[3]);

    }


    public Szpital(String[] data, int id) throws NumberFormatException {
        this.id = id;
        this.nazwa = data[1];
        this.x = Integer.parseInt(data[2]);
        this.y = Integer.parseInt(data[3]);
    }

    public Szpital(int id, String nazwa, int x, int y) {
    }

    public Szpital(Szpital obiekt) {
        this.id = obiekt.getId();
        this.nazwa = obiekt.getNazwa();
        this.x = obiekt.getX();
        this.y = obiekt.getY();

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





    public int getId() {
        return id;
    }


}
