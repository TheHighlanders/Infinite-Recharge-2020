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

public class Shooting extends SubsystemBase {
  /**
   * Creates a new Shooting.
   */
    private WPI_TalonSRX shootingMotor = new WPI_TalonSRX(Constants.SHOOTER);
    private double ramp = 0.5;
    public OI shooting_io;

  public Shooting() {

    shootingMotor.configOpenloopRamp(ramp,0);
    shootingMotor.setNeutralMode(NeutralMode.Brake);

    shooting_io = new OI();
  }

  public void ShootingLaunch(){
    shootingMotor.set(1);
    DriverStation.reportWarning("Bombs Away!" , false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    


  }
}
