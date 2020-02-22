/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class ClimbRightUpCMD extends CommandBase {
  
  private final Climber m_climber;

  public ClimbRightUpCMD(Climber Climb_subsystem) {
    m_climber = Climb_subsystem;
    addRequirements(Climb_subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_climber.ClimbUpRight();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_climber.ClimbStopRight();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}