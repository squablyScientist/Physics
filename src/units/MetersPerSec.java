package units;

import formulae.Direction;

public class MetersPerSec extends Unit {


	public MetersPerSec(double entry, double deg) {
		super(entry, deg);
	}

	//Constructor for speed with direction
	public MetersPerSec(double entry, double deg, Direction direction) {
		super(entry, deg, direction);
	}

	@Override
	public String toString() {
		if (direction == null) {
			return super.toString() + "m/s";
		} else {
			return super.toString() + "m/s " + direction;
		}

	}
}
