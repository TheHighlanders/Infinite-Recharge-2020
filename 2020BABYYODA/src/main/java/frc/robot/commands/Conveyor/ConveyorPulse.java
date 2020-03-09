/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Conveyor;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.*;

public class ConveyorPulse extends SequentialCommandGroup {
  
  public ConveyorPulse(Conveyor m_Conveyor, Double speedFoward, Double speedBackward, Double timeFoward, Double timeBackward, Double haltTime) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    addCommands(
      new ConveyorInCMD(m_Conveyor, 1.0)



    );
  }
}
