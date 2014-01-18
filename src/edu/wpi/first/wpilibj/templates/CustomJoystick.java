
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;


/**
 * This class can be used to optimally tune input values from a joystick.
 * And can be used to dead-band the joystick.
 * @author davidcox95
 */
public class CustomJoystick extends Joystick {

    public CustomJoystick(int port) {
        super(port);
    }
    
    /**
     * Converts direction in rads to degrees.
     * It overrides superclass getDirectionDegrees()
     * which does not use PI, instead acos(-1) for C++ library.
     * @return double
     */
    public double getDirectionDegrees() {
        return super.getDirectionRadians()*180.0/Math.PI;
    }
    
    /**
     * Overrides superclass getMagnitude()
     * in order to give programmer easy
     * tuning abilities.
     * @return magnitude of vector
     */
    public double getMagnitude() {
        if (Math.abs(super.getMagnitude()) < 0.25)
            return 0;
        return Math.sqrt(Math.abs(super.getMagnitude()));
    }
    /**
     * Overrides superclass getTwist()
     * in order to give programmer easy
     * tuning abilities.[-1,1]
     * @return double
     */
    public double getTwist() {
        if (Math.abs(super.getTwist()) < 0.6)
            return 0;
        return super.getTwist();
    }

}
