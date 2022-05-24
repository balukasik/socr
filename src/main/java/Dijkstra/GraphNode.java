package Dijkstra;

public class GraphNode {
	private int id;
	private GraphNode poprzednik;
	private double koszt;

	public GraphNode(int id, GraphNode poprzednik,double koszt) {
		this.id = id;
		this.poprzednik = poprzednik;
		this.koszt = koszt;
	}

	public GraphNode getPoprzednik() {
		return poprzednik;
	}

	public void setPoprzednik(GraphNode poprzednik) {
		this.poprzednik = poprzednik;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public double getKoszt() {
		return koszt;
	}

	public void setKoszt(double koszt) {
		this.koszt = koszt;
	}
}
