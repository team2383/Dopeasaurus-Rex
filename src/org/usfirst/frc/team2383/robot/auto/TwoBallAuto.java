package org.usfirst.frc.team2383.robot.auto;

import org.usfirst.frc.team2383.robot.Robot;
import org.usfirst.frc.team2383.robot.commands.DriveStraight;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TwoBallAuto extends Command {

    public TwoBallAuto() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.flap);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/*
    	 * 1st cycle
    	 */
    	Robot.brake.release();
    	Robot.feeder.feederBackward();
    	Timer.delay(0.1);
    	Robot.feeder.feederStop();
    	Robot.shooter.ShooterBackward();
    	Robot.drivetrain.arcadeDrive(1.0, 0.0);
    	Timer.delay(3);
    	Robot.drivetrain.tankDrive(0.0, 0.0);
    	Timer.delay(0.4);
    	Robot.drivetrain.arcadeDrive(0.0, 0.6); 
    	Timer.delay(0.5);						// change angle on turn toward goal
    	Robot.drivetrain.tankDrive(0, 0);
    	Robot.brake.brake();
    	Robot.arm.armUp();
    	Timer.delay(0.7);
    	Robot.arm.stop();
    	Robot.flap.flapUp();
    	Timer.delay(0.6);
    	Robot.feeder.feederForward();
    	Timer.delay(0.5);
    	Robot.feeder.feederStop();
    	Robot.shooter.ShooterStop();
    	Robot.flap.flapDown();
    	Robot.brake.release();
    	Timer.delay(0.5);
    	
    	Timer.delay(10);
    	
    	/*
    	 * Reset
    
    	Robot.drivetrain.arcadeDrive(0.0, -0.6);
    	Timer.delay(0.7);
    	Robot.drivetrain.tankDrive(0.0, 0.0);
    	Robot.drivetrain.arcadeDrive(-1.0, 0.0);
    	Timer.delay(2.5);
    	Robot.drivetrain.tankDrive(0.0, 0.0);
    	Robot.feeder.feederForward();
    	Timer.delay(0.7);
    	Robot.feeder.feederStop();
    	
    	
    	Robot.drivetrain.arcadeDrive(0.6, 0.0);
    	Timer.delay(5);
    	Robot.drivetrain.tankDrive(0.0, 0.0);
    	Timer.delay(0.4);
    	Robot.drivetrain.arcadeDrive(0.0, 0.4);
    	Timer.delay(0.4);
    	Robot.drivetrain.tankDrive(0, 0);
    	Robot.shooter.ShooterBackward();
    	Robot.brake.brake();
    	Robot.arm.armUp();
    	Timer.delay(0.4);
    	Robot.arm.stop();
    	Robot.flap.flapUp();
    	Timer.delay(0.3);
    	Robot.feeder.feederBackward();
    	Timer.delay(0.2);
    	Robot.feeder.feederStop();
    	Robot.feeder.feederForward();
    	Timer.delay(0.5);
    	Robot.feeder.feederStop();
    	Robot.shooter.ShooterStop();
    	Robot.flap.flapDown();
    	Robot.brake.release();   	
    	*/
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
