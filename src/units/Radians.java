package units;

/**
 * @author Collin Tod
 * @version 0.1
 * @since 2-27-2016
 */
public class Radians extends Unit {

	public Radians(double entry) {
		super(entry);
	}

	public Radians(double entry, double deg) {
		super(entry, deg);
	}

	@Override
	public String toString(){
		return super.toString() + "rad";
	}
}
