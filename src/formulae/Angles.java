package formulae;

import units.Degree;
import units.Radians;
import units.Unit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Collin Tod
 * @version 0.5
 * @since 2-27-2016
 * The purpose of this class is to determine the components of a directional unit, be it force, velocity, etc.
 */

class Angles<T extends Unit> {
	//declare wildcards that can be any units, will conform to the the type on call
	private T genComp;
	private T compHor;
	private T compVert;


	/**
	 * Find the components of a directional unit using degrees
	 *
	 * @param magnitude The magnitude of the force that is being evaluated
	 * @param angle     The angle in relation to the horizontal axis of 0 degrees
	 * @return an List with two Unit objects with the magnitude and the direction that make up this angle and magnitude
	 */
	public List<T> findComponentsDegrees(T magnitude, Degree angle) {

		List<T> list = new ArrayList<>();

		//Convert the degrees into radians
		double angRad = Math.toRadians(angle.getValue());

		//Checks to see if the angle is within a circle, if not throws error
		if (angle.getValue() > 360.0 || angle.getValue() < 0) {
			throw new IllegalArgumentException("Cannot compute angle.getValue()s greater than 360 degrees or less than 0 degrees.");
		}

		//Checks to see if the angle is up down left or right
		//Right
		if (angle.getValue() == 360 || angle.getValue() == 0) {
			genComp.setValue(magnitude.getValue());
			genComp.setDirection(Direction.RIGHT);
			list.add(genComp);
		}
		//Up
		else if (angle.getValue() == 90) {
			genComp.setValue(magnitude.getValue());
			genComp.setDirection(Direction.UP);
			list.add(genComp);
		}
		//Left
		else if (angle.getValue() == 180) {
			genComp.setValue(magnitude.getValue());
			genComp.setDirection(Direction.LEFT);
			list.add(genComp);
		}
		//Down
		else if (angle.getValue() == 270) {
			genComp.setValue(magnitude.getValue());
			genComp.setDirection(Direction.DOWN);
			list.add(genComp);
		} else {


			//Set the magnitude of the two components
			double test = Math.cos(angRad) * magnitude.getValue();

			//TODO fix below, mutator methods throw NullPointerException
			compHor.setValue(Math.abs(Math.cos(angRad) * magnitude.getValue()));
			compVert.setValue(Math.abs(Math.sin(angRad) * magnitude.getValue()));


			//Check to see the quadrant that the angle lies in, and find the direction
			//First Quadrant
			if (angle.getValue() < 90) {
				compHor.setDirection(Direction.RIGHT);
				compVert.setDirection(Direction.UP);
			}
			//Second Quadrant
			else if (angle.getValue() < 180) {
				compHor.setDirection(Direction.LEFT);
				compVert.setDirection(Direction.UP);

			}
			//Third Quadrant
			else if (angle.getValue() < 270) {
				compHor.setDirection(Direction.LEFT);
				compVert.setDirection(Direction.DOWN);

			}
			//Fourth Quadrant
			else if (angle.getValue() < 360) {
				compHor.setDirection(Direction.RIGHT);
				compVert.setDirection(Direction.DOWN);
			}

			list.add(compHor);
			list.add(compVert);
		}

		return list;
	}

	//radian version of the findComponentsDegrees method
	public List findComponentsRadians(T magnitude, Radians angle) {
		return findComponentsDegrees(magnitude, new Degree(Math.toDegrees(angle.getValue())));
	}

}
