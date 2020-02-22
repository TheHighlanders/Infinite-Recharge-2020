/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DriverStation;

public class Hook extends SubsystemBase {

  private WPI_TalonSRX HookLeft = new WPI_TalonSRX(Constants.HOOK_LEFT);
  private WPI_TalonSRX HookRight = new WPI_TalonSRX(Constants.HOOK_RIGHT);

  public Hook() {

  }

  public void HookPower(double Hook_left_power, double Hook_right_power){
    HookLeft.set(Hook_left_power);
    HookRight.set(Hook_right_power);
    DriverStation.reportWarning("Left Y:" + " " + Hook_left_power + "and Right Y: " + Hook_right_power , false);

  }

  /*
    Hanging for the Left Side
  */
  public void HookUpLeft(){
    HookLeft.set(0.3);
  }
  
  public void HookDownLeft(){
    HookLeft.set(-0.3);
  }
  
  public void HookStopLeft(){
    HookLeft.set(0);
  }

  /*
    Hanging for the Right Side
  */
  public void HookUpRight(){
    HookRight.set(0.3);
  }

  public void HookDownRight(){
    HookRight.set(-0.3);
  }

  public void HangerStopRight(){
    HookRight.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
