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
import edu.wpi.first.hal.sim.DriverStationSim;
import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.subsystems.Conveyor;

public class Shooting extends SubsystemBase {
  /**
   * Creates a new Shooting.
   */
    private WPI_TalonSRX shootingMotor = new WPI_TalonSRX(Constants.SHOOTER);
    private double ramp = 0.2;
    public OI shooting_io;
    private final Conveyor m_Conveyor = new Conveyor();


  public Shooting() {

    shootingMotor.configOpenloopRamp(ramp,0);
    shootingMotor.setNeutralMode(NeutralMode.Brake);
    
    shooting_io = new OI();
  }

  public void ShootingLaunch(){
    shootingMotor.set(1);
    DriverStation.reportWarning("Bombs Away!" , false);
    m_Conveyor.ConveyorMaxIN();
  }

  public void ShootingStop(){
    shootingMotor.set(0);
    DriverStation.reportWarning("Shooting has stopped", false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    


  }
}
