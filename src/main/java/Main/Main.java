package Main;

import Data.Dane;
import Data.Pacjent;
import Data.Szpital;
import Dijkstra.Dijkstra;
import IsInside.IsInside;
import Jarvis.Jarvis;

import java.util.ArrayList;
import java.util.List;

public class Main {

	
	public static void main(String[] args) {

		Dane.read("data/daneTestowe.txt");
		Dane.readPacjent("data/daneTestowePacjenci.txt");


		
		List<Szpital> result = new ArrayList<Szpital>();
		Jarvis jarvis=new Jarvis();
		result=jarvis.convexHull();


		System.out.println("jarvis wyniki");
		int i=0;
		for (Szpital obiekt : result){
			System.out.println(obiekt.getId());
		}
		System.out.println("koniec" );

		Dane.clearObjects();
		Dane.skrzyzowania();
	
		
		Pacjent szpital = new Pacjent(0,400,400);
		IsInside isInside=new IsInside();
		System.out.println(isInside.isInside(result,szpital));
		Szpital nearest = Jarvis.findNearest(szpital);
		System.out.println(nearest.getNazwa());

	}

}