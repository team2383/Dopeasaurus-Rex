package org.usfirst.frc.team2383.robot.subsystems;

import org.usfirst.frc.team2383.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Feeder extends Subsystem {
    
    CANTalon feeder;

    public Feeder(){
    	feeder = new CANTalon(RobotMap.feederMotor);
    }
    
    public void feederForward(){
    	feeder.set(-1.0);
    }
    
    public void feederBackward(){
    	feeder.set(1.0);
    }
    
    public void feederStop(){
    	feeder.set(0.0);
    }
    
    public void feedSlowOut(){
    	feeder.set(-0.6);
    }
    
    public void initDefaultCommand() {
        feeder.set(0.0);
    }
}

