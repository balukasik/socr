package Jarvis;

import Data.Pacjent;
import Data.Szpital;

import java.util.List;

public class Utility {

    static Szpital findExtreme(List<Szpital> points) {

        Szpital p = new Szpital(points.get(0));
        for(int i=1;i<points.size();i++) {
            double x = points.get(i).getX();
            double y = points.get(i).getY();
            if(x < p.getX() || (x == p.getX() && y<p.getY())) {
                p=points.get(i);
            }

        }
        return p;
    }

    static int orientation(Szpital p, Szpital q, Szpital r)
    {
        return compare(((q.getX()-p.getX())*(r.getY()-p.getY())) - ((q.getY()-p.getY())*(r.getX()-p.getX())),0);
    }

    static int compare(double a, double b)
    {
        if(a>b)
            return 1;
        else if(a<b)
            return -1;
        return 0;
    }

    static double distance(Szpital p, Szpital q) {
        double dx = q.getX()-p.getX();
        double dy = q.getY()-p.getY();
        return ((dx*dx) + (dy*dy));
    }

    static double distance(Szpital p, Pacjent q) {
        double dx = q.getX()-p.getX();
        double dy = q.getY()-p.getY();
        return ((dx*dx) + (dy*dy));
    }
}
