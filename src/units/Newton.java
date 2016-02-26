package units;

public class Newton extends Unit {

	public Newton(double entry, double deg) {
		super(entry, deg);
	}
	
	@Override
	public String toString(){
		return super.toString() + "N";
	}

}
