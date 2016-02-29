package formulae;

/**
 * @author Collin Tod
 * @version 0.1
 * @since 2-27-2016
 * <p>
 * This enum is to apply a directional modifier on any unit. The first parameter of the constructor is the unicode
 * for different arrows, and the second parameter is to set the unit as either positive or negative so that net
 * units can be discovered. The sign parameter will multiply the "value" variable in the Unit constructors that take
 * a Direction as a parameter.
 * </p>
 */


public enum Direction {
	UP("\u2191", 1.0), DOWN("\u2193", -1.0), RIGHT("\u2192", 1.0), LEFT("\u2190", -1.0);

	private final String arrow;
	private final double sign;

	//constructor
	Direction(String arrow, double posneg) {
		this.arrow = arrow;
		this.sign = posneg;
	}

	private String getArrow() {
		return arrow;
	}

	public double getSign() {
		return sign;
	}

	@Override
	public String toString() {
		return getArrow();
	}
}
