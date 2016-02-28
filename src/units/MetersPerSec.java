package units;

import formulae.Direction;

public class MetersPerSec extends Unit {

	public MetersPerSec(double entry) {

		super(entry);
	}

	public MetersPerSec(double entry, double deg) {
		super(entry, deg);
	}

	public MetersPerSec(double entry, Direction direction) {
		super(entry, direction);
	}


	public MetersPerSec(double entry, double deg, Direction direction) {
		super(entry, deg, direction);
	}


	//Conversions
	public static double mphToMetersPerSec(double mph) {
		return mph * 0.44704;
	}

	public static double kmhToMetersPerSec(double kmh) {
		return kmh * 0.277777778;
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
