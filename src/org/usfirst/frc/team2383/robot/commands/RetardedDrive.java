package org.usfirst.frc.team2383.robot.commands;

import org.usfirst.frc.team2383.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RetardedDrive extends Command {
	public RetardedDrive() {
		this("RetardedDrive");
	}
	
	public RetardedDrive(String name) {
		super(name);
		requires(Robot.drivetrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	// todo: add gyro code
	protected void execute() {
		double x = Robot.oi.getRightX();
		double y = Robot.oi.getLeftY();
		
		//make stick inputs less sensitive near center
		Robot.drivetrain.arcadeDrive(y, x);
		
		//Robot.drivetrain.maxOutput = 0.5;
		//Robot.drivetrain.drive.setMaxOutput(0.5);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}
	
	


	// Called once after isFinished returns true
	protected void end() {}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {}
}
