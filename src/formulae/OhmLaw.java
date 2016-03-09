package formulae;

import units.*;

/**
 * @author Collin Tod
 * @version 0.1
 * @since 3-4-2016
 */
class OhmLaw {

	//Voltage

	/**
	 * Find the voltage consumed by travelling through an element based on the current and the resistance
	 *
	 * @param cur The current travelling through the element
	 * @param res The resistance of the element
	 * @return The voltage of the element
	 */
	public static Volt findVoltage(Ampere cur, Ohm res) {
		double mag = cur.getValue() * res.getValue();
		return new Volt(mag);
	}

	//Current

	/**
	 * Find the current that is travelling through the element based on the voltage and the resistance
	 *
	 * @param volt The voltage of the  element
	 * @param res  The resistance of the element
	 * @return The current travelling through the element
	 */
	public static Ampere findCurrent(Volt volt, Ohm res) {
		double mag = volt.getValue() / res.getValue();
		return new Ampere(mag);
	}

	//Resistance

	/**
	 * Find the resistance in an object based on the voltage and the current
	 *
	 * @param volt The voltage of the element
	 * @param cur  The current travelling through the element
	 * @return The resistance applied by the element
	 */
	public static Ohm findResistance(Volt volt, Ampere cur) {
		double mag = volt.getValue() / cur.getValue();
		return new Ohm(mag);
	}
}
