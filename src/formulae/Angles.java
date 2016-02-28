package formulae;

import units.Radians;
import units.Unit;

import java.util.ArrayList;

/**
 * @author Collin Tod
 * @version 0.1
 * @since 2-27-2016
 * <p>
 * The purpose of this class is to determine the components of a directional unit, be it force, velocity, etc.
 */

class Angles {
	public static ArrayList<Unit> findComponentsDegrees(double magnitude, double angle) {

		ArrayList<Unit> list = new ArrayList<>();

		//Convert the degrees into radians
		double angRad = Math.toRadians(angle);

		//Checks to see if the angle is within a circle, if not throws error
		if (angle > 360.0 || angle < 0) {
			throw new Error("Cannot compute angles greater than 360 degrees or less than 0 degrees.");
		}

		//Checks to see if the angle is up down left or right
		switch ((int) angle) {
			//Right
			case 0:
			case 360:
				list.add(new Unit(magnitude, Direction.RIGHT));
				break;
			//Up
			case 90:
				list.add(new Unit(magnitude, Direction.UP));
				break;
			//Left
			case 180:
				list.add(new Unit(magnitude, Direction.LEFT));
				break;
			//Down
			case 270:
				list.add(new Unit(magnitude, Direction.DOWN));
				break;
			default:
				//Check to see the quadrant that the angle lies in
				if (angle < 90) {
					list.add(new Unit((Math.sin(angRad) * magnitude), Direction.UP));
					list.add(new Unit((Math.cos(angRad) * magnitude), Direction.RIGHT));
				} else if (angle < 180) {
					list.add(new Unit((Math.sin(angRad) * magnitude), Direction.UP));
					list.add(new Unit((Math.cos(angRad) * magnitude), Direction.LEFT));
				} else if (angle < 270) {
					list.add(new Unit((Math.sin(angRad) * magnitude), Direction.DOWN));
					list.add(new Unit((Math.cos(angRad) * magnitude), Direction.LEFT));
				} else if (angle < 360) {
					list.add(new Unit((Math.sin(angRad) * magnitude), Direction.DOWN));
					list.add(new Unit((Math.sin(angRad) * magnitude), Direction.RIGHT));
				}
		}
		return list;
	}

	//radian version of the findComponentsDegrees method
	public static ArrayList<Unit> findComponentsRadians(double magnitude, Radians angle) {
		return findComponentsDegrees(magnitude, Math.toDegrees(angle.getValue()));
	}

}
