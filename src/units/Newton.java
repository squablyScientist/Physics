package units;

import formulae.Direction;

public class Newton extends Unit {


	public Newton(double entry) {
		super(entry);
	}

	public Newton(double entry, double deg) {
		super(entry, deg);
	}

	public Newton(double entry, double deg, Direction direction) {
		super(entry, deg, direction);
	}

	public Newton(double entry, Direction direction) {
		super(entry, direction);
	}

	@Override
	public String toString() {
		if (direction == null) {
			return super.toString() + "N";
		} else if (getValue() < 0) {
			return "" + Math.abs(getValue()) + "N " + Direction.flip(direction);
		} else {
			return super.toString() + "N " + getDirection();
		}

	}
}