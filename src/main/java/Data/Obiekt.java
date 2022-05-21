package Data;

public class Obiekt extends Szpital{

	public Obiekt(int id, String nazwa, double x, double y) {
		super(id,nazwa,x,y,0,0);
	}

	public Obiekt(Obiekt obiekt) {
		super(obiekt);
	}

	public Obiekt(String[] data,int id) {
		super(data,id);
	}

}