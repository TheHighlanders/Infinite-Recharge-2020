/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DriverStation;

public class IntakeArm extends SubsystemBase {
  /**
   * Creates a new IntakeAuto.
   */
  private WPI_TalonSRX intakeArm = new WPI_TalonSRX(Constants.INTAKE_AUTO);

  public IntakeArm() {

  }
  public void ArmDown() {
    intakeArm.set(1);
    double armCurrent = intakeArm.getStatorCurrent();
    DriverStation.reportWarning("Arm Current: " + armCurrent, false);
    DriverStation.reportWarning("Arm down" , false);

  }
  
  public void ArmUp() {
    intakeArm.set(-1);
    double armCurrent = intakeArm.getStatorCurrent();
    DriverStation.reportWarning("Arm Current: " + armCurrent, false);
    DriverStation.reportWarning("Arm up" , false);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // double armCurrent = intakeArm.getStatorCurrent();
    // DriverStation.reportWarning("Arm Current: " + armCurrent, false);

  }
}
