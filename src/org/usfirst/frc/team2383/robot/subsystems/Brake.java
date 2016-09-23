package org.usfirst.frc.team2383.robot.subsystems;

import org.usfirst.frc.team2383.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Brake extends Subsystem {
    
	Solenoid brake;
	
	public Brake(){
    	brake = new Solenoid(RobotMap.armBrake);

    }
    
    public void brake(){
    	brake.set(true);
    }
    
    
    public void release(){
    	brake.set(false);
    }
    
    public void initDefaultCommand() {
        brake.set(false);
    }
}

