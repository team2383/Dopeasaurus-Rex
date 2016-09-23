package org.usfirst.frc.team2383.robot.commands;

import org.usfirst.frc.team2383.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 */
public class ShootFlapStop extends Command {

	 public ShootFlapStop() {
	    	super("ShootFlapStop");
	    }

	    // Called just before this Command runs the first time
	    protected void initialize() {
	    	System.out.println("Shooter is stopping cycle!");
	    }

	    // Called repeatedly when this Command is scheduled to run
	    protected void execute() {
	    	Scheduler.getInstance().removeAll();
	    }

	    // Make this return true when this Command no longer needs to run execute()
	    protected boolean isFinished() {
	        return false;
	    }

	    // Called once after isFinished returns true
	    protected void end() {
	    	System.out.println("FEEDER IS STOPPED BROOOOOOOOOOOO");
	    }

	    // Called when another command which requires one or more of the same
	    // subsystems is scheduled to run
	    protected void interrupted() {
	    }
}
