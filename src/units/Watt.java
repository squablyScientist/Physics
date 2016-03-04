package units;

public class Watt extends Unit{

	public Watt(double entry) {
		super(entry);
	}

	public Watt(double entry, double deg) {
		super(entry, deg);
	}

	@Override
	public String toString(){
		return super.toString() + "W";
	}
}
