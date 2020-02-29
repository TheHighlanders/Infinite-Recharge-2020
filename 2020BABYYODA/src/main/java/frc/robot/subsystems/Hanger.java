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

public class Hanger extends SubsystemBase {
  /**
   * Creates a new Hanger.
   */
  private WPI_TalonSRX Hanger1 = new WPI_TalonSRX(Constants.LEFT_HOOK);

  public Hanger() {

  }

  public void HangerUp(){
    Hanger1.set(0.1);
    DriverStation.reportWarning("Hanger Up", false);
  }

  public void HangerDown(){
    Hanger1.set(0.1);
    DriverStation.reportWarning("Hanger down", false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
