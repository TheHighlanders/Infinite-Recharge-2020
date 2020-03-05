/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.DriverStation;

import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Door extends SubsystemBase {
  /**
   * Creates a new IntakeBrush.
   */
    public WPI_TalonSRX door = new WPI_TalonSRX(Constants.DOOR);
    
    private double ramp = 0.2;

  public Door() {
    door.configFactoryDefault();

    door.configOpenloopRamp(ramp,0);
    door.setNeutralMode(NeutralMode.Brake);

    
    door.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 1000);

    door.setSelectedSensorPosition(0);

  }
  public int DoorPos(){
    return door.getSelectedSensorPosition();
  }

  public void DoorOpen(){
    if (DoorPos() < 1000){      
      DriverStation.reportError("Door Open", false);
      door.set(ControlMode.Position, 40/Constants.GEAR_INCHES);
    }


  }

  public void DoorClose(){
    if (DoorPos() > 3000){
      DriverStation.reportError("Door Closed", false);
      door.set(ControlMode.Position, -10/Constants.GEAR_INCHES);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    DriverStation.reportError("Door PID: " + door.getSelectedSensorPosition(), false);
  }
}