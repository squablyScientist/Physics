package units;

import formulae.Direction;

public class Newton extends Unit {

	Direction direction;

	//Constructor for just force
	public Newton(double entry, double deg) {
		super(entry, deg);
	}

	//Constructor for force with direction
	public Newton(double entry, double deg, Direction direction) {
		super(entry, deg);
		this.direction = direction;
	}

	@Override
	public String toString() {
		if (direction == null) {
			return super.toString() + "N";
		} else {
			return super.toString() + "N " + direction;
		}

	}
}