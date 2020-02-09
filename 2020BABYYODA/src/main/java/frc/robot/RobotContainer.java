/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.subsystems.*;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final OI m_OI = new OI();

  private final Drive m_robotDrive = new Drive();
  private final Shooting m_Shooting = new Shooting();
  private final IntakeArm m_IntakeArm = new IntakeArm();
  private final IntakeBrush m_IntakeBrush = new IntakeBrush();
  private Command m_autoCommand;
  
  
  /** private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

*/

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
   configureButtonBindings();
    
    m_robotDrive.setDefaultCommand(new TeleopDriveCMD(m_robotDrive, m_OI));

    DriverStation.reportWarning("Initialized",false);
    m_autoCommand = new DrivePowerAUTO(m_robotDrive);
  
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    // JoystickButton ctrlINTAKE_UP = new JoystickButton(m_OI.Control1, 5);
    // JoystickButton ctrlINTAKE_DOWN = new JoystickButton(m_OI.Control1,2);

    // JoystickButton ctrlINTAKER_OUT = new JoystickButton(m_OI.Control2, 5);
    // JoystickButton ctrlINTAKER_IN = new JoystickButton(m_OI.Control2, 4);
    
    // JoystickButton ctrlLEFT_UP = new JoystickButton(m_OI.Control1, 4);
    // JoystickButton ctrlLEFT_DOWN = new JoystickButton(m_OI.Control1, 7);

    // JoystickButton ctrlRIGHT_UP = new JoystickButton(m_OI.Control1, 2);
    // JoystickButton ctrlRIGHT_DOWN = new JoystickButton(m_OI.Control1, 1);

    // JoystickButton ctrlCONVEYOR_OUT = new JoystickButton(m_OI.Control2, 3);
    // JoystickButton ctrlCONVEYOR_IN = new JoystickButton(m_OI.Control2, 2);

    JoystickButton xboxA = new JoystickButton(m_OI.xbox,1);
    JoystickButton xboxB = new JoystickButton(m_OI.xbox,2);
    JoystickButton xboxC = new JoystickButton(m_OI.xbox,3);

    xboxA.whileHeld(new ShootingCMD(m_Shooting));
    xboxB.whenPressed(new IncrementShootingSpeed(m_Shooting));
    xboxC.whenPressed(new DecrementShootingSpeed(m_Shooting));
    xboxA.whenReleased(new ShootingEndCMD(m_Shooting));

    // ctrlINTAKE_UP.whenPressed(new IntakeArmUpCMD(m_IntakeArm));
    // ctrlINTAKE_DOWN.whenPressed(new IntakeArmDownCMD(m_IntakeArm));

    // ctrlINTAKER_OUT.toggleWhenPressed();
    

  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */ 
  
  
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
     return m_autoCommand;
     
  } 
}
