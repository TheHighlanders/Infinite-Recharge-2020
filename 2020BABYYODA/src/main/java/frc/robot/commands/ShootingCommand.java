/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooting;
import frc.robot.Robot;
import frc.robot.OI;


public class ShootingCommand extends CommandBase {
  /**
   * Creates a new ShootingCommand.
   */
  private final Shooting m_Shooting;
  private final OI m_OI;


  public ShootingCommand(Shooting shooting_subsystem, OI xbox_io) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_Shooting = shooting_subsystem;
    m_OI = xbox_io;

    addRequirements(m_Shooting);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Shooting.ShootingLaunch();
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