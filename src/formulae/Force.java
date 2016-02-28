package formulae;

import units.*;

import java.util.ArrayList;

class Force {

	// Find the force exerted anywhere
	//F = ma
	private static Newton getForce(Kilogram mass, MetersPerSecSquared accel) {
		double mag = mass.getValue() * accel.getValue();

		return new Newton(mag, 1.0);
	}

	//Find force with a direction
	public static Newton getDirectionalForce(Kilogram mass, MetersPerSecSquared accel, Direction direction) {
		double mag = getForce(mass, accel).getValue();
		return new Newton(mag, 1.0, direction);
	}

	//Find the two components of an angular force
	//Degrees
	public static ArrayList<Newton> getDirectionalAngularForceDegrees(Newton force, double angle) {
		ArrayList<Newton> list = new ArrayList<>();
		ArrayList<Unit> unitArrayList;
		unitArrayList = Angles.findComponentsDegrees(force.getValue(), angle);

		list.add((new Newton(unitArrayList.get(0).getValue(), unitArrayList.get(0).getDirection())));
		list.add((new Newton(unitArrayList.get(1).getValue(), unitArrayList.get(1).getDirection())));

		return list;
	}

	//Radians
	public static ArrayList<Newton> getDirectionalAngularForceRadians(Newton force, Radians angle) {
		ArrayList<Newton> list = new ArrayList<>();
		ArrayList<Unit> unitArrayList;
		unitArrayList = Angles.findComponentsRadians(force.getValue(), angle);

		list.add((new Newton(unitArrayList.get(0).getValue(), unitArrayList.get(0).getDirection())));
		list.add((new Newton(unitArrayList.get(1).getValue(), unitArrayList.get(1).getDirection())));

		return list;
	}


	//Find the gravitational force on something
	public static Newton getGravForce(Kilogram mass) {
		return new Newton(mass.getValue() * 9.8, 1.0);
	}

	//Find the net force on any given object
	public ArrayList<Newton> netForce(ArrayList<Newton> forces) {
		ArrayList<Newton> list = new ArrayList<>();

		double netHor = 0.0;
		double netVert = 0.0;
		Newton vert, hor;

		//Add up all of the force magnitudes
		for (int i = 0; i < forces.size(); i++) {
			if (forces.get(i).getDirection() == Direction.UP || forces.get(i).getDirection() == Direction.DOWN) {
				netVert += forces.get(i).getValue();
			} else if (forces.get(i).getDirection() == Direction.RIGHT || forces.get(i).getDirection() == Direction.LEFT) {
				netHor += forces.get(i).getValue();
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

