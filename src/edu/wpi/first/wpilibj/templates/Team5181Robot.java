/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Team5181Robot extends IterativeRobot {
    
    //Global Declarations
    RobotHardware hardware;
    SmartDashboard dash;
    Autonomous autonomous;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        hardware = new RobotHardware();
        dash = new SmartDashboard();
        autonomous = new Autonomous(hardware);
    }

    public void robotDisabled() {
        
    }
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        
        
        autonomous.runAuto(-1); //negative value because we only have 1 auto function.
        
    }
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        
        //1. get driver station data
        
        //get direction, magnitude, and twist from hardware joystick
        double direction = hardware.getJoystick().getDirectionDegrees();
        double magnitude = hardware.getJoystick().getMagnitude();
        double twist     = hardware.getJoystick().getTwist();
        
        //2. get sensor data
        //3. process data
        //4. output data
        hardware.getRobotDrive().mecanumDrive_Polar(magnitude, direction, twist);
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}