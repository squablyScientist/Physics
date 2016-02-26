package formulae;
import units.*;

class Energy {

	//Potential Energy
	
	//gravity
	public Joule gravPotEn(Kilogram mass, Meter height){
		double mag = mass.getValue() * height.getValue() * 9.8;
		return new Joule(mag, 1.0);
	}
	
	//Spring
//	public Joule springPotEn(){
//		//TODO finish this 
//	}
	//Kinetic
	public Joule kinEn(Kilogram mass, MetersPerSec velocity){
		double mag = (0.5) * mass.getValue() * Math.pow(velocity.getValue(), 2);
		return new Joule(mag, 1.0);
	}
	
	
	
}
