package formulae;

import units.Degree;
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
	 * @return an List with two Unit objects with the magnitude and the direction that make up this angle and magnitude
	 */
	public static List<Unit> findComponentsDegrees(Unit magnitude, Degree angle) {

		List<Unit> list = new ArrayList<>();

		//Convert the degrees into radians
		double angRad = Math.toRadians(angle.getValue());

		//Checks to see if the angle is within a circle, if not throws error
		if (angle.getValue() > 360.0 || angle.getValue() < 0) {
			throw new Error("Cannot compute angle.getValue()s greater than 360 degrees or less than 0 degrees.");
		}

		//Checks to see if the angle is up down left or right
		//Right
		if (angle.getValue() == 360 || angle.getValue() == 0) {
			list.add(new Unit(magnitude.getValue(), Direction.RIGHT));
		}
		//Up
		else if (angle.getValue() == 90) {
			list.add(new Unit(magnitude.getValue(), Direction.UP));
		}
		//Left
		else if (angle.getValue() == 180) {
			list.add(new Unit(magnitude.getValue(), Direction.LEFT));
		}
		//Down
		else if (angle.getValue() == 270) {
			list.add(new Unit(magnitude.getValue(), Direction.DOWN));
		} else {
			//Check to see the quadrant that the angle lies in
			//First Quadrant
			if (angle.getValue() < 90) {
				list.add(new Unit(Math.abs(Math.cos(angRad) * magnitude.getValue()), Direction.RIGHT));
				list.add(new Unit(Math.abs(Math.sin(angRad) * magnitude.getValue()), Direction.UP));
			}
			//Second Quadrant
			else if (angle.getValue() < 180) {
				list.add(new Unit(Math.abs(Math.cos(angRad) * magnitude.getValue()), Direction.LEFT));
				list.add(new Unit(Math.abs(Math.sin(angRad) * magnitude.getValue()), Direction.UP));

			} else if (angle.getValue() < 270) {
				list.add(new Unit(Math.abs(Math.cos(angRad) * magnitude.getValue()), Direction.LEFT));
				list.add(new Unit(Math.abs(Math.sin(angRad) * magnitude.getValue()), Direction.DOWN));

			} else if (angle.getValue() < 360) {
				list.add(new Unit(Math.abs(Math.cos(angRad) * magnitude.getValue()), Direction.RIGHT));
				list.add(new Unit(Math.abs(Math.sin(angRad) * magnitude.getValue()), Direction.DOWN));
			}
		}

		return list;
	}

	//radian version of the findComponentsDegrees method
	public static List<Unit> findComponentsRadians(Unit magnitude, Radians angle) {
		return findComponentsDegrees(magnitude, new Degree(Math.toDegrees(angle.getValue())));
	}

}
