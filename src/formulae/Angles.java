package formulae;

import units.Radians;
import units.Unit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Collin Tod
 * @version 0.2
 * @since 2-27-2016
 * The purpose of this class is to determine the components of a directional unit, be it force, velocity, etc.
 */

class Angles {

	/**
	 * Find the components of a directional unit using degrees
	 *
	 * @param magnitude The magnitude of the force that is being evaluated
	 * @param angle     The angle in relation to the horizontal axis of 0 degrees
	 * @return an ArrayList with two Unit objects with the magnitude and the direction that make up this angle and magnitude
	 */
	public static List<Unit> findComponentsDegrees(double magnitude, double angle) {

		List<Unit> list = new ArrayList<>();

		//Convert the degrees into radians
		double angRad = Math.toRadians(angle);

		//Checks to see if the angle is within a circle, if not throws error
		if (angle > 360.0 || angle < 0) {
			throw new Error("Cannot compute angles greater than 360 degrees or less than 0 degrees.");
		}

		//Checks to see if the angle is up down left or right
		//Right
		if (angle == 360 || angle == 0) {
			list.add(new Unit(magnitude, Direction.RIGHT));
		}
		//Up
		else if (angle == 90) {
			list.add(new Unit(magnitude, Direction.UP));
		}
		//Left
		else if (angle == 180) {
			list.add(new Unit(magnitude, Direction.LEFT));
		}
		//Down
		else if (angle == 270) {
			list.add(new Unit(magnitude, Direction.DOWN));
		} else {
			//Check to see the quadrant that the angle lies in
			//First Quadrant
			if (angle < 90) {
				list.add(new Unit(Math.abs(Math.cos(angRad) * magnitude), Direction.RIGHT));
				list.add(new Unit(Math.abs(Math.sin(angRad) * magnitude), Direction.UP));
			}
			//Second Quadrant
			else if (angle < 180) {
				list.add(new Unit(Math.abs(Math.cos(angRad) * magnitude), Direction.LEFT));
				list.add(new Unit(Math.abs(Math.sin(angRad) * magnitude), Direction.UP));

			} else if (angle < 270) {
				list.add(new Unit(Math.abs(Math.cos(angRad) * magnitude), Direction.LEFT));
				list.add(new Unit(Math.abs(Math.sin(angRad) * magnitude), Direction.DOWN));

			} else if (angle < 360) {
				list.add(new Unit(Math.abs(Math.sin(angRad) * magnitude), Direction.RIGHT));
				list.add(new Unit(Math.abs(Math.sin(angRad) * magnitude), Direction.DOWN));
			}
		}

		return list;
	}

	//radian version of the findComponentsDegrees method
	public static List<Unit> findComponentsRadians(double magnitude, Radians angle) {
		return findComponentsDegrees(magnitude, Math.toDegrees(angle.getValue()));
	}

}
