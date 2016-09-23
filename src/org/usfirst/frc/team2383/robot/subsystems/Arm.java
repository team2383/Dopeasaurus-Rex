package org.usfirst.frc.team2383.robot.subsystems;



import java.util.function.DoubleUnaryOperator;

import org.usfirst.frc.team2383.robot.RobotMap;

import org.usfirst.frc.team2383.robot.Constants;
import org.usfirst.frc.team2383.robot.commands.HoldArm;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Arm extends Subsystem {
    
    CANTalon ArmLeft;
    CANTalon ArmRight;

	public DoubleUnaryOperator mapToZero = (x) -> x - Constants.hoodReverseLimit;
	public DoubleUnaryOperator mapToRaw = (x) -> x + Constants.hoodReverseLimit;

	public Arm() {
		ArmLeft = new CANTalon(RobotMap.armLeftMotor);
		ArmRight = new CANTalon(RobotMap.armRightMotor);
		ArmLeft.enableBrakeMode(true);
		//Hood.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
		ArmLeft.changeControlMode(TalonControlMode.Position);
		//ArmLeft.setPID(Constants.hoodPositionP, Constants.hoodPositionI, Constants.hoodPositionD,
				//Constants.hoodPositionF, Constants.hoodPositionIZone, 0, 0);
		//ArmLeft.setReverseSoftLimit(Constants.hoodReverseLimit);
		//ArmLeft.setForwardSoftLimit(Constants.hoodForwardLimit);
		//ArmLeft.enableForwardSoftLimit(false);
		//ArmLeft.enableReverseSoftLimit(false);
		//ArmLeft.configPeakOutputVoltage(6.0, -6.0);
		//ArmLeft.reverseOutput(false);
		//ArmLeft.reverseSensor(false);
		
		ArmRight.changeControlMode(TalonControlMode.Position);
		//SmartDashboard.putData("Hood", Hood);
	}

	public void moveAtSpeed(double speed) {
		ArmLeft.changeControlMode(TalonControlMode.PercentVbus);
		ArmRight.changeControlMode(TalonControlMode.PercentVbus);
		//ArmRight.set(ArmLeft.getDeviceID());
		ArmLeft.set(speed);
		ArmRight.set(speed);
	}

	public void holdPosition() {
		this.setRawRotations(this.getRawRotations());
	}

	public boolean isAtSetpoint() {
		return Math.abs(getRawRotations() - getRawSetpoint()) <= Constants.hoodRotationTolerance;
	}

	public void setRotations(double rotations) {
		setRawRotations(mapToRaw.applyAsDouble(rotations));
	}

	public void setRawRotations(double rotations) {
		ArmLeft.changeControlMode(TalonControlMode.Position);
		ArmRight.changeControlMode(TalonControlMode.Follower);
		ArmLeft.setSetpoint(rotations);
		//ArmRight.setSetpoint(rotations);
	}

	public double getRotations() {
		return mapToZero.applyAsDouble(getRawRotations());
	}

	public double getSetpoint() {
		return mapToZero.applyAsDouble(getRawSetpoint());
	}

	public double getRawSetpoint() {
		return ArmLeft.getSetpoint();
	}

	public double getRawRotations() {
		return ArmLeft.getPosition();
	}

	
	public void stop() {
		ArmLeft.changeControlMode(TalonControlMode.PercentVbus);
		ArmRight.changeControlMode(TalonControlMode.PercentVbus);
		ArmLeft.set(0.0);
		ArmRight.set(0.0);//added stop
	}
	/*
	public void HoodForward(){
		Hood.changeControlMode(TalonControlMode.PercentVbus);
    	Hood.set(0.4);
    }
    
    
    public void ShooterBackward(){
    	Hood.changeControlMode(TalonControlMode.PercentVbus);
    	Hood.set(-0.4);
    }
	*/
	
	public void armUp(){
		ArmLeft.changeControlMode(TalonControlMode.PercentVbus);
		ArmRight.changeControlMode(TalonControlMode.PercentVbus);
		ArmLeft.set(0.8);
		ArmRight.set(0.8);
	}
	
	@Override
	protected void initDefaultCommand() {
		ArmLeft.changeControlMode(TalonControlMode.PercentVbus);
		ArmRight.changeControlMode(TalonControlMode.PercentVbus);
		ArmLeft.set(0.0);
		ArmRight.set(0.0);
	}
}
