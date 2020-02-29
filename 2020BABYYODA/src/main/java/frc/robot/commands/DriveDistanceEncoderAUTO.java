/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;

public class DriveDistanceEncoderAUTO extends CommandBase {
  /**
   * Creates a new DriveByDistance.
   */
  public final Drive m_Drive;
  public Double leftdist;
  public Double rightdist;

  public DriveDistanceEncoderAUTO(Drive drive_subsystem, Double leftdist, Double rightdist) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_Drive = drive_subsystem;
    leftdist = this.leftdist;
    rightdist = this.rightdist;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_Drive.setPositionAUTO(leftdist, rightdist);
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
