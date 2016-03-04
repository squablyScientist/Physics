package units;

/**
 * @author Collin Tod
 * @version 0.1
 * @since 3-4-2016
 */
public class Ampere extends Unit {
	public Ampere(double entry) {
		super(entry);
	}

	public Ampere(double entry, double deg) {
		super(entry, deg);
	}

	public String toString() {
		return super.toString() + " A";
	}
}
