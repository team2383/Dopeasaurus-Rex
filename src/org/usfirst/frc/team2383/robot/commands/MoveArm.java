package org.usfirst.frc.team2383.robot.commands;

import java.util.function.DoubleSupplier;

import org.usfirst.frc.team2383.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class MoveArm extends Command {
	private final DoubleSupplier armPower;

	public MoveArm(DoubleSupplier armPower) {
		super("Move Arm");
		requires(Robot.arm);
		this.armPower = armPower;
	}

	public MoveArm(DoubleSupplier armPower, double timeout) {
		super("Move Hood", timeout);
		requires(Robot.arm);
		this.armPower = armPower;
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		
		Robot.arm.moveAtSpeed(armPower.getAsDouble());
	}

	@Override
	protected boolean isFinished() {
		return this.isTimedOut();
	}

	@Override
	protected void end() {
		Robot.arm.stop();
	}

	@Override
	protected void interrupted() {
		Robot.arm.stop();
	}
	
}




