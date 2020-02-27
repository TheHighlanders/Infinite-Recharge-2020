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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
  public double maxTurnSpeed = 0.3;

  /*
    where we want the robot be - where the robot is
  */
  public double acceptedAngleOffset;


  NetworkTableEntry goalCenterX;
  NetworkTableEntry goalCenterY;
  double xValue;
  double yValue;


  public AlignCmd(Drive drive_subsystem) {
    //getting Drive Train classes
    m_drive = drive_subsystem;
    addRequirements(m_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SmartDashboard.putBoolean("Aligned?", false);

    NetworkTableInstance table = NetworkTableInstance.getDefault();
    NetworkTableEntry ValueMiddleX = table.getEntry("Middle X");
		NetworkTableEntry ValueMiddleY = table.getEntry("Middle Y");
		this.xValue = ValueMiddleX.getDouble(0);
    this.yValue= ValueMiddleY.getDouble(0);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //we didn't find it
    if(didWeFindIt != true){
        //run this again
        initialize();
    }
      //if the answer is greater than or less than the "okay" angle
      if(xValue >= maxTurnSpeed){
          //spin to the left at half speed
          DriverStation.reportWarning("spin to the left at half speed", false);
         // Robot.driving.drivePower(0.10,-0.10);
      }

      //if the answer is greater than or equal to the answer, 
      else if (xValue <= maxTurnSpeed) {
        //spin to the right at half speed
        DriverStation.reportWarning("spin to the right at half speed", false);
       // Robot.driving.drivePower(-0.10,0.10);
      }
    //if we found it
    else{
      if(xValue < Constants.GOAL_RIGHT_BOUND & xValue > Constants.GOAL_RIGHT_BOUND){
        DriverStation.reportWarning("It is aligned", false);
       // Robot.driving.drivePower(0,0);
        SmartDashboard.putBoolean("Aligned?", true);

      }
      //x is greater than A then turn to the left
      else if(xValue < Constants.GOAL_LEFT_BOUND){
        DriverStation.reportWarning("spin sss half speed", false);
        //Robot.driving.drivePower(-0.10, 0.10);
      }
      //x is less than B then turn to the right
      else if(xValue > Constants.GOAL_RIGHT_BOUND){
        DriverStation.reportWarning("spin  half speed", false);
        //Robot.driving.drivePower(0.10, -0.10);
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
