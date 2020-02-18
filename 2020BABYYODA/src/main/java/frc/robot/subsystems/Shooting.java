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

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import frc.robot.OI;
import edu.wpi.first.wpilibj.DriverStation;

public class Shooting extends SubsystemBase {
  /**
   * Creates a new Shooting.
   */
    private WPI_TalonSRX shootingMotor = new WPI_TalonSRX(Constants.SHOOTER);
    private double ramp = 0.2;
    public OI shooting_io;
    private double shootingSpeed = 0;


  public Shooting() {
    shootingMotor.configFactoryDefault();
    shootingMotor.setNeutralMode(NeutralMode.Brake);
    shootingMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 1000);
    shootingMotor.configNominalOutputForward(0);
    shootingMotor.configNominalOutputReverse(0);
    shootingMotor.configPeakOutputForward(1);
    shootingMotor.configPeakOutputReverse(-1);

    shootingMotor.config_kF(0, .07);
    shootingMotor.config_kP(0, .05);
    shootingMotor.config_kI(0, 0);
    shootingMotor.config_kD(0, 0);
    
    shooting_io = new OI();
  }

  public void ShootingLaunch(){
    
    //DriverStation.reportWarning("Bombs Away!" , false);
    //DriverStation.reportWarning("Shooting Speed:" + " " + this.shootingSpeed , false);
    // shootingMotor.set(ControlMode.PercentOutput, this.shootingSpeed/100);
    shootingMotor.set(ControlMode.Velocity, this.shootingSpeed * 10);
  }

  public void incrementShootSpeed()
  {
    this.shootingSpeed = this.shootingSpeed + 10;
    if(this.shootingSpeed > 100000)
    {
      this.shootingSpeed = 1;
    }
    //DriverStation.reportWarning("Shooting Speed:" + " " + this.shootingSpeed , false);
  }

  public void decrementShootSpeed()
  {
    this.shootingSpeed = this.shootingSpeed - 10;
    if(this.shootingSpeed < -100000)
    {
      this.shootingSpeed = -1;
    }
    //DriverStation.reportWarning("Shooting Speed:" + " " + this.shootingSpeed , false);
  }

  public void ShootingStop(){
    
    //DriverStation.reportWarning("Shooting has stopped", false);
    shootingMotor.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    int error = shootingMotor.getClosedLoopError(1);
    if(error != 0)
    {
      DriverStation.reportWarning("Error: " + error, false);
    }
    int position = shootingMotor.getSelectedSensorPosition();
    int velocity = shootingMotor.getSelectedSensorVelocity();
    DriverStation.reportWarning("Position: " + position + " Velocity: " + velocity, false);
  }
}
