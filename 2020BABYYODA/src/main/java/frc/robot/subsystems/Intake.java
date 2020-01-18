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
import com.ctre.phoenix.motorcontrol.NeutralMode;
import frc.robot.OI;
import frc.robot.commands.ShootingCommand;
import edu.wpi.first.hal.sim.DriverStationSim;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DriverStation;

public class Intake extends SubsystemBase {
  /**
   * Creates a new Intake.
   */

  private WPI_TalonSRX intakeMotor = new WPI_TalonSRX(Constants.INTAKE);
  private double ramp = 0.2;
  public OI intake_io;

  
  public Intake() {

    intakeMotor.configOpenloopRamp(ramp,0);
    intakeMotor.setNeutralMode(NeutralMode.Brake);

    intake_io = new OI();

  }

  public void IntakeMaxSpeed() {
    intakeMotor.set(1);
    DriverStation.reportWarning("Ready to Fire!" , false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
