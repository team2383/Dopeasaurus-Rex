package org.usfirst.frc.team2383.robot;

import java.util.function.DoubleSupplier;
import java.util.function.DoubleUnaryOperator;

import org.usfirst.frc.team2383.robot.commands.AllInOne;
import org.usfirst.frc.team2383.robot.commands.Brake;
import org.usfirst.frc.team2383.robot.commands.FeederBackward;
import org.usfirst.frc.team2383.robot.commands.FeederForward;
import org.usfirst.frc.team2383.robot.commands.FeederStop;
import org.usfirst.frc.team2383.robot.commands.FlapClosed;
import org.usfirst.frc.team2383.robot.commands.FlapOpen;
import org.usfirst.frc.team2383.robot.commands.MoveArm;
import org.usfirst.frc.team2383.robot.commands.Release;
import org.usfirst.frc.team2383.robot.commands.RetardedDrive;
import org.usfirst.frc.team2383.robot.commands.ShiftHigh;
import org.usfirst.frc.team2383.robot.commands.ShiftLow;
import org.usfirst.frc.team2383.robot.commands.ShootFlap;
import org.usfirst.frc.team2383.robot.commands.ShootFlapStop;
import org.usfirst.frc.team2383.robot.commands.ShooterBackward;

import org.usfirst.frc.team2383.robot.commands.ShooterForward;
import org.usfirst.frc.team2383.robot.commands.ShooterStop;
import org.usfirst.frc.team2383.robot.ninjaLib.DPadButton;
import org.usfirst.frc.team2383.robot.ninjaLib.DPadButton.Direction;

import org.usfirst.frc.team2383.robot.Constants;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //Joystick leftJoystick = new Joystick(0);
    //Joystick rightJoystick = new Joystick(1);
	static Joystick driver;
    static Joystick operator;

    public JoystickButton shooterForwardButton, shooterBackwardButton, feederForwardButton, feederBackwardButton,moveArm,highGear,lowGear,flapOpen, flapClosed, brake,release,shootFlap, clearCommand;
    
    private static DoubleUnaryOperator inputExpo = (x) -> {
		return Constants.inputExpo * Math.pow(x, 3) + (1 - Constants.inputExpo) * x;
	};

	private static DoubleUnaryOperator deadband = (x) -> {
		return Math.abs(x) > Constants.inputDeadband ? x : 0;
	};
	
	public static DoubleSupplier arm = () -> deadband.applyAsDouble(getArmMovement());
	
    
    public OI(){
    	this.driver = new Joystick(0);
    	this.operator = new Joystick(2);

        shooterForwardButton = new JoystickButton(operator,6); // 9
        shooterBackwardButton = new JoystickButton(operator,8); // 7
        feederForwardButton = new JoystickButton(operator,7);  //8
        feederBackwardButton = new JoystickButton(operator,5); //10
    	
        highGear = new JoystickButton(driver,6);
    	lowGear = new JoystickButton(driver,5);
        
    	clearCommand = new JoystickButton(driver,2);
    	
    	flapOpen = new JoystickButton(operator,11);
    	flapClosed = new JoystickButton(operator,12);
    	
    	brake = new JoystickButton(operator, 4);
    	release = new JoystickButton(operator,2);
    	
    	shootFlap = new JoystickButton(operator, 1);
    	
        moveArm = new JoystickButton(operator,3);
        
       
        moveArm.whileHeld(new MoveArm(OI.arm));
        
        
        
    	shooterForwardButton.whenPressed(new ShooterForward());
    	shooterForwardButton.whenReleased(new ShooterStop());
    	
    	shooterBackwardButton.whenPressed(new ShooterBackward());
    	shooterBackwardButton.whenReleased(new ShooterStop());

    	
    	highGear.whenPressed(new ShiftHigh());
    	lowGear.whenPressed(new ShiftLow());
    	
    	
    	feederForwardButton.whenPressed(new FeederForward());
    	feederForwardButton.whenReleased(new FeederStop());
    	
    	feederBackwardButton.whenPressed(new FeederBackward());
    	feederBackwardButton.whenReleased(new FeederStop());
    	
    	brake.whenPressed(new Brake());
    	release.whenPressed(new Release());
    
    	flapOpen.whenPressed(new FlapOpen());
    	flapClosed.whenPressed(new FlapClosed());
    	
    	//shootFlap.whileHeld(new AllInOne());
    	shootFlap.whileHeld(new ShootFlap());
    	shootFlap.whenInactive(new ShootFlapStop());
    }
    
    public double getLeftY(){
    	return   (-1 * driver.getRawAxis(1));
    }
    
    public double getRightX(){
    	return ( driver.getRawAxis(4));
    }
    
    public static double getArmMovement(){
    	return ( -1 * operator.getRawAxis(1));
    }
    
    public static double getLeftTrigger(){
		return (driver.getRawAxis(2));
    	
    }
    
}


