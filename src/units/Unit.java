package units;

import formulae.Direction;

/**
 * @author Collin Tod
 * @version 0.3
 * @since 2-27-2016
 */

public abstract class Unit {

	// Final variable declarations for conversions
	private final double MILLI_TO_BASE = 1.0e3;


	private double value;
	Direction direction;

	//default constructor
	Unit() {
		direction = null;
	}

	Unit(double entry) {
		setValue(entry);

	}

	Unit(double entry, double deg) {

		setValue(Math.pow(entry, deg));
	}

	Unit(double entry, double deg, Direction direction) {

		setValue(Math.pow(entry * direction.getSign(), deg));
		setDirection(direction);

	}

	Unit(double entry, Direction direction) {
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

	public void setValue(double value) {
		this.value = value;
	}

	// ~~~~~~~~~~~~~~~Conversions~~~~~~~~~~~~~~~~
	// converts deci- to the base unit
	public double deciBase(double deci) {
		double DECI_TO_BASE = 1.0e1;
		return deci / DECI_TO_BASE;
	}

	// converts a centi- to the base unit
	public double centiBase(double centi) {
		double CENTI_TO_BASE = 1.0e2;
		return centi / CENTI_TO_BASE;
	}

	// converts a milli- to the base unit
	public double milliBase(double milli) {
		return milli / MILLI_TO_BASE;
	}

	// converts a micro- to the base unit
	public double microBase(double micro) {
		double MICRO_TO_BASE = 1.0e6;
		return micro / MICRO_TO_BASE;
	}

	// Converts a nano- to the base unit
	public double nanoBase(double nano) {
		double NANO_TO_BASE = 1.0e9;
		return nano / NANO_TO_BASE;
	}

	// Converts a Kilo- into the base unit
	public double kiloBASE(double kilo) {
		return kilo * MILLI_TO_BASE;
	}

	@Override
	public String toString() {
		return "" + getValue();
	}
}