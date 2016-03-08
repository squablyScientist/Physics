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

	/**
	 * @param arrow The unicode String that when printed appears as an arrow denoting the direction
	 * @param sign  an Integer that determines whether or not the unit is positive or negative for net calculations
	 */
	Direction(String arrow, double sign) {
		this.arrow = arrow;
		this.sign = sign;
	}

	private String getArrow() {
		return arrow;
	}

	public double getSign() {
		return sign;
	}

	/**
	 * @param d The Direction that is to be flipped
	 * @return the opposite Direction to parameter "d"
	 * @throws Error when invalid direction is entered as a param
	 */
	public static Direction flip(Direction d) {
		if (d == DOWN) {
			return UP;
		} else if (d == UP) {
			return DOWN;
		} else if (d == LEFT) {
			return RIGHT;
		} else if (d == RIGHT) {
			return LEFT;
		} else {
			throw new Error("Not a valid Direction, why are you editing this code without an IDE");
		}
	}

	@Override
	public String toString() {
		return getArrow();
	}
}
