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
  private final Hook m_hook = new Hook();
  private final Drive m_robotDrive = new Drive();
  private final Climber m_climber = new Climber();
  private final Conveyor m_Conveyor = new Conveyor();
  private final Shooting m_Shooting = new Shooting();
  private final IntakeArm m_IntakeArm = new IntakeArm();
  private final IntakeBrush m_IntakeBrush = new IntakeBrush();

  private Command m_autoCommand;
  private final Vision m_Vision = new Vision(); 
  
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
    m_autoCommand = new DrivePowerAUTO(m_robotDrive, 0);
  
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {


    /*
      Driver #2 
      Moving the Intake Arm up and down
    */
    JoystickButton ArmUp = new JoystickButton(m_OI.Control3,6);
    JoystickButton ArmDown = new JoystickButton(m_OI.Control3,5);
    ArmUp.whileHeld(new IntakeArmUpCMD(m_IntakeArm));
    ArmDown.whileHeld(new IntakeArmDownCMD(m_IntakeArm));
    
    /*
      Driver #2 
      Intake in and out
    */
    JoystickButton IntakeIn = new JoystickButton(m_OI.Control2, 4);
    JoystickButton IntakeOUT = new JoystickButton(m_OI.Control2, 5);
    IntakeIn.whileHeld(new IntakeInCMD(m_IntakeBrush));
    IntakeOUT.whileHeld(new IntakeOutCmd(m_IntakeBrush));
    
    /*
      Driver #2
      Conveyor in and out
    */
    JoystickButton ConveyorIn = new JoystickButton(m_OI.Control2, 2);
    JoystickButton ConveyorOut = new JoystickButton(m_OI.Control2, 3);
    ConveyorIn.whileHeld(new ConveyorInCMD(m_Conveyor));
    ConveyorOut.whileHeld(new ConveyorOutCMD(m_Conveyor));

    /*
      Driver #2 
      Climbing: Moving the robot up 
    */
    //Left
    JoystickButton ClimbUpLeft = new JoystickButton(m_OI.Control3, 4);
    JoystickButton ClimbDownLeft = new JoystickButton(m_OI.Control3, 7);
    ClimbUpLeft.whileHeld(new ClimbLeftUpCMD(m_climber));
    ClimbDownLeft.whileHeld(new ClimbLeftDownCMD(m_climber));
    
    //Right
    JoystickButton ClimbUpRight = new JoystickButton(m_OI.Control3, 4);
    JoystickButton ClimbDownRight = new JoystickButton(m_OI.Control3, 7);
    ClimbUpRight.whileHeld(new ClimbRightUpCMD(m_climber));
    ClimbDownRight.whileHeld(new ClimbRightDownCMD(m_climber));

    /*
      Driver #2
      Climbing: Moving up Hook and Down
    */
    JoystickButton HookLeftUp = new JoystickButton(m_OI.Control3,4);//change later
    JoystickButton HookLeftDown = new JoystickButton(m_OI.Control3,4);//change later
    JoystickButton HookRightUp = new JoystickButton(m_OI.Control3,4);//change later
    JoystickButton HookRightDown = new JoystickButton(m_OI.Control3,4);//change later
    HookLeftUp.whileHeld(new HookLeftUpCMD(m_hook));
    HookLeftDown.whileHeld(new HookLeftDownCMD(m_hook));
    HookRightUp.whileHeld(new HookRightUpCMD(m_hook));
    HookRightDown.whileHeld(new HookRightDownCMD(m_hook));

    /*
      Driver #2 
      Shoot
    */
    JoystickButton Shoot = new JoystickButton(m_OI.Control2, 1);
    Shoot.whileHeld(new ShootingCMD(m_Shooting));
    
    
    /*
      Drive #1 controll
    */

    JoystickButton xboxA = new JoystickButton(m_OI.xbox,1);
    JoystickButton xboxB = new JoystickButton(m_OI.xbox,2);
    JoystickButton xboxC = new JoystickButton(m_OI.xbox,3);

    xboxA.whileHeld(new ShootingCMD(m_Shooting));
    xboxB.whenPressed(new IncrementShootingSpeed(m_Shooting));
    xboxC.whenPressed(new DecrementShootingSpeed(m_Shooting));
    xboxA.whenReleased(new ShootingEndCMD(m_Shooting));

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
