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
	public static List<Newton> forceComponents(Newton force, Degree angle) {
		List<Newton> list = new ArrayList<>();
		List<Unit> unitList;
		unitList = Angles.findComponentsDegrees(force, angle);

		list.add((new Newton(unitList.get(0).getValue(), unitList.get(0).getDirection())));
		list.add((new Newton(unitList.get(1).getValue(), unitList.get(1).getDirection())));

		return list;
	}

	/**
	 * Find the two components of a force at an angle that is not up down left or right
	 *
	 * @param force The force exerted
	 * @param angle The angle of the force in relation to the right-hand horizontal in radians
	 * @return an ArrayList of Newton objects with magnitude and direction, one vertical and one horizontal
	 */
	public static List<Newton> forceComponents(Newton force, Radians angle) {
		List<Newton> list = new ArrayList<>();
		List<Unit> unitArrayList;
		unitArrayList = Angles.findComponentsRadians(force, angle);

		list.add((new Newton(unitArrayList.get(0).getValue(), unitArrayList.get(0).getDirection())));
		list.add((new Newton(unitArrayList.get(1).getValue(), unitArrayList.get(1).getDirection())));

		return list;
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
	public static List<Newton> netForce(List<Newton> forces) {
		List<Newton> list = new ArrayList<>();

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

		list.add(hor);
		list.add(vert);

		return list;
	}
}

