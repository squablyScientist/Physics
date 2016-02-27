package units;

public class Meter extends Unit {

	// Constructor and conversion into usable value
	public Meter(double entry, double deg) {
		super(entry, deg);
	}

	@Override
	public String toString() {
		return super.toString() + "m";

	}
}
