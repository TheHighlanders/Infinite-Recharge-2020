/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import grip.JavaGripPipeline;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry; 
import edu.wpi.first.networktables.NetworkTableInstance;
import java.util.*;
public class Vision extends SubsystemBase {
  /**
   * Creates a new Vision.
   */
  
  NetworkTableEntry x1; NetworkTableEntry y1;
  NetworkTableEntry x2; NetworkTableEntry y2;
  NetworkTableEntry length;

  List x1i; List y1i;
  List x2i; List y2i;
  List lengthi;
  
  public Vision() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
