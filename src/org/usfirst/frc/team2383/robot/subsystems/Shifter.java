package org.usfirst.frc.team2383.robot.subsystems;

import org.usfirst.frc.team2383.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shifter extends Subsystem {
    
	Solenoid shifter;
	
	public Shifter(){
    	shifter = new Solenoid(RobotMap.shifter);

    }
    
    public void shiftHigh(){
    	shifter.set(true);
    }
    
    
    public void shiftLow(){
    	shifter.set(false);
    }
    
    public void initDefaultCommand() {
        shifter.set(false);
    }
    
    public boolean isHigh(){
    	return shifter.get();
    }
}

