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
	public static ArrayList<Newton> getDirectionalAngularForceDegrees(Newton force, double angle){
		ArrayList<Newton> list = new ArrayList<>();
		ArrayList<Unit> unitArrayList;
		unitArrayList = Angles.findComponentsDegrees(force.getValue(), angle);

		list.add((new Newton(unitArrayList.get(0).getValue(), unitArrayList.get(0).getDirection())));
		list.add((new Newton(unitArrayList.get(1).getValue(), unitArrayList.get(1).getDirection())));

		return list;
	}

	 public static ArrayList<Newton> getDirectionalAngularForceRadians(Newton force, Radians angle){
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

}

