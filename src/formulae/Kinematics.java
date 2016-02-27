package formulae;

import units.*;

class Kinematics {

    // -----------------------------Linear--------------------------------

    // Find the velocity regardless of final or initial
    // v = m / t
    public static MetersPerSec vel(Meter distance, Second time) {
        double mag = distance.getValue() / time.getValue();
        return new MetersPerSec(mag, 1.0);
    }

    // v = at
    public static MetersPerSec vel(MetersPerSecSquared accel, Second time) {
        double mag = accel.getValue() * time.getValue();
        return new MetersPerSec(mag, 1.0);
    }

    // Find the final velocity
    // v = v0 + at
    public static MetersPerSec finalVel(MetersPerSec init, MetersPerSecSquared
            accel, Second time) {
        double mag = (init.getValue() + (accel.getValue() * time.getValue()));
        return new MetersPerSec(mag, 1.0);

    }


    //v^2 = v0^2 + 2ax
    public static MetersPerSec finalVel(MetersPerSec init, MetersPerSecSquared accel,
                                        Meter dist) {
        double mag = Math.sqrt((Math.pow(init.getValue(), 2))
                + 2 * (accel.getValue() * dist.getValue()));
        return new MetersPerSec(mag, 1);
    }

    //Find the initial velocity
    //v = v0 + at
    //v0 = v - at
    public static MetersPerSec initVel(MetersPerSec vel, MetersPerSecSquared accel, Second time) {
        double mag = vel.getValue() - (accel.getValue() * time.getValue());

        return new MetersPerSec(mag, 1.0);
    }

    //v^2 = v0^2 + 2ax
    //v0 = sqrt(v^2 - 2ax)
    public static  MetersPerSec initVel(MetersPerSec vel, MetersPerSecSquared accel, Meter dist){
        double mag = Math.sqrt(Math.pow(vel.getValue(),2) - (2 * accel.getValue() * dist.getValue()));

        return new MetersPerSec(mag, 1.0);
    }


}
