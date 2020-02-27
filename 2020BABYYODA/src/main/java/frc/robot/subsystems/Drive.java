/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.OI;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;


import edu.wpi.first.wpilibj.controller.PIDController;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;

import edu.wpi.first.wpilibj.DriverStation;

public class Drive extends SubsystemBase {

  public WPI_TalonSRX left1;
  public WPI_VictorSPX left2;
  public WPI_TalonSRX right1;
  public WPI_VictorSPX right2;

  private double ramp = 0.2;
  public OI xbox_io;

  private ADXRS450_Gyro gyro = new ADXRS450_Gyro();

  public static double kI, kP, kD, kF;
  private PIDController DrivePIDController;

  public Drive() {

    left1 = new WPI_TalonSRX(Constants.LEFT_WHEELS_2);
    left2 = new WPI_VictorSPX(Constants.LEFT_WHEELS_1);
    right1 = new WPI_TalonSRX(Constants.RIGHT_WHEELS_2);
    right2 = new WPI_VictorSPX(Constants.RIGHT_WHEELS_1);

    left1.configOpenloopRamp(ramp,0);
    left2.configOpenloopRamp(ramp,0);
    right1.configOpenloopRamp(ramp,0);
    right2.configOpenloopRamp(ramp,0);
     
    left1.setNeutralMode(NeutralMode.Coast);
    left2.setNeutralMode(NeutralMode.Coast);
    right1.setNeutralMode(NeutralMode.Coast);
    right2.setNeutralMode(NeutralMode.Coast);

    left1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
    right1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);

    // kP = 0; // Fill this in
    // kI = 0;
    // kD = 0;
    // kF = 0;

    // left1.config_kP(0, kP);
    // left1.config_kI(0, kI);
    // left1.config_kD(0, kD);
    // left1.config_kF(0, kF);

    xbox_io = new OI();

    left2.follow(left1);
    right2.follow(right1);

  }
  public void drivePower(double left_power, double right_power){

    // left1.set(ControlMode.PercentOutput, left_power); //Add encoders
    // left2.set(left_power); no need since follow
    // right1.set(right_power); // Add Encoder
    // right2.set(left_power); no need since follow

    // DriverStation.reportWarning("Left Y:" + " " + left_power + "and Right Y: " + right_power , false);
    left1.set(left_power);
    left2.set(left_power);
    right1.set(right_power);
    right2.set(right_power);
    // DriverStation.reportWarning("Left Y:" + " " + left_power + "and Right Y: " + right_power , false);

  }
  public void stopPower(){
   drivePower(0,0); 
  }

      /**
	 * Calibrates gyro (takes 5 seconds while robot does nothing) Do this when
	 * robot first turns on.
	 */
  public void calibrateGyro() {
    	
    gyro.calibrate();
    
  }
  public void resetGyro() {
    	
    gyro.reset();
    
  }
    /**
	 * @return the current rate of turning in degrees per second
	 */
  public double getGyroRate() {
    	
    return gyro.getRate();
    
  }
  
  /**
   * 
   * @return gets an approximation of the gyro angle since reset was last
   *         called from an accumulation using the FPGA. Will accumulate error
   *         over time.
   * 
   */
  public double getGyroAngle() {
    
    return gyro.getAngle();
    
  }

  /**
	 * Sets the drivetrain encoders back to 0 pulses
	 * Only one message will print here
	 * Leave this at -3000?
	 */
  public void setEncoders(int pulses){
    // left1.getSensorCollection().setPulseWidthPosition(pulses, 0);
    // right1.getSensorCollection().setPulseWidthPosition(pulses, 0);

  }

      
  /**
	 * 
	 * @return gets an approximation of the distance traveled in inches
	 *         since reset was last called. Will accumulate error
	 *         over time.
	 * 
	 */
  public double getDistanceTraveled() {
    DriverStation.reportWarning("Left:" + (-(left1.getSensorCollection().getPulseWidthPosition())) + " Right: " + right1.getSensorCollection().getPulseWidthPosition(), false);
    return -((double) left1.getSensorCollection().getPulseWidthPosition() / 4096.0) * 6 * Math.PI;
  }

  public void setPositionAUTO(double leftdistance){
    left1.set(ControlMode.Position, leftdistance/Constants.INCHES_PER_ROTATION); // Only one encoder the others can't keep up
    // right1.set(ControlMode.Position, rightdistance/Constants.INCHES_PER_ROTATION); 
  }


  @Override
  public void periodic() {
    // DriverStation.reportWarning("Left PID: " + left1.getSelectedSensorPosition(), false);

    // SmartDashboard.putNumber("PID Output", output);

    /*
    double leftYJoy = this.xbox_io.getXboxLeftY();
    double rightYJoy = this.xbox_io.getXboxRightY();

    double adjusted_leftYJoy = -Math.pow(leftYJoy,3);
    double adjusted_rightYJoy = Math.pow(rightYJoy,3);

    drivePower(adjusted_leftYJoy, adjusted_rightYJoy);
    
    DriverStation.reportWarning("Left Y:" + " " + leftYJoy + "and Right Y: " + rightYJoy , false);
    DriverStation.reportWarning("Adjusted Left Y:" + " " + adjusted_leftYJoy + "and Adjusted Right Y: " + adjusted_rightYJoy , false);

    **/
    getDistanceTraveled();
  }
}
