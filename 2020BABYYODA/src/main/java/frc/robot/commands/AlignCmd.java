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


public class AlignCmd extends CommandBase {
  private final Drive m_drive;

  NetworkTableEntry ValueMiddleX;
  NetworkTableEntry ValueMiddleY;
  NetworkTableEntry ValueIsAligned;
  double xValue;
  double yValue;
  boolean isAligned = false;

  double middleOfGoal = 175;

  double kP = 0.001;
  double kI = 0.0001;
  double maxSpeed = 0.6;
  double minSpeed = 0.2;
 

  

  public AlignCmd(Drive drive_subsystem) {
    //getting Drive Train classes
    m_drive = drive_subsystem;
    addRequirements(m_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    NetworkTableInstance networkTables = NetworkTableInstance.getDefault();
    NetworkTable table = networkTables.getTable("Test");
    this.ValueMiddleX = table.getEntry("centerX");
    this.ValueMiddleY = table.getEntry("centerY");
    this.ValueIsAligned = table.getEntry("IsAligned");
		

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    this.xValue = ValueMiddleX.getDouble(0);
    this.yValue = ValueMiddleY.getDouble(0);
    this.isAligned = ValueIsAligned.getBoolean(false);
    if(this.isAligned)
    {
      return;
    }
    double error = xValue - middleOfGoal;
    double proptional = Math.abs(error * kP);
    //integral += error * kI;
    
    double speed = Math.min(Math.max(proptional, minSpeed),maxSpeed);
    
    // double speed = 0.2;
    DriverStation.reportWarning("Speed " + speed, false);
    
    DriverStation.reportWarning("X: " + this.xValue + "   Middle: " + middleOfGoal, false);
      if(xValue >= middleOfGoal + 2){
          //spin to the left at half speed
          DriverStation.reportWarning("turn to left", false);
          this.m_drive.drivePower(speed,speed);
          // isAligned = false; 
      }

      else if (xValue <= middleOfGoal - 2) {
        //spin to the right at half speed
        DriverStation.reportWarning("turn to right", false);
        this.m_drive.drivePower(-speed,-speed);
        // isAligned = false; 
      }
      
      else{
        this.m_drive.drivePower(0,0);
        //integral = 0;
        // isAligned = true;
      }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return this.isAligned;
    // return false;
  }
}
