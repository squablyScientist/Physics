package formulae;

import units.Degree;
import units.Radians;
import units.Unit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Collin Tod
 * @version 0.3
 * @since 2-27-2016
 * The purpose of this class is to determine the components of a directional unit, be it force, velocity, etc.
 */

class Angles {

	/**
	 * Find the components of a directional unit using degrees
	 *
	 * @param magnitude The magnitude of the force that is being evaluated
	 * @param angle     The angle in relation to the horizontal axis of 0 degrees
	 * @return an List with two Unit objects with the magnitude and the direction that make up this angle and magnitude
	 */
	public static Unit[] findComponentsDegrees(Unit magnitude, Degree angle) {

		Unit[] comps = new Unit[2];

		//Convert the degrees into radians
		double angRad = Math.toRadians(angle.getValue());

		//Checks to see if the angle is within a circle, if not throws error
		if (angle.getValue() > 360.0 || angle.getValue() < 0) {
			throw new IllegalArgumentException("Cannot compute angle.getValue()s greater than 360 degrees or less than 0 degrees.");
		}

		//Checks to see if the angle is up down left or right
		//Right
		if (angle.getValue() == 360 || angle.getValue() == 0) {
			comps[0] = (new Unit(magnitude.getValue(), Direction.RIGHT));
		}
		//Up
		else if (angle.getValue() == 90) {
			comps[1] = new Unit(magnitude.getValue(), Direction.UP);
		}
		//Left
		else if (angle.getValue() == 180) {
			comps[0] = new Unit(magnitude.getValue(), Direction.LEFT);
		}
		//Down
		else if (angle.getValue() == 270) {
			comps[1] = (new Unit(magnitude.getValue(), Direction.DOWN));
		} else {
			//Check to see the quadrant that the angle lies in

			//Make the array of directions
			Direction[] direct = new Direction[2];

			//First Quadrant
			if (angle.getValue() < 90) {
				direct[0] = Direction.RIGHT;
				direct[1] = Direction.UP;
			}
			//Second Quadrant
			else if (angle.getValue() < 180) {
				direct[0] = Direction.LEFT;
				direct[1] = Direction.UP;

			} else if (angle.getValue() < 270) {
				direct[0] = Direction.LEFT;
				direct[1] = Direction.DOWN;

			} else if (angle.getValue() < 360) {
				direct[0] = Direction.RIGHT;
				direct[1] = Direction.DOWN;
			}

			comps[0] = new Unit(Math.abs(Math.cos(angRad) * magnitude.getValue()), direct[0]);
			comps[1] = new Unit(Math.abs(Math.sin(angRad) * magnitude.getValue()), direct[1]);
		}

		return comps;
	}

	//radian version of the findComponentsDegrees method
	public static Unit[] findComponentsRadians(Unit magnitude, Radians angle) {
		return findComponentsDegrees(magnitude, new Degree(Math.toDegrees(angle.getValue())));
	}

}
