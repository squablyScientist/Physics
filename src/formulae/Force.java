package formulae;

import units.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Collin Tod
 * @version 0.3
 * @since 2-27-2016
 */

public class Force {

	/**
	 * @param mass  Mass of the object being evaluated
	 * @param accel The acceleration of the object being evaluated
	 * @return the product of the the two params as a force
	 */
	private static Newton getForce(Kilogram mass, MetersPerSecSquared accel) {
		double mag = mass.getValue() * accel.getValue();

		return new Newton(mag, 1.0);
	}

	/**
	 * Find the Directional force based on the mass, acceleration, and the direction of acceleration
	 *
	 * @param mass      The mass of the object
	 * @param accel     The acceleration of the object
	 * @param direction The direction of the acceleration
	 * @return The product of the mass and acceleration as a force
	 */
	public static Newton getDirectionalForce(Kilogram mass, MetersPerSecSquared accel, Direction direction) {
		double mag = getForce(mass, accel).getValue();
		return new Newton(mag, 1.0, direction);
	}

	/**
	 * Find the two components of a force at an angle that is not up down left or right
	 *
	 * @param force The force exerted
	 * @param angle The angle of the force in relation to the right-hand horizontal in degrees
	 * @return an ArrayList of Newton objects with magnitude and direction, one vertical and one horizontal
	 */
	public static Newton[] forceComponents(Newton force, Degree angle) {
		Newton[] forces = new Newton[2];
		Unit[] unitArr = Angles.findComponentsDegrees(force, angle);

		forces[0] = new Newton(unitArr[0].getValue(), unitArr[0].getDirection());
		forces[1] = new Newton(unitArr[1].getValue(), unitArr[1].getDirection());

		return forces;
	}

	/**
	 * Find the two components of a force at an angle that is not up down left or right
	 *
	 * @param force The force exerted
	 * @param angle The angle of the force in relation to the right-hand horizontal in radians
	 * @return an ArrayList of Newton objects with magnitude and direction, one vertical and one horizontal
	 */
	public static Newton[] forceComponents(Newton force, Radians angle) {
		Newton[] forces = new Newton[2];
		Unit[] unitArr = Angles.findComponentsRadians(force, angle);

		forces[0] = new Newton(unitArr[0].getValue(), unitArr[0].getDirection());
		forces[1] = new Newton(unitArr[1].getValue(), unitArr[1].getDirection());

		return forces;
	}


	/**
	 * Finds the gravitational force on any given object
	 *
	 * @param mass The mass of the object
	 * @return The product of the mass and the acceleration of gravity in the down direction
	 */
	public static Newton getGravForce(Kilogram mass) {
		return new Newton(mass.getValue() * 9.8, Direction.DOWN);
	}

	/**
	 * //Find the net force
	 *
	 * @param forces Takes an ArrayList of Newton
	 * @return ArrayList of two Newton objects, with the first being the net horizontal force and the
	 * second being the net force of the vertical force
	 */
	public static Newton[] netForce(List<Newton> forces) {
		Newton[] arr = new Newton[2];

		double netHor = 0.0;
		double netVert = 0.0;
		Newton vert, hor;

		//Add up all of the force magnitudes
		for (Newton force : forces) {
			if (force.getDirection() == Direction.UP || force.getDirection() == Direction.DOWN) {
				netVert += force.getValue();
			} else if (force.getDirection() == Direction.RIGHT || force.getDirection() == Direction.LEFT) {
				netHor += force.getValue();
			}
		}

		//Check to see if the vertical force is up, down, or 0
		if (netVert > 0) {
			vert = new Newton(netVert, Direction.UP);
		} else if (netVert < 0) {
			vert = new Newton(netVert, Direction.DOWN);
		} else {
			vert = new Newton(netVert);
		}

		//Check to see of the horizontal force is left, right, or 0
		if (netHor > 0) {
			hor = new Newton(netHor, Direction.RIGHT);
		} else if (netHor < 0) {
			hor = new Newton(netHor, Direction.LEFT);
		} else {
			hor = new Newton(netHor);
		}

		arr[0] = hor;
		arr[1] = vert;

		return arr;
	}
}

