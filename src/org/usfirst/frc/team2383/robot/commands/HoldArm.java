package org.usfirst.frc.team2383.robot.commands;

import  org.usfirst.frc.team2383.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class HoldArm extends Command {
	boolean set = false;

	public HoldArm() {
		super("Hold Arm");
		requires(Robot.arm);
	}

	@Override
	protected void initialize() {
		set = false;

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		if (!set) {
			Robot.arm.holdPosition();
			set = true;
		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
