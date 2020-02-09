/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;

public class DrivePowerAUTO extends CommandBase {
  private final Drive m_drive;
  private int milliSeconds;
  private long startTime;
  private boolean running;
  private boolean complete;
  /**
   * Creates a new SetDrivePowerAuto.
   */
  public DrivePowerAUTO(Drive drive_subsystem, int milliSeconds) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drive = drive_subsystem;
    addRequirements(m_drive);

    this.running = false;
    this.milliSeconds = milliSeconds;
    this.complete = false;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drive.drivePower(0.1 ,0.1);
    if(!running)
    {
      this.running = true;
      this.startTime = System.currentTimeMillis();
    }
    if(running)
    {
      long elapsed = System.currentTimeMillis() - this.startTime;
      if(elapsed > this.milliSeconds)
      {
        this.complete = true;
      }
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return this.complete;
  }
}
