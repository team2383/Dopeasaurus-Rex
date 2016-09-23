package org.usfirst.frc.team2383.robot.commands;

import org.usfirst.frc.team2383.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FlapOpen extends Command {

	public	FlapOpen() {
    	super("FlapOpen");
        requires(Robot.flap);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("flapping up!");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.flap.flapUp();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
