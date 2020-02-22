/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
  
  private WPI_VictorSPX climbLeftMotor = new WPI_VictorSPX(Constants.CLIMB_LEFT);
  private WPI_VictorSPX climbRightMotor = new WPI_VictorSPX(Constants.CLIMB_RIGHT);

  public Climber() {

  }

  /*
    Climbing for the Left Side
  */
  public void ClimbUpLeft(){
    climbLeftMotor.set(0.3);
  }

  public void ClimbDownLeft(){
    climbLeftMotor.set(-0.3);
  }

  public void ClimbStopLeft(){
    climbLeftMotor.set(0);
  }

  
  /*
    Climbing for the Right Side
  */
  public void ClimbUpRight(){
    climbRightMotor.set(0.3);
  }

  public void ClimbDownRight(){
    climbRightMotor.set(-0.3);
  }

  public void ClimbStopRight(){
    climbRightMotor.set(0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
