package units;

public class Meter extends Unit {
	public Meter(double entry) {
		super(entry);
	}

	// Constructor and conversion into usable value
	public Meter(double entry, double deg) {
		super(entry, deg);
	}

	//Conversions
	public static double miletoMeter(double miles){
		return miles * 1609.34;
	}
	@Override
	public String toString() {
		return super.toString() + "m";

	}
}
