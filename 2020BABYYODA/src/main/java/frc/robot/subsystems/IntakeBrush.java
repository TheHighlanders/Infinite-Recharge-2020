/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DriverStation;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class IntakeBrush extends SubsystemBase {
  /**
   * Creates a new IntakeBrush.
   */
    public WPI_TalonSRX brush = new WPI_TalonSRX(Constants.INTAKE_BRUSH);
    private double ramp = 0.2;
  public IntakeBrush() {
    brush.configOpenloopRamp(ramp,0);
    brush.setNeutralMode(NeutralMode.Brake);

  }

  public void IntakeBrushIN(){
    brush.set(1);
  }

  public void IntakeBrushOUT(){
    brush.set(-1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
