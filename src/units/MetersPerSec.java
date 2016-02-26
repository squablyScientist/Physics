package units;

public class MetersPerSec extends Unit {

	//git test
	public MetersPerSec(double entry, double deg) {
		super(entry, deg);
	}

	@Override
	public String toString() {
		return super.toString() + "m/s";
	}

}
