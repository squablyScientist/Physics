package formulae;

import units.*;

/**
 * @author Collin Tod
 * @version 0.1
 * @since 2-27-2106
 */
class Centripetal {

	/**
	 * Find the centripetal force based on the mass, velocity, and the radius
	 *
	 * @param mass   The mass
	 * @param vel    The velocity
	 * @param radius The radius in relation to the centre of the circle
	 * @return The centripetal force
	 */
	public Newton centripForce(Kilogram mass, MetersPerSec vel, Meter radius) {
		double mag = (mass.getValue() * Math.pow(vel.getValue(), 2)) / radius.getValue();
		return new Newton(mag, 1.0);
	}

	//Find the acceleration due to centripetal force
	//F = m a
	//Fc = m ac
	//Fc = (m * v^2) /r
	//m * ac = (m*v^2) / r
	//ac = (v^2)/r
	public MetersPerSecSquared centripAccel(MetersPerSec vel, Meter radius) {
		double mag = (Math.pow(vel.getValue(), 2)) / radius.getValue();
		return new MetersPerSecSquared(mag, 1.0);
	}

	//find the radius
	//Fc = mv^2/r
	//Fc r = mv^2
	//r = (mv^2)/Fc
	public Meter radius(Kilogram mass, MetersPerSec vel, Newton force) {
		double mag = (mass.getValue() * Math.pow(vel.getValue(), 2)) / force.getValue();
		return new Meter(mag);
	}

	//ac = (v^2) / r
	//r * ac = v^2
	//r = (v^2)/ac
	public Meter radius(MetersPerSec vel, MetersPerSecSquared accell) {
		double mag = Math.pow(vel.getValue(), 2) / accell.getValue();
		return new Meter(mag);
	}


}
