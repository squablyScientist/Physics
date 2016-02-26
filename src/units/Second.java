package units;

public class Second extends Unit{

	public Second(double entry, double deg) {
		super(entry, deg);
	}

	public double minToSec(double mins){
		return mins * 60.0;
	}
	
	public double hourToSec(double mins){
		return mins * 3600.0;
	}
	
	
	@Override
	public String toString(){
		return super.toString() + "s";
	}
}
