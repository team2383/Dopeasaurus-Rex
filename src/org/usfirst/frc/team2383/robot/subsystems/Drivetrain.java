package org.usfirst.frc.team2383.robot.subsystems;


import org.usfirst.frc.team2383.robot.Constants;
import org.usfirst.frc.team2383.robot.Robot;
import org.usfirst.frc.team2383.robot.RobotMap;



import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDeviceStatus;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *	Drivetrain Subsystem
 */
public class Drivetrain extends Subsystem implements PIDSource{
    
    CANTalon leftFront, leftRear,leftMiddle, rightFront, rightRear,rightMiddle;
    
   // public double maxOutput = 1.0;
    public RobotDrive drive;
    
    
    public enum Gear {
		LOW, HIGH;

		@Override
		public String toString() {
			return super.toString().toLowerCase();
		}
	}
    
    public Drivetrain(){
    	super("Drivetrain");
    	
    	this.leftFront = new CANTalon(RobotMap.leftFront);
    	this.leftRear = new CANTalon(RobotMap.leftRear);
    	this.leftMiddle = new CANTalon(RobotMap.leftMiddle);
    	this.rightFront = new CANTalon(RobotMap.rightFront);
    	this.rightRear = new CANTalon(RobotMap.rightRear);
    	this.rightMiddle = new CANTalon(RobotMap.rightMiddle);
    	

    	leftMiddle.changeControlMode(CANTalon.TalonControlMode.Follower);
    	leftMiddle.set(leftRear.getDeviceID());
    	
		rightMiddle.changeControlMode(CANTalon.TalonControlMode.Follower);
		rightMiddle.set(rightRear.getDeviceID());

		
		leftRear.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		leftRear.setPID(Constants.driveHoldPositionP, Constants.driveHoldPositionI, Constants.driveHoldPositionD,
				Constants.driveHoldPositionF, Constants.driveHoldPositionIZone, 0, 1);
		
		rightRear.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		rightRear.setPID(Constants.driveHoldPositionP, Constants.driveHoldPositionI, Constants.driveHoldPositionD,
				Constants.driveHoldPositionF, Constants.driveHoldPositionIZone, 0, 1);
	

    	this.drive = new RobotDrive(leftFront, leftRear, rightFront, rightRear);
    	this.drive.setMaxOutput(1.0);
		drive.setSafetyEnabled(false);	
    }
    
    public void tankDrive(double left, double right){
    	drive.tankDrive(left, right);
    }
	
    public void arcadeDrive(double leftY,double rightX){
    	drive.arcadeDrive(leftY, rightX);
    }

	
	public void setEncPosition(int encoderPosition) {
		leftFront.setEncPosition(encoderPosition);
		leftMiddle.setEncPosition(encoderPosition);
		leftRear.setEncPosition(encoderPosition);
		rightFront.setEncPosition(encoderPosition);
		rightMiddle.setEncPosition(encoderPosition);
		rightRear.setEncPosition(encoderPosition);
	}
	
	public void resetEncoders() {
		leftFront.setPosition(0);
		rightFront.setPosition(0);
	}
	
	public double getRotations() {
		double rotations;
		if (leftFront.isSensorPresent(
				FeedbackDevice.CtreMagEncoder_Relative) == FeedbackDeviceStatus.FeedbackStatusNotPresent)
			return 0;
		if (rightFront.isSensorPresent(
				FeedbackDevice.CtreMagEncoder_Relative) == FeedbackDeviceStatus.FeedbackStatusNotPresent)
			return 0;
		try {
			rotations = (leftFront.getPosition() + rightFront.getPosition()) / 2.0;
		} catch (Throwable e) {
			System.out.println("Failed to get encoder rotations of drivetrain");
			rotations = 0;
		}
		return rotations;
	}

	public double getVelocity() {
		double rotations;
		if (leftFront.isSensorPresent(
				FeedbackDevice.CtreMagEncoder_Relative) == FeedbackDeviceStatus.FeedbackStatusNotPresent)
			return 0;
		if (rightFront.isSensorPresent(
				FeedbackDevice.CtreMagEncoder_Relative) == FeedbackDeviceStatus.FeedbackStatusNotPresent)
			return 0;
		try {
			rotations = (leftFront.getSpeed() + rightFront.getSpeed()) / 2.0;
		} catch (Throwable e) {
			System.out.println("Failed to get encoder rotations of drivetrain");
			rotations = 0;
		}
		return rotations;
	}

	public double getInches() {
		return getRotations() * Constants.driveWheelCircumference;
	}

	// Feet per Seconds
	public double getSpeed() {
		return getVelocity() * Constants.driveWheelCircumference / 12.0 / 60.0;
	}
	
	public CANTalon getLeftRear() {
		return leftRear;
	}
	
	public CANTalon getRightRear() {
		return rightRear;
	}
	
	public CANTalon getLeftFront() {
		return leftFront;
	}
	
	public CANTalon getRightFront() {
		return rightFront;
	}
	
	public CANTalon getLeftMiddle() {
		return leftMiddle;
	}
	
	public CANTalon getRightMiddle() {
		return rightMiddle;
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	
	public void holdPosition() {
		leftFront.setProfile(1);
		leftFront.changeControlMode(TalonControlMode.Position);
		leftFront.setSetpoint(leftFront.getPosition());

		rightFront.setProfile(1);
		rightFront.changeControlMode(TalonControlMode.Position);
		rightFront.setSetpoint(rightFront.getPosition());
	}
	
	public Gear getGear() {
		 if(Robot.shifter.isHigh()) {
			return Gear.HIGH;
		 }
		 else
			return Gear.LOW;
		}
	
	public void shiftTo(Gear gear) {
		switch (gear) {
		default:
		case HIGH:
			enableBrake();
			Robot.shifter.shiftHigh();
			break;
		case LOW:
			disableBrake();
			Robot.shifter.shiftLow();
			break;
		}
	}
	
	public void setBrake(boolean brake) {
		leftFront.enableBrakeMode(brake);
		leftRear.enableBrakeMode(brake);
		rightFront.enableBrakeMode(brake);
		rightRear.enableBrakeMode(brake);
		rightMiddle.enableBrakeMode(brake);
		leftMiddle.enableBrakeMode(brake);
	}

	public void enableBrake() {
		setBrake(true);
	}

	public void disableBrake() {
		setBrake(false);
	}

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double pidGet() {
		// TODO Auto-generated method stub
		return getInches();
	}
	
}

