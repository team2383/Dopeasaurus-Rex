package org.usfirst.frc.team2383.robot.commands;

import org.usfirst.frc.team2383.robot.OI;
import org.usfirst.frc.team2383.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */


public class ShootFlap extends Command {
	public OI oi;
    public ShootFlap() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.flap);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	/*
    	System.out.println("Shooter is cycling !");
    	Robot.feeder.feederBackward();
    	Timer.delay(0.1);
    	Robot.feeder.feederStop();
    	Robot.shooter.ShooterBackward();
    	Timer.delay(3.0);
    	*/
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("Shooter is cycling !");
    	Robot.feeder.feederBackward();
    	Timer.delay(0.1);
    	Robot.feeder.feederStop();	
    	Robot.flap.flapUp();
        Timer.delay(0.6);
        Robot.feeder.feederForward();
        Timer.delay(1);
        Robot.feeder.feederStop();
    			
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.ShooterStop();
    	Robot.feeder.feederStop();
    	Robot.flap.flapUp();
    	cancel();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void stop() {
    	if(oi.shootFlap.get() == false){
        	cancel();
    	}
    }

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		cancel();	
	}
}
