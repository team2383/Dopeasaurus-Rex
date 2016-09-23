
package org.usfirst.frc.team2383.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team2383.robot.auto.TestDrive;
import org.usfirst.frc.team2383.robot.commands.FlapOpen;
import org.usfirst.frc.team2383.robot.commands.ShiftLow;
import org.usfirst.frc.team2383.robot.commands.ShootFlap;
import org.usfirst.frc.team2383.robot.commands.ShooterBackward;
import org.usfirst.frc.team2383.robot.subsystems.Brake;
import org.usfirst.frc.team2383.robot.subsystems.Arm;
import org.usfirst.frc.team2383.robot.subsystems.Drivetrain;
import org.usfirst.frc.team2383.robot.subsystems.Feeder;
import org.usfirst.frc.team2383.robot.subsystems.Flap;
import org.usfirst.frc.team2383.robot.subsystems.Shifter;
import org.usfirst.frc.team2383.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {	
	
	// Subsystems
	
	public static Drivetrain drivetrain = new Drivetrain();
	public static Arm arm = new Arm();
	public static Feeder feeder = new Feeder();
	public static Shooter shooter = new Shooter();
	public static Flap flap = new Flap();
	public static Shifter shifter = new Shifter();
	public static Brake brake = new Brake();
	//public static ShooterHood shooterHood = new ShooterHood();
	//public static Vision vision = new Vision();
	public static OI oi = new OI();
	public static final Robot Robot = new Robot();
	
	Command autoCommand;
	SendableChooser autoChooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	//autonomousCommand = new AutoCommand();
    	//autoChooser = new SendableChooser();
		//autoChooser.addDefault("No auto", new TestCommand());
		
		//SmartDashboard.putData("Auto Chooser", autoChooser);
    	autoCommand = new TestDrive();
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){
    	drivetrain.tankDrive(0.0, 0.0);
    	shooter.ShooterStop();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	
	@Override
	public void autonomousInit() {
		 if (autoCommand != null) autoCommand.start();
		
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}
	
    public void teleopInit() {
    	//if (autoCommand != null) autoCommand.cancel();
    	shooter.ShooterStop();
		feeder.feederStop();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        drivetrain.arcadeDrive(oi.getLeftY(), oi.getRightX());
        if((oi.getLeftTrigger() == 1.0) || (oi.getLeftTrigger() == -1.0)){
        	drivetrain.drive.setMaxOutput(0.35);
        }
        else{drivetrain.drive.setMaxOutput(1.0);}
        SmartDashboard.putData("Arm", arm);
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
