/*package org.usfirst.frc.team2383.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Vision extends Subsystem{
	NetworkTable gripTable;
	
	int gripTolerance;
								  // image dimensions: 640 x 480
	int imageCenterX;             // 320
	int imageCenterY;             // 240
	
	double cameraFOV;                // depends on camera
	double azimuth;               // degrees the robot would have to turn to center target to image
    double target;
    
	double[] gripValues;
	
	public Vision(){
    	update();
    	
    	imageCenterX = 320;
    	imageCenterY = 240;
    	gripTolerance = 3;
	}
	
	public double[] update(){
		gripTable = NetworkTable.getTable("GRIP/myContoursReport");
		
		
		double[] centerX = {};
		double[] centerY = {};
		centerX = gripTable.getNumberArray("centerX", centerX);
		
		SmartDashboard.putString("centerX", centerX.toString());
		SmartDashboard.putNumber("Top Azimuth", getTopAzimuth());
		SmartDashboard.putNumber("Left Azimuth", getLeftAzimuth());
		SmartDashboard.putNumber("Right Azimuth", getRightAzimuth());
		try
		{
			if((centerX[0] + gripTolerance > imageCenterX) && (centerX[0] - gripTolerance < imageCenterX)) {
				SmartDashboard.putBoolean("Shot Ready", true);
			}
			else {
				SmartDashboard.putBoolean("Shot Ready", false);
			}
		}
		catch (Exception e){SmartDashboard.putString("Shot Ready", "error: no goal");}
		
		return centerX;
	}
	
	public double getTopTarget(){
		double[] updatedValues;
		updatedValues = update();
		
		try
		{
			target = updatedValues[0];
		}
		catch (Exception e){SmartDashboard.putBoolean("Is goal visible?", false);}
		
		return target;
	}
	
	public double getLeftTarget(){
		double[] updatedValues;
		updatedValues = update();
		
		try
		{
			target = updatedValues[2];
		}
		catch (Exception e){SmartDashboard.putBoolean("Is goal visible?", false);}
		
		return target;
	}
	
	public double getRightTarget(){
		double[] updatedValues;
		updatedValues = update();
		
		try
		{
			target = updatedValues[1];
		}
		catch (Exception e){SmartDashboard.putBoolean("Is goal visible?", false);}
		
		return target;
	}
	
	public double getTopAzimuth(){
		double[] updatedValues;
		updatedValues = update();
		target = getTopTarget();
		try
		{
			azimuth = cameraFOV * (imageCenterX - target);
		}
		catch (Exception e){SmartDashboard.putBoolean("Is goal visible?", false);}
		
		return azimuth;
	}
	
	public double getLeftAzimuth(){
		double[] updatedValues;
		updatedValues = update();
		target = getLeftTarget();
		try
		{
			azimuth = cameraFOV * (imageCenterX - target);
		}
		catch (Exception e){SmartDashboard.putBoolean("Is goal visible?", false);}
		
		return azimuth;
	}
	
	public double getRightAzimuth(){
		double[] updatedValues;
		updatedValues = update();
		target = getRightTarget();
		try
		{
			azimuth = cameraFOV * (imageCenterX - target);
		}
		catch (Exception e){SmartDashboard.putBoolean("Is goal visible?", false);}
		
		return azimuth;
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		update();
	}
	
}*/