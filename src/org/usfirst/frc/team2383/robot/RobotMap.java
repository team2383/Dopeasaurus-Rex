package org.usfirst.frc.team2383.robot;



import org.usfirst.frc.team2383.robot.subsystems.Drivetrain;
import org.usfirst.frc.team2383.robot.subsystems.Feeder;
import org.usfirst.frc.team2383.robot.subsystems.Shooter;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
		// CANTalon 
		public static int rightFront = 0; 
		public static int rightMiddle = 1;
		public static int rightRear = 2; 
		
		
		public static int leftFront = 3;
		public static int leftMiddle = 4;
		public static int leftRear = 5;
		


		
		public static int armLeftMotor = 7;
		public static int armRightMotor = 6;
		public static int shooterMotor = 8;
		public static int feederMotor = 9;
		

		// Solenoids
		// not final ports
		public static int shifter = 3;
		public static int armBrake = 2;
		public static int flap = 1;
		

		//Sensors

		public static PowerDistributionPanel PDP = new PowerDistributionPanel(4);
		public static AHRS navX = new AHRS(SPI.Port.kMXP);

		
		
		
} 
