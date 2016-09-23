package org.usfirst.frc.team2383.robot.subsystems;

import org.usfirst.frc.team2383.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Flap extends Subsystem {
    
	Solenoid flap;
	
	public Flap(){
    	flap = new Solenoid(RobotMap.flap);

    }
    
    public void flapUp(){
    	flap.set(true);
    }
    
    
    public void flapDown(){
    	flap.set(false);
    }
    
    public void initDefaultCommand() {
        flap.set(false);
    }
}


