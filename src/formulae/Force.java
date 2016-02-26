package formulae;

import units.*;

class Force {

	// Find the force exerted anywhere
	public Newton getForce(Kilogram mass, MetersPerSecSquared accel) {
		double magnitude = mass.getValue() * accel.getValue();

		return new Newton(magnitude, 1.0);
		
	}

}
