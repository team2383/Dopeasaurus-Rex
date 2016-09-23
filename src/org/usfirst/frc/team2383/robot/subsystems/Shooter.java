package org.usfirst.frc.team2383.robot.subsystems;

import org.usfirst.frc.team2383.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
    
    CANTalon shooter;
    
    public Shooter(){
    	shooter = new CANTalon(RobotMap.shooterMotor);
    	shooter.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);

    }
    
    public void ShooterForward(){
    	shooter.set(-1.0);
    }
    
    
    public void ShooterBackward(){
    	shooter.set(1.0);
    }
    
    public void ShooterStop(){
    	shooter.set(0.0);
    }
    
    public void ShooterSlow(){
    	shooter.set(0.8);
    }
    public void initDefaultCommand() {
        shooter.set(0.0);
    }
}

