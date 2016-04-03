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
		return new Newton(mag);
	}

	//Find the acceleration due to centripetal force
	//F = m a
	//Fc = m ac
	//Fc = (m * v^2) /r
	//m * ac = (m*v^2) / r
	//ac = (v^2)/r
	public MetersPerSecSquared centripAccel(MetersPerSec vel, Meter radius) {
		double mag = (Math.pow(vel.getValue(), 2)) / radius.getValue();
		return new MetersPerSecSquared(mag);
	}

	//find the radius
	//Fc = mv^2/r
	//Fc r = mv^2
	//r = (mv^2)/Fc
	public Meter radius(Kilogram mass, MetersPerSec vel, Newton force) {
		double mag = (mass.getValue() * Math.pow(vel.getValue(), 2)) / force.getValue();
		return new Meter(mag);
	}

	/**
	 * Find the radius of a spinning element based on its velocity and acceleration
	 *
	 * @param vel   The velocity
	 * @param accel The acceleration
	 * @return The radius
	 */
	public Meter radius(MetersPerSec vel, MetersPerSecSquared accel) {
		double mag = Math.pow(vel.getValue(), 2) / accel.getValue();
		return new Meter(mag);
	}


}
