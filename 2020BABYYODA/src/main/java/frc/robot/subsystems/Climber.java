/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
  
  private WPI_VictorSPX climbLeftMotor = new WPI_VictorSPX(Constants.LEFT_WINCH);

  private WPI_VictorSPX climbRightMotor = new WPI_VictorSPX(Constants.RIGHT_WINCH);

  Joystick rightJoystick = new Joystick(Constants.CONTROL2_PORT);
  Joystick leftJoystick = new Joystick(Constants.CONTROL3_PORT);

  public Climber() {

  }

  /*
    Climbing for the Left Side
  */
  public void ClimbUpLeft(){
    climbLeftMotor.set(1);
  }

  public void ClimbDownLeft(){
    climbLeftMotor.set(-1);
  }

  public void ClimbStopLeft(){
    climbLeftMotor.set(0);
  }

  
  /*
    Climbing for the Right Side
  */
  public void ClimbUpRight(){
    climbRightMotor.set(1);
  }

  public void ClimbDownRight(){
    climbRightMotor.set(-1);
  }

  public void ClimbStopRight(){
    climbRightMotor.set(0);
  }
  @Override

  public void periodic() {
    // This method will be called once per scheduler run
    DriverStation.reportWarning("Joystick 2: " + rightJoystick.getY(),false);
    DriverStation.reportWarning("Joystick 3: " + leftJoystick.getY(),false);

    if (leftJoystick.getY()<-0.5){
      ClimbUpLeft();
    }
    else if (leftJoystick.getY()>0.5){
      ClimbDownLeft();
    }
    else{
      ClimbStopLeft();
    }
    if (rightJoystick.getY()>0.5){
      ClimbUpRight();
    }
    else if (rightJoystick.getY()<-0.5){
      ClimbDownRight();
    }
    else{
      ClimbStopRight();
    }
  }

}
