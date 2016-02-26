package units;

public class Meter extends Unit {

	// Constructor and conversion into usable value
	public Meter(double entry, int deg) {
		super(entry, deg);
	}

	@Override
	public String toString() {
		return super.toString() + "m";

	}
}
