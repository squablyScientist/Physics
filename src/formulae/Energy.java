package formulae;

import units.*;

class Energy {

	//Potential Energy

	/**
	 * Find the potential energy due to gravity
	 *
	 * @param mass   The mass od the object
	 * @param height The height in relation to the lowest point achieved in the system
	 * @return a Joule that has the magnitude of the potential energy due to gravity
	 */
	public Joule gravPotEn(Kilogram mass, Meter height) {
		double mag = mass.getValue() * height.getValue() * 9.8;
		return new Joule(mag);
	}

	//Spring
//	public Joule springPotEn(){
//		//TODO finish this you lazy prick
//	}


	//Kinetic


	/**
	 * Find the kinetic energy due to mass and velocity
	 *
	 * @param mass The mass of the object
	 * @param vel  The velocity
	 * @return a Joule that has the magnitude of the kinetic energy due to the velocity and mass
	 */
	public Joule kinEn(Kilogram mass, MetersPerSec vel) {
		double mag = (0.5) * mass.getValue() * Math.pow(vel.getValue(), 2);
		return new Joule(mag);
	}
}
