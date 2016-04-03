
package formulae;

import units.*;

/**
 * @author Collin Tod
 * @version 0.5
 */
class Kinematics {


	// -----------------------------Linear 1D--------------------------------

	/**
	 * //Find the velocity based on distance ant time
	 *
	 * @param distance The distance travelled
	 * @param time     Time elapsed
	 * @return The velocity
	 */
	public static MetersPerSec vel(Meter distance, Second time) {
		double mag = distance.getValue() / time.getValue();
		return new MetersPerSec(mag);
	}

	/**
	 * Find the velocity based on the time and acceleration
	 *
	 * @param accel The acceleration
	 * @param time  The time elapsed
	 * @return The velocity
	 */
	public static MetersPerSec vel(MetersPerSecSquared accel, Second time) {
		double mag = accel.getValue() * time.getValue();
		return new MetersPerSec(mag);
	}

	/**
	 * Find the final velocity based on time, initial velocity, and acceleration.
	 *
	 * @param init  The initial velocity
	 * @param accel The acceleration
	 * @param time  The time elapsed
	 * @return The final velocity
	 */
	public static MetersPerSec finalVel(MetersPerSec init, MetersPerSecSquared
			accel, Second time) {
		double mag = (init.getValue() + (accel.getValue() * time.getValue()));
		return new MetersPerSec(mag);

	}

	/**
	 * Find the final velocity based on the initial velocity, acceleration, and the displacement.
	 *
	 * @param init  The initial velocity
	 * @param accel The acceleration
	 * @param dist  The displacement
	 * @return The final velocity
	 */
	public static MetersPerSec finalVel(MetersPerSec init, MetersPerSecSquared accel,
										Meter dist) {
		double mag = Math.sqrt((Math.pow(init.getValue(), 2))
				+ 2 * (accel.getValue() * dist.getValue()));
		return new MetersPerSec(mag, 1);
	}

	/**
	 * Find the initial velocity based on the final velocity, acceleration, and the time elapsed
	 *
	 * @param vel   The final velocity
	 * @param accel The acceleration
	 * @param time  The time elapsed
	 * @return The initial velocity
	 */
	public static MetersPerSec initVel(MetersPerSec vel, MetersPerSecSquared accel, Second time) {
		double mag = vel.getValue() - (accel.getValue() * time.getValue());
		return new MetersPerSec(mag);
	}

	/**
	 * Find the initial velocity due to the final velocity, acceleration, and the displacement
	 *
	 * @param vel   The velocity
	 * @param accel The acceleration
	 * @param dist  The displacement
	 * @return The initial velocity
	 */
	public static MetersPerSec initVel(MetersPerSec vel, MetersPerSecSquared accel, Meter dist) {
		double mag = Math.sqrt(Math.pow(vel.getValue(), 2) - (2 * accel.getValue() * dist.getValue()));

		return new MetersPerSec(mag);
	}

	/**
	 * Find the initial velocity based on the displacement, acceleration, and the time elapsed
	 *
	 * @param dist  The displacement
	 * @param accel The acceleration
	 * @param time  The time elapsed
	 * @return The initial velocity
	 */
	public static MetersPerSec initVel(Meter dist, MetersPerSecSquared accel, Second time) {
		double mag = (dist.getValue() - (0.5 * accel.getValue() * Math.pow(time.getValue(), 2))) / time.getValue();
		return new MetersPerSec(mag);
	}

	/**
	 * Find the time elapsed based on the initial velocity, final velocity, and the acceleration
	 *
	 * @param initVel The initial velocity
	 * @param vel     The final velocity
	 * @param accel   The acceleration
	 * @return The time elapsed in the system
	 */
	public static Second time(MetersPerSec initVel, MetersPerSec vel, MetersPerSecSquared accel) {
		double mag = (vel.getValue() - initVel.getValue()) / accel.getValue();
		return new Second(mag);
	}

	/**
	 * Find the time elapsed based on the displacement and the acceleration
	 *
	 * @param initVel      The initial velocity MUST BE 0.0 FOR THIS METHOD TO WORK
	 * @param displacement The displacement
	 * @param accel        The acceleration
	 * @return The time elapsed
	 * @throws Error that tells the user that the method does not apply
	 */
	public static Second time(MetersPerSec initVel, Meter displacement, MetersPerSecSquared accel) {
		if (initVel.getValue() != 0) {
			throw new IllegalArgumentException();
		}
		double mag = Math.sqrt((displacement.getValue()) / (0.5 * accel.getValue()));
		return new Second(mag);
	}

	/**
	 * Find the displacement based on the final velocity, initial velocity, and acceleration
	 *
	 * @param vel     The final velocity
	 * @param initVel The initial velocity
	 * @param accel   The acceleration
	 * @return The displacement
	 */
	public static Meter displacement(MetersPerSec vel, MetersPerSec initVel, MetersPerSecSquared accel) {
		double mag = (Math.pow(vel.getValue(), 2) - Math.pow(initVel.getValue(), 2)) / (2 * accel.getValue());
		return new Meter(mag);
	}

	/**
	 * Find the displacement based on the initial velocity, acceleration, and time elapsed
	 *
	 * @param initVel The initial velocity
	 * @param accel   The acceleration
	 * @param time    The time elapsed
	 * @return The displacement
	 */
	public static Meter displacement(MetersPerSec initVel, MetersPerSecSquared accel, Second time) {
		double mag = (initVel.getValue() * time.getValue()) + (0.5 * accel.getValue() * Math.pow(time.getValue(), 2));
		return new Meter(mag);
	}

	/**
	 * Find the acceleration based on the
	 *
	 * @param vel     The final velocity
	 * @param initVel The initial velocity
	 * @param time    The time elapsed
	 * @return The acceleration
	 */
	public static MetersPerSecSquared acceleration(MetersPerSec vel, MetersPerSec initVel, Second time) {
		double mag = (vel.getValue() - initVel.getValue()) / time.getValue();
		return new MetersPerSecSquared(mag);
	}

	/**
	 * Find the acceleration based on the final velocity, initial velocity, and displacement
	 *
	 * @param vel     The final velocity
	 * @param initVel The initial velocity
	 * @param disp    The displacement
	 * @return The acceleration
	 */
	public static MetersPerSecSquared acceleration(MetersPerSec vel, MetersPerSec initVel, Meter disp) {
		double mag = (Math.pow(vel.getValue(), 2) - Math.pow(initVel.getValue(), 2)) / (2 * disp.getValue());
		return new MetersPerSecSquared(mag);

	}

	/**
	 * Find the acceleration based on displacement, initial velocity, and time elapsed
	 *
	 * @param disp    The displacement
	 * @param initVel The initial velocity
	 * @param time    The time elapsed
	 * @return The acceleration
	 */
	public static MetersPerSecSquared acceleration(Meter disp, MetersPerSec initVel, Second time) {
		double mag = (disp.getValue() - initVel.getValue()) / (0.5 * Math.pow(time.getValue(), 2));
		return new MetersPerSecSquared(mag);
	}

	//~~~~~~~~~~~~~~~~Linear 2d~~~~~~~~~~~~~~~~~~~~~~~~~

	/**
	 * Find the components of a angled velocity
	 *
	 * @param speed The velocity of the hypotenuse
	 * @param angle The angle at which the magnitude is pointed, in angles
	 * @return an array of the two components(horizontal, vertical)
	 */
	public static MetersPerSec[] velComponents(MetersPerSec speed, Degree angle) {
		MetersPerSec[] arr = new MetersPerSec[2];
		Unit[] unitArray = Angles.findComponentsDegrees(speed, angle);

		arr[0] = (new MetersPerSec(unitArray[0].getValue(), unitArray[0].getDirection()));
		arr[1] = (new MetersPerSec(unitArray[1].getValue(), unitArray[1].getDirection()));

		return arr;
	}

	/**
	 * Find the components of a angled velocity
	 *
	 * @param speed The velocity of the hypotenuse
	 * @param angle The angle at which the magnitude is pointed in radians
	 * @return a list of the two components(horizontal, vertical)
	 */
	public static MetersPerSec[] velComponents(MetersPerSec speed, Radians angle) {
		MetersPerSec[] arr = new MetersPerSec[2];
		Unit[] unitArray = Angles.findComponentsRadians(speed, angle);

		arr[0] = (new MetersPerSec(unitArray[0].getValue(), unitArray[0].getDirection()));
		arr[1] = (new MetersPerSec(unitArray[1].getValue(), unitArray[1].getDirection()));

		return arr;
	}


	/**
	 * Find the components of a angled acceleration
	 *
	 * @param accel The acceleration of the hypotenuse
	 * @param angle The angle at which the magnitude is pointed in degrees
	 * @return a list of the two components(horizontal, vertical)
	 */
	public static Unit[] accComponents(MetersPerSecSquared accel, Degree angle) {
		Unit[] arr = new Unit[2];
		Unit[] unitArr = Angles.findComponentsDegrees(accel, angle);

		arr[0] = (new MetersPerSecSquared(unitArr[0].getValue(), unitArr[0].getDirection()));
		arr[1] = (new MetersPerSecSquared(unitArr[1].getValue(), unitArr[1].getDirection()));

		return arr;
	}

	/**
	 * Find the components of a angled acceleration
	 *
	 * @param accel The acceleration of the hypotenuse
	 * @param angle The angle at which the magnitude is pointed in radians
	 * @return a list of the two components(horizontal, vertical)
	 */
	public static Unit[] accComponents(MetersPerSecSquared accel, Radians angle) {
		Unit[] arr = new Unit[2];
		Unit[] unitArr = Angles.findComponentsRadians(accel, angle);

		arr[0] = (new MetersPerSecSquared(unitArr[0].getValue(), unitArr[0].getDirection()));
		arr[1] = (new MetersPerSecSquared(unitArr[1].getValue(), unitArr[1].getDirection()));

		return arr;
	}
}
