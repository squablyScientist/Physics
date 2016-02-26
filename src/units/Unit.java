package units;

abstract public class Unit {

	// Final variable declarations for conversions
	private final double MILLI_TO_BASE = 1.0e3;
	private final double CENTI_TO_BASE = 1.0e2;
	private final double NANO_TO_BASE = 1.0e9;
	private final double MICRO_TO_BASE = 1.0e6;
	private final double DECI_TO_BASE = 1.0e1;

	
	private double value;

	Unit(double entry, double deg) {
		setValue(Math.pow(entry, deg));

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
		return String.valueOf(value);

	}
}