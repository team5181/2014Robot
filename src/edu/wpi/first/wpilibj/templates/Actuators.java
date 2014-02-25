
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

public class Actuators {

    private final Talon frontLeft;
    private final Talon rearLeft;
    private final Talon frontRight;
    private final Victor rearRight;
    
    private final Relay magLockRelay;
    private final Relay ballLoadRelay;
    private final Relay reloadRelay;
    
    public Actuators() {
        
        frontLeft = new Talon(StaticVars.FRONT_LEFT_MOTOR);
        rearLeft = new Talon(StaticVars.REAR_LEFT_MOTOR);
        frontRight = new Talon(StaticVars.FRONT_RIGHT_MOTOR);
        rearRight = new Victor(StaticVars.REAR_RIGHT_MOTOR);
        
        magLockRelay = new Relay(StaticVars.MAG_LOCK_RELAY_CHANNEL);
        ballLoadRelay = new Relay(StaticVars.BALL_LOAD_RELAY_CHANNEL);
        magLockRelay.set(Relay.Value.kOn);
        reloadRelay = new Relay(StaticVars.RELOAD_RELAY_CHANNEL);
    }
    
    public void turnMagLockOff() {
        magLockRelay.set(Relay.Value.kOff);
    }
    
    public void turnMagLockOn() {
        magLockRelay.set(Relay.Value.kOn);
    }
    
    public void setBallLoadRelayForward() {
        ballLoadRelay.set(Relay.Value.kForward);
    }
    
    public void setBallLoadRelayReverse() {
        ballLoadRelay.set(Relay.Value.kReverse);
    }
    
    public void setballLoadRelayOff() {
        ballLoadRelay.set(Relay.Value.kOff);
    }
    public void setreloadRelayForward() {
        reloadRelay.set(Relay.Value.kForward);
    }
    public void setreloadRelayReverse() {
        reloadRelay.set(Relay.Value.kReverse);
    }
    public void setreloadRelayStop() {
        reloadRelay.set(Relay.Value.kOff);
    }
    
    /**
     * I decided to use nested if-else statements to better encapsulate motor channels.
     * @param motorChannel
     * @return SpeedController (Jaguar, Talon, Victor)
     */
    public SpeedController getMotorController(int motorChannel) {
        if (motorChannel == StaticVars.FRONT_LEFT_MOTOR) {
            return frontLeft;
        } else {
            if (motorChannel == StaticVars.REAR_LEFT_MOTOR) {
                return rearLeft;
            } else {
                if (motorChannel == StaticVars.FRONT_RIGHT_MOTOR) {
                    return frontRight;
                } else {
                    if (motorChannel == StaticVars.REAR_RIGHT_MOTOR) {
                        return rearRight;
                    } else {
                        return null;
                    }
                }
            }
        }
    }
}
