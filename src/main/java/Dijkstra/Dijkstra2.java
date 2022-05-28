package Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;

import Data.Dane;
import Data.Droga;
import Data.Szpital;

public class Dijkstra2 {
    public ArrayList<GraphNode> nodes;
    private ArrayList<Droga> drogi;

    public Dijkstra2(ArrayList<Szpital> szpitale, ArrayList<Droga> drogi) {
        this.nodes = new ArrayList<GraphNode>();
        this.drogi = drogi;
        for (Szpital szpital : szpitale) {
            nodes.add(new GraphNode(szpital.getId(), null, Double.MAX_VALUE));
        }
    }

    private void algorithm(int startId) {
       GraphNode s = getNode(startId);
       s.setKoszt(0.0);
        Kolejka q = new Kolejka();
        for(GraphNode n: nodes){
            q.wstaw(new QueueNode(n,n.getKoszt()));
        }
        while(q.isNotEmpty()){
            GraphNode tmp = q.pobierz();
            ArrayList<GraphNode> sasiedzi = sasiedzi(tmp);
            for(GraphNode sasiad: sasiedzi){
                if( sasiad.getKoszt() > tmp.getKoszt() + waga(sasiad,tmp)){
                    sasiad.setKoszt(tmp.getKoszt() + waga(sasiad,tmp));
                    sasiad.setPoprzednik(tmp);
                }
            }
        }
    }

    private double waga(GraphNode sasiad, GraphNode s) {
        for(Droga d: drogi){
            if(d.getIdSzpitala1() == sasiad.getId() && d.getIdSzpitala2() == s.getId()){
                return d.getOdlglosc();
            }
            if(d.getIdSzpitala2() == sasiad.getId() && d.getIdSzpitala1() == s.getId()){
                return d.getOdlglosc();
            }
        }
        return 0.0;
    }

    private ArrayList<GraphNode> sasiedzi(GraphNode tmp) {
        ArrayList<GraphNode> sasiedzi = new ArrayList<GraphNode>();
        for(Droga d: drogi){
            if(d.getIdSzpitala1() == tmp.getId()){
                sasiedzi.add(getNode(d.getIdSzpitala2()));
            } else if (d.getIdSzpitala2() == tmp.getId()){
                sasiedzi.add(getNode(d.getIdSzpitala1()));
            }
        }
        return sasiedzi;
    }

    private GraphNode getNode(int id){
        for(GraphNode node : nodes){
            if(id == node.getId()){
                return node;
            }
        }
        return null;
    }

    private int destination(int startId, int destiantionId){
        if(startId == destiantionId){
            return startId;
        }
        GraphNode tmp = getNode(destiantionId);
        while (tmp != null && tmp.getPoprzednik() != getNode(startId)) {
            tmp = tmp.getPoprzednik();
        }
        return tmp.getId();
    }

    public static int drogaPacjenta( int startId, int destinationId) {
        Dijkstra2 dijkstra = new Dijkstra2(Dane.szpitale, Dane.drogi);
        dijkstra.algorithm(startId);
        return dijkstra.destination(startId, destinationId);
    }
}
