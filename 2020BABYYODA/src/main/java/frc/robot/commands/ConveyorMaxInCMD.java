/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import frc.robot.subsystems.Conveyor;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ConveyorMaxInCMD extends CommandBase {
  /**
   * Creates a new ConveyorCMD.
   */
  private final Conveyor m_Conveyor;

  public ConveyorMaxInCMD(Conveyor conveyor_subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_Conveyor = conveyor_subsystem;
    addRequirements(m_Conveyor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   m_Conveyor.ConveyorMaxIN();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Conveyor.ConveyorMaxSTOP();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
