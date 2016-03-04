package units;

public class Volt extends Unit {

	public Volt(double entry) {
		super(entry);
	}

	public Volt(double entry, double deg) {
		super(entry, deg);
	}

	@Override
	public String toString() {
		return super.toString() + "V";
	}

}
