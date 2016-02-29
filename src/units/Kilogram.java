package units;

import formulae.Direction;

public class Kilogram extends Unit {

	public Kilogram(double entry) {
		super(entry);
	}

	// Constructor and conversion into usable value
	public Kilogram(double entry, double deg) {
		super(entry, deg);
	}

	@Override
	public String toString() {
		return super.toString() + "kg";
	}
}
