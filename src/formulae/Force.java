package formulae;

import units.*;

class Force {

	// Find the force exerted anywhere
	//F = ma
	public static Newton getForce(Kilogram mass, MetersPerSecSquared accel) {
		double mag = mass.getValue() * accel.getValue();

		return new Newton(mag, 1.0);
	}

	//Find force with a direction
	public static Newton getDirectionalForce(Kilogram mass, MetersPerSecSquared accel, Direction direction) {
		double mag = getForce(mass, accel).getValue();
		return new Newton(mag, direction.getDegree(), direction);
	}

	//Find the gravitational force on something
	public static Newton getGravForce(Kilogram mass) {
		return new Newton(mass.getValue() * 9.8, 1.0);
	}

}

