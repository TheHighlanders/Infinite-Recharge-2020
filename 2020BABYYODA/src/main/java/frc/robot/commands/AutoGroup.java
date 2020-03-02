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
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.*;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AutoGroup extends SequentialCommandGroup {
  /**
   * Creates a new ParrelelAutoGroup.
   */
  private String selection;
  public AutoGroup(String selection, Drive m_Drive, Shooting m_Shooting, Conveyor m_Conveyor, IntakeBrush m_IntakeBrush) {
   this.selection = selection;

   switch (selection) {
     case "Back": // Back up into the trench run
     addCommands(
        new ParallelDeadlineGroup(
          new SequentialCommandGroup(
            new AlignCmd(m_Drive).withTimeout(10.0),
            new ParallelCommandGroup(new ConveyorInCMD(m_Conveyor).withTimeout(4.0), new LooseCMD(m_Shooting).withTimeout(4.0))),
          new ShootingCMD(m_Shooting)),
        new ParallelDeadlineGroup(new DriveDistanceEncoderAUTO(m_Drive, -15.0, -10.0), new IntakeInCMD(m_IntakeBrush)),
        new ParallelDeadlineGroup(new DriveDistanceEncoderAUTO(m_Drive, -100.0, -100.0), new IntakeInCMD(m_IntakeBrush))


      );



      case "M":
      addCommands(
        new ParallelDeadlineGroup(
          new SequentialCommandGroup(
            new AlignCmd(m_Drive).withTimeout(10.0),
            new ParallelCommandGroup(new ConveyorInCMD(m_Conveyor).withTimeout(4.0), new LooseCMD(m_Shooting).withTimeout(4.0))),
          new ShootingCMD(m_Shooting)),
        new ParallelDeadlineGroup(new DriveDistanceEncoderAUTO(m_Drive, -15.0, -10.0), new IntakeInCMD(m_IntakeBrush)),
        new ParallelDeadlineGroup(new DriveDistanceEncoderAUTO(m_Drive, -100.0, -100.0), new IntakeInCMD(m_IntakeBrush))


      );




      case "R":
      addCommands(
        new ParallelDeadlineGroup(
          new SequentialCommandGroup(
            new AlignCmd(m_Drive),
            new ConveyorInCMD(m_Conveyor).withTimeout(4.0)),
          new ShootingCMD(m_Shooting)),

        new DriveDistanceEncoderAUTO(m_Drive, -10.0, -10.0));
      


      default:

      addCommands(
        new ParallelDeadlineGroup(
          new SequentialCommandGroup(
            new AlignCmd(m_Drive),
            new ConveyorInCMD(m_Conveyor).withTimeout(4.0)),
          new ShootingCMD(m_Shooting)),

        new DriveDistanceEncoderAUTO(m_Drive, -10.0, -10.0));

   }
   
    
  }
}
