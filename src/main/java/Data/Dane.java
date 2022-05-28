package Data;

import GUI.Controller;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
public class Dane {
	public static final String ADDR = "http://127.0.0.1:5000/";
	public static ArrayList<Szpital> szpitale = new ArrayList<>();
	public static ArrayList<Droga> drogi = new ArrayList<>();
	public static ArrayList<Pacjent> pacjenci = new ArrayList<>();

	public static void resetDane() {
		szpitale = new ArrayList<>();
		drogi = new ArrayList<>();
		pacjenci = new ArrayList<>();
	}

	public static void pobierzWagi(){
		try{
			URL url = new URL(ADDR+drogi.size());
			URLConnection request = url.openConnection();
			request.connect();
			BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
			String line = in.readLine();
			in.close();
			line = line.substring(1,line.length()-2);
			String[] numbers = line.split(",");
			for(int i =0; i<numbers.length;i++){
				drogi.get(i).setOdleglosc(Double.parseDouble(numbers[i]));
			}
		}catch(Exception ignored){
			System.out.println("Connection error" + ignored.getMessage());
			ignored.printStackTrace();
		}
	}

	public static void resetPacjenci(){
		pacjenci = new ArrayList<>();
	}

	public static int read(String fileName) {
		resetDane();
		int sekcja = 0;
		int lineNum = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(fileName));) {
			String line = br.readLine();
			while (line != null) {
				lineNum++;
				if (line.length() > 0) {
					if (line.charAt(0) == '#') {
						sekcja++;
						line = br.readLine();
					} else if (sekcja == 1) {
						String[] attributes = line.trim().split("\\s*\\|\\s*");
						if (attributes.length != 4) {
							Controller.showErrorWindow("Zła ilość atrybutów\nLinia: " + lineNum);
							Controller.showErrorWindow("asdf");
							resetDane();
							return -1;
						}
						try {
							szpitale.add(new Szpital(attributes));
						} catch (NumberFormatException e) {
							Controller.showErrorWindow("Złe dane w linii " + lineNum);
							resetDane();
							return -1;
						}
						line = br.readLine();


					} else if (sekcja == 2) {
						String[] attributes = line.trim().split("\\s*\\|\\s*");
						if (attributes.length != 4) {
							Controller.showErrorWindow("Zła ilość atrybutów\nLinia: " + lineNum);
							resetDane();
							return -1;
						}
						try {
							drogi.add(new Droga(attributes));
						} catch (NumberFormatException e) {
							Controller.showErrorWindow("Złe dane w linii " + lineNum);
							resetDane();
							return -1;
						}
						line = br.readLine();
					} else if (sekcja == 3) {
						break;
					} else {
						Controller.showErrorWindow("xxBrak linii rozpoczynającej się znakiem #");
						resetDane();
						return -1;
					}
				} else {
					line = br.readLine();
				}
			}
			if (sekcja != 2) {
				Controller.showErrorWindow("Brak 2 zbiorów danycj (Szpitale,drogi");
				resetDane();
				return -1;
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return 1;
	}

	public static int readPacjent(String fileName) {
		int sekcja = 0;
		int lineNum = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(fileName));) {
			String line = br.readLine();
			while (line != null) {
				lineNum++;
				if (line.length() > 0) {
					if (line.charAt(0) == '#') {
						sekcja++;
						line = br.readLine();
					} else if (sekcja == 1) {
						String[] attributes = line.trim().split("\\s*\\|\\s*");
						if (attributes.length != 4) {
							Controller.showErrorWindow("Zła ilość atrybutów\nLinia: " + lineNum);
							resetPacjenci();
							return -1;
						}
						pacjenci.add(new Pacjent(attributes, lineNum));
						line = br.readLine();

					} else if (sekcja == 2) {
						break;
					} else {
						Controller.showErrorWindow("Brak linii rozpoczynającej się znakiem #");
						resetPacjenci();
						return -1;
					}
				} else {
					line = br.readLine();
				}
			}
			if (sekcja != 1) {
				Controller.showErrorWindow("Brak zbioru danych (Pacjenci)");
				resetPacjenci();
				return -1;
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return 1;
	}









	public void clearAll() {
		szpitale = new ArrayList<>();
		drogi = new ArrayList<>();
		pacjenci = new ArrayList<>();

	}

	public static Szpital getSzpital(int id){
		for(Szpital szpital : szpitale){
			if(szpital.getId() == id){
				return szpital;
			}
		}
		return null;
	}

	public static double odl(int id1,int id2){
		for (Droga droga : Dane.drogi) {
			if((droga.getIdSzpitala1()==id1 || droga.getIdSzpitala1()==id2) && (droga.getIdSzpitala2()==id1 ||droga.getIdSzpitala2()==id2))
				return droga.getOdlglosc();
		}
		return 10;
	}

}
