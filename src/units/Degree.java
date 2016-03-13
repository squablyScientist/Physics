package units;

import java.util.IllformedLocaleException;

/**
 * @author Collin Tod
 * @version 0.1
 * @since 3-8-2016
 */
public class Degree extends Unit {
	public Degree(double entry) {
		if (entry < 0 || entry > 360) {
			throw new IllformedLocaleException("Cannot evaluate a degree value greater than 360 or less than 0");
		} else {
			setValue(entry);
		}
	}

	@Override
	public String toString() {
		return super.toString() + "\u00b0";
	}
}
