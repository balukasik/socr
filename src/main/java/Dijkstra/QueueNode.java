package Dijkstra;

public class QueueNode {

	private GraphNode value;
	private double priority;

	public QueueNode(GraphNode value, double priority) {

		this.value = value;
		this.priority = priority;
	}

	public double getPriority() {
		return priority;
	}

	public void setPriority(double priority) {
		this.priority = priority;
	}

	public GraphNode getValue() {
		return value;
	}

	public void setValue(GraphNode value) {
		this.value = value;
	}

}
