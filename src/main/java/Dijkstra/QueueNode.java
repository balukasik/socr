package Dijkstra;

public class QueueNode {

	private GraphNode value;
	private DoubleV2 priority;

	public QueueNode(GraphNode value, DoubleV2 priority) {

		this.setValue(value);
		this.setPriority(priority);
	}

	public double getPriority() {
		return priority.value;
	}

	public void setPriority(DoubleV2 priority) {
		this.priority = priority;
	}

	public GraphNode getValue() {
		return value;
	}

	public void setValue(GraphNode value) {
		this.value = value;
	}

}
