/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


/** This Command will transfer the data needed to drive during teleop. */


package frc.robot.commands.Drive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Drive;
import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.OI;

public class TeleopDriveCMD extends CommandBase {
  /**
   * m_LeftYJoy and m_RightYJoy ranges from -1 to 1
   */

  private final Drive m_Drive;
  private final OI m_OI;
  
  public TeleopDriveCMD(Drive drive_subsystem, OI WiiControllDriver_oi) {

    m_Drive = drive_subsystem;
    //m_OI = xbox_oi;
    m_OI = WiiControllDriver_oi;

    addRequirements(m_Drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //m_Drive.drivePower(-m_OI.WiiControllDriver.getRawAxis(3), m_OI.WiiControllDriver.getRawAxis(4));
    //m_Drive.drivePower(-this.m_OI.getWiiAxisLeftY(),this.m_OI.getWiiAxisRightY());
    /*
      Notes:
      -0.2 to 0.2 is the range for the "center" 
      -0.8 to -0.2 is the range for turning left
       0.2 to 0.8 is the range for turning right
    */
    /* Button 1 Moves Forward */
    while(m_OI.get1Button() == true){
      DriverStation.reportWarning("Button 1 is pressed", false);
    }
    while(m_OI.get1Button() == false){
      DriverStation.reportWarning("Button 1 is NOT PRESSED", false);
    }





     /* saving this for later 
     while(m_OI.get1Button() == true){
      DriverStation.reportWarning("Button 1 is pressed", false);
      if(m_OI.WiiControllDriver.getRawAxis(3) > -0.2 && m_OI.WiiControllDriver.getRawAxis(3) < 0.2 ){
        m_Drive.drivePower(-this.m_OI.getWiiAxisLeftY(),this.m_OI.getWiiAxisRightY());
      }
    else{
      DriverStation.reportWarning("Button 1 is Not pressed", false);
    } 
    */
  
   
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
