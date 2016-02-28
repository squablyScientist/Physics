package formulae;

/**
 * @author Collin Tod
 * @version 0.1
 * @since 2-27-2016
 *
 * This enum is to apply a directional modifier on any unit. The first parameter of the constructor is the unicode
 * for different arrows, and the second parameter is to set the unit as either positive or negative so that net
 * units can be discovered. The degree parameter will be passed as "deg" in the Unit constructor. Currently only Newton
 * implements this.
 */


public enum Direction {
	UP("\u2191", 1.0), DOWN("\u2193", -1.0), RIGHT("\u2192", 1.0), LEFT("\u2190", -1.0) ;

	private final String arrow;
	private final double degree;

	//constructor
	Direction(String arrow, double posneg) {
		this.arrow = arrow;
		this.degree = posneg;
	}

	private String getArrow() {
		return arrow;
	}

	public double getDegree() {
		return degree;
	}

	@Override
	public String toString() {
		return getArrow();
	}
}
