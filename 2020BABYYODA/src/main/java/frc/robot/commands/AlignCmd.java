/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Drive;
import frc.robot.Constants;

public class AlignCmd extends CommandBase {
    private final Drive m_drive;
  /*
    did we do it? did we find it? 
    if not, run everything again to find it and keep doing it
  */
  public boolean didWeFindIt;
  /*
    when the robot is allowed to spin at full speed
    We don't wanna go to fast and overshoot

    62 is a random number
  */
  public double maxTurnSpeed = 62;

  /*
    How far we want to turn the robot from where we are
  */
  public double rotationToTargetAmount;

  /*
    where we want the robot be - where the robot is
  */
  public double acceptedAngleOffset;

  /*
    rotationToTargetAmount - robot's current angle
  */
  public double currentAngleOffset;

  NetworkTableEntry goalCenterX;
  NetworkTableEntry goalCenterY;
  double goalCenterX_b;
  double goalCenterY_b;


  public AlignCmd(Drive drive_subsystem) {
    //getting Drive Train classes
    m_drive = drive_subsystem;
    addRequirements(m_drive);

    NetworkTableInstance ntInst = NetworkTableInstance.getDefault();
    NetworkTable visionTable = ntInst.getTable("visionTable");
    goalCenterX = visionTable.getEntry("goalCenterX");
    goalCenterY = visionTable.getEntry("goalCenterY");

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    /*
      If the entry does not exist or is of different type, it will return the default value.
      10000 is the default value
      so that makes sense
    */
    goalCenterX_b = goalCenterX.getDouble(1000);
    goalCenterY_b = goalCenterY.getDouble(1000);
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //we didn't find it
    if(didWeFindIt != true){
        //run this again
        initialize();
    }
      //once we figure out currentAngleOffset/
      //math time: if the answer is greater than or less than the "okay" angle
      if(goalCenterX_b >= maxTurnSpeed){
          //spin to the left at half speed
          Robot.driving.drivePower(0.50,-0.50);
      }

      //if the answer is greater than or equal to the answer, 
      else if (goalCenterX_b <= maxTurnSpeed) {
        //spin to the right at half speed
        Robot.driving.drivePower(-0.50,0.50);
      }
    //if we found it
    else{
      if(goalCenterX_b < Constants.GOAL_RIGHT_BOUND & goalCenterX_b > Constants.GOAL_RIGHT_BOUND){
        DriverStation.reportWarning("It is aligned", false);
      }
      //x is greater than A then turn to the left
      else if(goalCenterX_b < Constants.GOAL_LEFT_BOUND){
        Robot.driving.drivePower(-0.15, 0.15);
      }
      //x is less than B then turn to the right
      else if(goalCenterX_b > Constants.GOAL_RIGHT_BOUND){
        Robot.driving.drivePower(0.15, -0.15);
      }
    }      
  }

  // Called once the command ends or is interrupted.
  //we done 
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
