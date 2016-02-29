
package formulae;

import units.*;

/**
 * @author Collin Tod
 * @version 0.2
 */
public class Kinematics {


	// -----------------------------Linear 1D--------------------------------

	// Find the velocity regardless of final or initial
	// v = m / t
	public static MetersPerSec vel(Meter distance, Second time) {
		double mag = distance.getValue() / time.getValue();
		return new MetersPerSec(mag);
	}

	// v = at
	public static MetersPerSec vel(MetersPerSecSquared accel, Second time) {
		double mag = accel.getValue() * time.getValue();
		return new MetersPerSec(mag);
	}

	// Find the final velocity
	// v = v0 + at
	public static MetersPerSec finalVel(MetersPerSec init, MetersPerSecSquared
			accel, Second time) {
		double mag = (init.getValue() + (accel.getValue() * time.getValue()));
		return new MetersPerSec(mag);

	}

	//v^2 = v0^2 + 2ax
	public static MetersPerSec finalVel(MetersPerSec init, MetersPerSecSquared accel,
										Meter dist) {
		double mag = Math.sqrt((Math.pow(init.getValue(), 2))
				+ 2 * (accel.getValue() * dist.getValue()));
		return new MetersPerSec(mag, 1);
	}

	//Find the initial velocity
	//v = v0 + at
	//v0 = v - at

	public static MetersPerSec initVel(MetersPerSec vel, MetersPerSecSquared accel, Second time) {
		double mag = vel.getValue() - (accel.getValue() * time.getValue());
		return new MetersPerSec(mag);
	}

	//v^2 = v0^2 + 2ax
	//v0 = sqrt(v^2 - 2ax)
	public static MetersPerSec initVel(MetersPerSec vel, MetersPerSecSquared accel, Meter dist) {
		double mag = Math.sqrt(Math.pow(vel.getValue(), 2) - (2 * accel.getValue() * dist.getValue()));

		return new MetersPerSec(mag);
	}

	//x = v0t + 1/2 a t^2
	//v0 = (x - 1/2 a t^2) / t
	public static MetersPerSec initVel(Meter dist, MetersPerSecSquared accel, Second time) {
		double mag = (dist.getValue() - (0.5 * accel.getValue() * Math.pow(time.getValue(), 2))) / time.getValue();
		return new MetersPerSec(mag);
	}

	//Find the time elapsed
	//v = v0 + at
	//t = (v - v0) / a
	public static Second time(MetersPerSec initVel, MetersPerSec vel, MetersPerSecSquared accel) {
		double mag = (vel.getValue() - initVel.getValue()) / accel.getValue();
		return new Second(mag);
	}

	//Only usable if initial velocity is 0
	//x = 1/2 at^2
	//t = sqrt([x/(1/2 * a)])
	public static Second time(Meter displacement, MetersPerSecSquared accel) {
		double mag = Math.sqrt((displacement.getValue()) / (0.5 * accel.getValue()));
		return new Second(mag);
	}

	//Find the displacement
	//v^2 = v0^2 + 2ax
	//x = (v^2 - v0^2) / 2a
	public static Meter displacement(MetersPerSec vel, MetersPerSec initVel, MetersPerSecSquared accel) {
		double mag = (Math.pow(vel.getValue(), 2) - Math.pow(initVel.getValue(), 2)) / (2 * accel.getValue());
		return new Meter(mag);
	}

	//x = v0t + 1/2 a t^2
	public static Meter displacement(MetersPerSec initVel, MetersPerSecSquared accel, Second time) {
		double mag = (initVel.getValue() * time.getValue()) + (0.5 * accel.getValue() * Math.pow(time.getValue(), 2));
		return new Meter(mag);
	}

	//Find the acceleration

	//v = v0 + at
	//a = (v - v0)/t
	public static MetersPerSecSquared acceleration(MetersPerSec vel, MetersPerSec initVel, Second time) {
		double mag = (vel.getValue() - initVel.getValue()) / time.getValue();
		return new MetersPerSecSquared(mag);
	}

	//v^2 = v0^2 + 2ax
	//a = (v^2 - v0^2)/(2x)
	public static MetersPerSecSquared acceleration(MetersPerSec vel, MetersPerSec initVel, Meter distance) {
		double mag = (Math.pow(vel.getValue(), 2) - Math.pow(initVel.getValue(), 2)) / (2 * distance.getValue());
		return new MetersPerSecSquared(mag);

	}

	//x = v0t + (1/2)at^2
	//a = (x - v0t) / (1/2 * t^2)
	public static MetersPerSecSquared acceleration(Meter distance, MetersPerSec initVel, Second time) {
		double mag = (distance.getValue() - initVel.getValue()) / (0.5 * Math.pow(time.getValue(), 2));
		return new MetersPerSecSquared(mag);
	}
}
