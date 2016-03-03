package units;

import formulae.Direction;

public class MetersPerSecSquared extends Unit {

	public MetersPerSecSquared(double entry) {
		super(entry);
	}

	public MetersPerSecSquared(double entry, double deg) {
		super(entry, deg);
	}

	//Constructor for acceleration with direction
	public MetersPerSecSquared(double entry, double deg, Direction direction) {
		super(entry, deg, direction);
	}

	public MetersPerSecSquared(double entry, Direction direction) {
		super(entry, direction);
	}

	@Override
	public String toString() {
		if (direction == null) {
			return super.toString() + "m/s^2";
		} else if (getValue() < 0) {
			return "" + Math.abs(getValue()) + "m/s^2 " + Direction.flip(direction);
		} else {
			return super.toString() + "m/s^2 " + getDirection();
		}

	}
}