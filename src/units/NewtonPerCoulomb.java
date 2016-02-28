package units;

public class NewtonPerCoulomb extends Unit {

	public NewtonPerCoulomb(double entry) {
		super(entry);
	}

	public NewtonPerCoulomb(double entry, double deg) {
		super(entry, deg);

	}
	
	@Override
	public String toString(){
		return super.toString() + "N/C";
	}

}
