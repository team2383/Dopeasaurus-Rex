package org.usfirst.frc.team2383.robot;

public class Constants {
	public static double inputExpo = 0.32;
	public static double inputDeadband = 0.05;
	
	public static double hoodRotationTolerance = 1.5 / 360.0;
	public static double hoodReverseLimit = 0.550; // 550 comp
	public static double hoodForwardLimit = 0.990; // 990 comp

	public static double hoodPositionP = 2.3; // 2.5
	public static double hoodPositionI = 0.005; // .02
	public static double hoodPositionD = 0.75; // .5
	public static double hoodPositionF = 0;
	public static int hoodPositionIZone = 40;
	
	public static double driveWheelDiameter = 7.15;
	public static double driveWheelCircumference = driveWheelDiameter * Math.PI;
	public static double driveInchesPerDegree = driveWheelCircumference / 360.0;
	public static double driveFeetPerDegree = driveInchesPerDegree / 12.0;
	public static double driveUpshiftFPSThreshold = 4.0;
	public static double driveDownshiftFPSThreshold = 3.0;

	public static double driveTurnTolerance = 0.54;
	public static double driveTurnP = 0.05; //0.05
	public static double driveTurnI = 0.010;
	public static double driveTurnD = 0.097;
	public static double driveTurnIZone = 7;
	public static double driveTurnVelocity = 0.95;

	public static double driveHeadingMaintainTolerance = 0.25;
	public static double driveHeadingMaintainP = 0.06;  //0.17
	public static double driveHeadingMaintainI = 0.0001;
	public static double driveHeadingMaintainD = 0.0;
	public static double driveHeadingMaintainF = 0;

	public static double drivePositionTolerance = 1.2;
	public static double drivePositionP = 0.3; //0.3
	public static double drivePositionI = 0.001;
	public static double drivePositionD = 0.250;
	public static double drivePositionF = 0;

	public static double driveHoldPositionP = 2.3;  //2.3
	public static double driveHoldPositionI = 0.0023;
	public static double driveHoldPositionD = 0.0;
	public static double driveHoldPositionF = 0;
	public static int driveHoldPositionIZone = 50;
	
	public static double driveMaxOutput = 1.0;
	
	public static double pidSetpointWait = 0.15;
	public static double navXResetDelay = 0.07; // seconds


}
