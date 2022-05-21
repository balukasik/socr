package Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;

import Data.Dane;
import Data.Droga;
import Data.Szpital;

public class Dijkstra {
	public ArrayList<GraphNode> nodes;

	public Dijkstra(ArrayList<Szpital> szpitale) {
		this.nodes = new ArrayList<GraphNode>();
		for (int i = 0; i < szpitale.size(); i++) {
			nodes.add(new GraphNode(szpitale.get(i).getId(), null, 0));
		}
	}

	private DoubleV2[] algorithm(ArrayList<GraphNode> nodes, ArrayList<Droga> drogi, int startId) {
		DoubleV2[] d = new DoubleV2[nodes.size()];;
		for (int i = 0; i < nodes.size(); i++) {
			d[i] = new DoubleV2(Double.MAX_VALUE);
			d[i].id = i+1;
		}
		d[startId-1].value = 0;
		Kolejka q = new Kolejka();
		for (int i = 0; i < nodes.size(); i++) {
			q.wstaw(new QueueNode(nodes.get(i), d[i]));
		}
		while (q.isNotEmpty()) {
			GraphNode tmp = q.pobierz();
			ArrayList<GraphNode> sasiedzi = new ArrayList<GraphNode>();
			for (Droga droga : drogi) {
				if (droga.getIdSzpitala1() == tmp.getId()) {
					nodes.get(droga.getIdSzpitala2() - 1).setKoszt(droga.getOdlglosc());
					sasiedzi.add(nodes.get(droga.getIdSzpitala2() - 1));
				} else if (droga.getIdSzpitala2() == tmp.getId()) {
					nodes.get(droga.getIdSzpitala1() - 1).setKoszt(droga.getOdlglosc());
					sasiedzi.add(nodes.get(droga.getIdSzpitala1() - 1));
				}
			}
			for (GraphNode sasiad : sasiedzi) {
				if (d[sasiad.getId()-1].value > (d[tmp.getId()-1].value + sasiad.getKoszt())) {

					d[sasiad.getId()-1].value = d[tmp.getId()-1].value + sasiad.getKoszt();
					nodes.get(sasiad.getId() - 1).setPoprzednik(tmp);
				}
			}

		}

		return d;
	}

	 public static int[] drogaPacjenta( int startId) {
		int[] droga = new int[Dane.szpitale.size()];
		droga[0] = startId;
		int next = startId;
		for (int i = 1; i < Dane.szpitale.size();i++) {
			Dijkstra dijkstra = new Dijkstra(Dane.szpitale);
			DoubleV2 d[] = dijkstra.algorithm(dijkstra.nodes, Dane.drogi, next);
			Arrays.sort(d);	
			for (int j = 0; j < d.length;j++) {
				if(notContains(droga,d[j].id)){
					droga[i] = d[j].id;
					next = d[j].id;
					break;
				}
			}
			if (Dane.szpitale.get(droga[i]-1).getWolne_lozka() < Dane.szpitale.get(droga[i]-1).getLozka()) {
				if (i == droga.length -1) {
					return droga;
				}else {
					droga[i+1] = -1;
					return trim(droga);					
				}
			}
		}
		return droga;
	}
	private static int[] trim(int[] droga) {
		int counter = 0;
		while(droga[counter] != -1){
			counter ++;
		}
		int[] result = new int[counter];
		for(int i = 0; i <counter; i++) {
			result[i] = droga[i];
		}
		return result;
	}

	private static boolean notContains(int[] ls, int a) {
		for(int i : ls) {
			if (a ==  i ) {
				return false;
			}
		}
		return true;
	}
}
