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

  public WPI_TalonSRX left;
  public WPI_TalonSRX right;

  private double ramp = 0.2;
  public OI xbox_io;

  public Drive() {
    left = new WPI_TalonSRX(Constants.LEFT_WHEELS);
    right = new WPI_TalonSRX(Constants.RIGHT_WHEELS);

    left.configOpenloopRamp(ramp,0);
    right.configOpenloopRamp(ramp,0);
     
    left.setNeutralMode(NeutralMode.Coast);
    right.setNeutralMode(NeutralMode.Coast);

    xbox_io = new OI();


  }
  public void drivePower(double left_power, double right_power){
    left.set(left_power);
    right.set(right_power);

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
