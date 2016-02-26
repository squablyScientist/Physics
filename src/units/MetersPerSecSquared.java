package units;

public class MetersPerSecSquared extends Unit {

	public MetersPerSecSquared(double entry, double deg) {
		super(entry, deg);
	}
	
	public String toString(){
		return super.toString() + "m/s^2";
	}

}
