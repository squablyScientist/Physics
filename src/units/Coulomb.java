package units;

public class Coulomb extends Unit {

	public Coulomb(double entry, double deg) {
		super(entry, deg);
	}
	
	@Override
	public String toString(){
		return super.toString() + "C";
	}

}
