package units;

/**
 * @author Collin Tod
 * @version 0.1
 * @since 3-4-2016
 */
public class Ohm extends Unit {
	public Ohm(double entry) {
		super(entry);
	}

	public Ohm(double entry, double deg) {
		super(entry, deg);
	}

	@Override
	public String toString() {
		return super.toString() + " \u03A9";
	}
}
