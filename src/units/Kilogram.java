package units;

public class Kilogram extends Unit {

	// Constructor and conversion into usable value
	public Kilogram(double entry, double deg) {
		super(entry, deg);
	}

	@Override
	public String toString() {
		return super.toString() + "kg";
	}
}
