/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.*;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class ShootingGroup extends ParallelCommandGroup {
  /**
   * Creates a new ShootingGroup.
   */
  public ShootingGroup(Shooting m_Shooting, Conveyor m_Conveyor, IntakeBrush m_IntakeBrush) {
    addCommands(
      new ShootingCMD(m_Shooting),
      new IntakeInCMD(m_IntakeBrush),
      new SequentialCommandGroup(
        new ShootingisAccelerated(m_Shooting),
        new ParallelCommandGroup(// new LooseCMD(m_Shooting), 
          new ConveyorInCMD(m_Conveyor))
        )

    );
    
  }
}
