package units;

public class Joule extends Unit {

	public Joule(double entry) {
		super(entry);
	}

	public Joule(double entry, double deg) {
		super(entry, deg);
	}


	@Override
	public String toString() {
		return super.toString() + "J";
	}
}
