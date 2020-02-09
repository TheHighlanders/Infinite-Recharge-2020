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

  /*
    GRIP stuff
    Assuming it is 
    - angle1 which should be 120
    - angle2 which should also be 120
    
  */
  NetworkTableEntry angle1;
  NetworkTableEntry angle2;

  public AlignCmd(Drive drive_subsystem) {
    //getting Drive Train classes
    m_drive = drive_subsystem;
    addRequirements(m_drive);
    //some NetworkTable stuff 
    NetworkTableInstance ntInst = NetworkTableInstance.getDefault();
    NetworkTable visionTable = ntInst.getTable("visionTable");
    //I'm assuming this is getting the vaules 
    angle1 = visionTable.getEntry("angle1");
    angle2 = visionTable.getEntry("angle2");
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    /*
      If the entry does not exist or is of different type, it will return the default value.
      10000 is the default value
      so that makes sense
    */
    double angle1_b = angle1.getDouble(1000);
    double angle2_b = angle2.getDouble(1000);
    //Getting the amount of which we want to turn the robot
    //Will get changed
    rotationToTargetAmount = (angle1_b + angle2_b) / 2;
    //resetting the gryo so we can have fun with turning
    Robot.driving.resetGyro();
    /*
      How far we have to turn is being figured out here
      We do this by:
        Where we want to be (rotationToTargetAmount) - where the robot is currently at (gyro)
    */
    currentAngleOffset = rotationToTargetAmount - Robot.m_drive.getGyroAngle();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //we didn't find it!!!
    if(didWeFindIt != true){
        //run this again
        initialize();
    }
    //how much we gotta turn = how far we wanna turn - where the robot is 
    currentAngleOffset = rotationToTargetAmount - Robot.driving.getGyroAngle();
      //once we figure out currentAngleOffset
      //math time: if the answer is greater than or less than the "okay" angle
      if(currentAngleOffset >= maxTurnSpeed){
          //spin to the left at half speed
          Robot.driving.drivePower(0.50,-0.50);
      }

      //if the answer is greater than or equal to the answer, 
      else if (currentAngleOffset <= maxTurnSpeed) {
        //spin to the right at half speed
        Robot.driving.drivePower(-0.50,0.50);
      }
    //if we found it!! 
    else{
      //if the angle that we have to turn at is less than zero
      //then turn to the left
      if(currentAngleOffset < 0){
        Robot.driving.drivePower(-0.15, 0.15);
      }
      //if the angle that we have to turn at is greater than zero
      //then turn to the right
      else if(currentAngleOffset > 0){
        Robot.driving.drivePower(0.15, -0.15);
      }
    }      
  }

  // Called once the command ends or is interrupted.
  //we done 
  @Override
  public void end(boolean interrupted) {
    DriverStation.reportWarning("We're done!", false);
    DriverStation.reportWarning("currentAngleOffset" + currentAngleOffset, false);
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
