package units;

public class Second extends Unit{
	public Second(double entry) {
		super(entry);
	}

	public Second(double entry, double deg) {
		super(entry, deg);
	}

	public static double minToSec(double mins){
		return mins * 60.0;
	}
	
	public static double hourToSec(double mins){
		return mins * 3600.0;
	}
	
	
	@Override
	public String toString(){
		return super.toString() + "s";
	}
}
