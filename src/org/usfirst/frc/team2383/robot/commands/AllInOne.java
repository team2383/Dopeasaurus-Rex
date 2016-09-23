package org.usfirst.frc.team2383.robot.commands;

import org.usfirst.frc.team2383.robot.ninjaLib.Delay;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AllInOne extends CommandGroup {
    
    public  AllInOne() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	
    	addSequential(new ShootFlap());
    	/*
    	addParallel(new TeleopDrive());
    	addSequential(new FeederBackward());
    	addSequential(new WaitCommand(0.1));
    	addParallel(new TeleopDrive());
    	addSequential(new FeederStop());
    	addParallel(new TeleopDrive());
    	addSequential(new ShooterForward());
    	addParallel(new TeleopDrive());
    	addSequential(new WaitCommand(3.0));
    	
    	addParallel(new TeleopDrive());
    	addSequential(new FlapOpen());
    	addParallel(new TeleopDrive());
    	addSequential(new Delay(0.6));
    	addParallel(new TeleopDrive());
    	addSequential(new FeederForward());
    	addParallel(new TeleopDrive());
    	addSequential(new WaitCommand(1.0));
    	addParallel(new TeleopDrive());
    	addSequential(new FeederStop());
    	addParallel(new TeleopDrive());
    	addSequential(new ShooterStop());
    	addSequential(new FlapOpen());
    	*/
    	
    	

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
