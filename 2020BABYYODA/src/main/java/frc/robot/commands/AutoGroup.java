/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.*;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AutoGroup extends ParallelCommandGroup {
  /**
   * Creates a new ParrelelAutoGroup.
   */

  public AutoGroup(Drive m_Drive, Shooting m_Shooting, Conveyor m_Conveyor) {
   
    new ParallelCommandGroup(
      new ShootingCMD(m_Shooting),

      new SequentialCommandGroup(
        new AlignCmd(m_Drive),
        new ConveyorInCMD(m_Conveyor)

      ).andThen()

    );
    
  }
}
