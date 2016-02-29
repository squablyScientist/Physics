package units;

import formulae.Direction;

/**
 * @author Collin Tod
 * @version 0.3
 * @since 2-27-2016
 */

public class Unit {

	// Final variable declarations for conversions
	private final double MILLI_TO_BASE = 1.0e3;
	private final double CENTI_TO_BASE = 1.0e2;
	private final double NANO_TO_BASE = 1.0e9;
	private final double MICRO_TO_BASE = 1.0e6;
	private final double DECI_TO_BASE = 1.0e1;


	private double value;
	Direction direction;


	public Unit(double entry) {
		setValue(entry);
	}

	public Unit(double entry, double deg) {
		setValue(Math.pow(entry, deg));

	}

	public Unit(double entry, double deg, Direction direction) {
		setValue(Math.pow(entry * direction.getSign(), deg));
		setDirection(direction);
	}

	public Unit(double entry, Direction direction) {
		setValue(entry * direction.getSign());
		setDirection(direction);
	}


	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}


	//getter and setter
	public double getValue() {
		return value;
	}

	private void setValue(double value) {
		this.value = value;
	}

	// Conversions
	// converts deci- to the base unit
	public double deciBase(double deci) {
		return deci / DECI_TO_BASE;
	}

	// converts a centi- to the base unit
	public double centiBase(double centi) {
		return centi / CENTI_TO_BASE;
	}

	// converts a milli- to the base unit
	public double milliBase(double milli) {
		return milli / MILLI_TO_BASE;
	}

	// converts a micro- to the base unit
	public double microBase(double micro) {
		return micro / MICRO_TO_BASE;
	}

	// Converts a nano- to the base unit
	public double nanoBase(double nano) {
		return nano / NANO_TO_BASE;
	}

	// Converts a Kilo- into the base unit
	public double kiloBASE(double kilo) {
		return kilo * MILLI_TO_BASE;
	}

	public String toString() {
		return String.valueOf(getValue());

	}
}