/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Hook;
import edu.wpi.first.wpilibj.DigitalInput;

public class HookRightDownCMD extends CommandBase {
  private final Hook m_Hook;
  DigitalInput limitSwitch = new DigitalInput(Constants.LIMITSWITCH);

  public HookRightDownCMD(Hook Hook_subsystem) {
    m_Hook = Hook_subsystem;
    addRequirements(m_Hook);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Hook.HookDownRight();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Hook.HookDownRight();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
