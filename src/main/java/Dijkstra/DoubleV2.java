package Dijkstra;

public class DoubleV2 implements Comparable<DoubleV2> {

	public double value;
	public int id;

	public DoubleV2(double val) {
		this.value = val;
	}

	@Override
	public int compareTo(DoubleV2 o) {
		if (o.value == value) {
			return 0;
		} else if (o.value > value) {
			return -1;
		} else {
			return 1;
		}
	}

}
