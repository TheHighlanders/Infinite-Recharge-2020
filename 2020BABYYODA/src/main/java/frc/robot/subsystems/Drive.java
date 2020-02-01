/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import frc.robot.Constants;
import frc.robot.OI;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;



public class Drive extends SubsystemBase {

  public WPI_TalonSRX left1;
  public WPI_TalonSRX left2;
  public WPI_TalonSRX right1;
  public WPI_TalonSRX right2;

  private double ramp = 0.2;
  public OI xbox_io;

  public Drive() {
    left1 = new WPI_TalonSRX(Constants.LEFT_WHEELS_1);
    left2 = new WPI_TalonSRX(Constants.LEFT_WHEELS_2);
    right1 = new WPI_TalonSRX(Constants.RIGHT_WHEELS_1);
    right2 = new WPI_TalonSRX(Constants.RIGHT_WHEELS_2);

    left1.configOpenloopRamp(ramp,0);
    left2.configOpenloopRamp(ramp,0);
    right1.configOpenloopRamp(ramp,0);
    right2.configOpenloopRamp(ramp,0); 

    left1.setNeutralMode(NeutralMode.Coast);
    right1.setNeutralMode(NeutralMode.Coast);

    xbox_io = new OI();


  }
  public void drivePower(double left_power, double right_power){
    left1.set(left_power);
    left2.set(left_power);
    
    right1.set(right_power);
    right2.set(right_power);
    // DriverStation.reportWarning("Left Y:" + " " + left_power + "and Right Y: " + right_power , false);



  }
  public void stopPower(){
   drivePower(0,0); 
  }

  @Override
  public void periodic() {


    /*
    double leftYJoy = this.xbox_io.getXboxLeftY();
    double rightYJoy = this.xbox_io.getXboxRightY();

    double adjusted_leftYJoy = -Math.pow(leftYJoy,3);
    double adjusted_rightYJoy = Math.pow(rightYJoy,3);

    drivePower(adjusted_leftYJoy, adjusted_rightYJoy);



    DriverStation.reportWarning("Left Y:" + " " + leftYJoy + "and Right Y: " + rightYJoy , false);
    DriverStation.reportWarning("Adjusted Left Y:" + " " + adjusted_leftYJoy + "and Adjusted Right Y: " + adjusted_rightYJoy , false);

    **/

  }
}
