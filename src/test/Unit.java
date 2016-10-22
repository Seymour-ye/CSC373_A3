package test;

public class Unit {
	
	private boolean isDummy;
	private double value;

	public Unit(double v) {
		// TODO Auto-generated constructor stub
		value = v;
		isDummy = false;
	}
	
	public Unit(double v, boolean id) {
		value = v;
		isDummy = !id;
	}
	
	public String toString() {
		if (isDummy) {
			return "   ";
		}
		int v = new Double(value).intValue();
		if (v < 10) {
			return String.format(" %d ", v);
		} else if (v < 100) {
			return String.format("%d %d", v / 10, v % 10);
		} else {
			return String.format("%d%d%d", v / 100, (v / 10) % 10, v % 10);
		}
	}

}
