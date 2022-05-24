package Data;

import GUI.Controller;

public class Droga {

    private int id;
    private int idSzpitala1;
    private int idSzpitala2;
    private double odlglosc;

    public Droga(int id, int idSzpitala1, int idSzpitala2, double odlglosc) {
        this.id = id;
        this.idSzpitala1 = idSzpitala1;
        this.idSzpitala2 = idSzpitala2;
        this.odlglosc = odlglosc;
    }

    public Droga(String[] data) throws NumberFormatException {
        this.id = Integer.parseInt(data[0]);
        this.idSzpitala1 = Integer.parseInt(data[1]);
        this.idSzpitala2 = Integer.parseInt(data[2]);
        this.odlglosc = Integer.parseInt(data[3]);
    }

    public int getIdSzpitala1() {
        return idSzpitala1;
    }

    public int getIdSzpitala2() {
        return idSzpitala2;
    }

    public double getOdlglosc() {
        return odlglosc;
    }

    public void setOdleglosc(double odlglosc){this.odlglosc = odlglosc;}

    public int getId() {
        return id;
    }

}
