/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Door;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Door;

public class DoorUpCMD extends CommandBase {
  /**
   * Creates a new DoorUpCMD.
   */
  Door m_Door;

  public DoorUpCMD(Door m_Door) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.m_Door = m_Door;
    addRequirements(m_Door);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {   
    DriverStation.reportWarning("Door Up", false);
    m_Door.DoorOpen();
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
