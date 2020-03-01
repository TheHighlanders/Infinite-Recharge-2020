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
  private final Hook m_hook = new Hook();
  private final Drive m_robotDrive = new Drive();
  private final Climber m_climber = new Climber();
  private final Conveyor m_Conveyor = new Conveyor();
  private final Shooting m_Shooting = new Shooting();
  private final IntakeArm m_IntakeArm = new IntakeArm();
  private final IntakeBrush m_IntakeBrush = new IntakeBrush();
  private Command m_autoCommand;
 // private final Vision m_Vision = new Vision();
  

  
  /** private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

*/

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
   configureButtonBindings();
   m_autoCommand = new AlignCmd(m_robotDrive);
   //m_autoCommand = new AutoGroup(m_robotDrive, m_Shooting, m_Conveyor);
    
    m_robotDrive.setDefaultCommand(new TeleopDriveCMD(m_robotDrive, m_OI));

    DriverStation.reportWarning("Initialized",false);

    m_robotDrive.left1.setSelectedSensorPosition(0);
    
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    
    //Joystick joystick2 = new Joystick(Constants.CONTROL2_PORT);
    //Joystick joystick3 = new Joystick(Constants.CONTROL3_PORT);

    // Xbox is Controller #1 (In Port 1)
    // Left side of the Control Panel is Controller #3 (In Port 3)
    // Right side of the Control Panel is Controller #2 (In Port 2)

    /*
      Controller #3
      Moving the Intake Arm up and down (Called Intake Up and Down on the Panel)
    */
    JoystickButton ArmUp = new JoystickButton(m_OI.Control3,6);
    JoystickButton ArmDown = new JoystickButton(m_OI.Control3,5);
    ArmUp.whileHeld(new IntakeArmUpCMD(m_IntakeArm));
    ArmDown.whileHeld(new IntakeArmDownCMD(m_IntakeArm));
    
    /*
      Controller #2
      Intake in and out (Called Intaker IN and OUT on the Panel)
    */
    JoystickButton IntakeIn = new JoystickButton(m_OI.Control2, 4);
    JoystickButton IntakeOUT = new JoystickButton(m_OI.Control2, 5);
    IntakeIn.whileHeld(new IntakeInCMD(m_IntakeBrush));
    IntakeOUT.whileHeld(new IntakeOutCmd(m_IntakeBrush));
    
    /*
      Controller #2
      Conveyor in and out
    */
    JoystickButton ConveyorIn = new JoystickButton(m_OI.Control2, 2);
    JoystickButton ConveyorOut = new JoystickButton(m_OI.Control2, 3);
    ConveyorIn.whileHeld(new ConveyorInCMD(m_Conveyor));
    ConveyorOut.whileHeld(new ConveyorOutCMD(m_Conveyor));

    /*
      Drive #2 controllers
      Climbing: Moving the robot up
    */
     
    // Initialize buttons. This is actually being controlled in the climber subsystem.
    JoystickButton ClimbLeft = new JoystickButton(m_OI.Control3, 1);
    JoystickButton ClimbRight = new JoystickButton(m_OI.Control3, 5);
    

    JoystickButton HookUpLeft = new JoystickButton(m_OI.Control3,4);
    HookUpLeft.whileHeld(new HookLeftUpCMD(m_hook));
    JoystickButton HookDownLeft = new JoystickButton(m_OI.Control3,7);
    HookDownLeft.whileHeld(new HookLeftDownCMD(m_hook));

    /*
      Controller #2
      Shoot
    */

    JoystickButton Shoot = new JoystickButton(m_OI.Control2, 1);
    Shoot.whileHeld(new ShootingCMD(m_Shooting));
    JoystickButton ShootReverse = new JoystickButton(m_OI.Control2, 6);
    ShootReverse.whileHeld(new ShootingReverseCMD(m_Shooting));
    
    
    /*
      Controller #1 Xbox
    */

    JoystickButton xboxA = new JoystickButton(m_OI.xbox,1);
    JoystickButton xboxB = new JoystickButton(m_OI.xbox,2);
    JoystickButton xboxC = new JoystickButton(m_OI.xbox,3);
    JoystickButton xboxD = new JoystickButton(m_OI.xbox,4);
    JoystickButton xboxLeftTrigger = new JoystickButton(m_OI.xbox, 5);

    xboxA.whileHeld(new ShootingCMD(m_Shooting));
    xboxB.whileHeld(new ConveyorInCMD(m_Conveyor));
    xboxC.whileHeld(new IntakeInCMD(m_IntakeBrush));
    xboxD.whileHeld(new IntakeArmUpCMD(m_IntakeArm));
    xboxLeftTrigger.whileHeld(new AlignCmd(m_robotDrive));

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
