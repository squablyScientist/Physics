package formulae;

import units.*;

/**
 * @author Collin Tod
 * @version 0.1
 * @since 2-27-2106
 */
class Centripetal {

	//Find the centripetal force
	//Fc = (mv^2)/r
	public static Newton centripForce(Kilogram mass, MetersPerSec vel, Meter radius) {
		double mag = (mass.getValue() * Math.pow(vel.getValue(), 2)) / radius.getValue();
		return new Newton(mag, 1.0);
	}

	//Find the acceleration due to centripetal force
	//F = m a
	//Fc = m ac
	//Fc = (m * v^2) /r
	//m * ac = (m*v^2) / r
	//ac = (v^2)/r
	public static MetersPerSecSquared centripAccel(MetersPerSec vel, Meter radius) {
		double mag = (Math.pow(vel.getValue(), 2)) / radius.getValue();
		return new MetersPerSecSquared(mag, 1.0);
	}

}
