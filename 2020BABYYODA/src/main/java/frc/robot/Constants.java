/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final int XBOX_PORT = 0;
    public static final int CONTROL2_PORT = 2;
    public static final int CONTROL3_PORT = 3;
    
    public static final int LEFT_WHEELS_1 = 51;//victor 
    public static final int LEFT_WHEELS_2 = 41;//talon
    public static final int RIGHT_WHEELS_1 = 50;//victor 
    public static final int RIGHT_WHEELS_2 = 44;//talon

    public static final int SHOOTER = 42;

    public static final int INTAKE_ARM = 52;

    public static final int INTAKE = 54;

    //does not have a motor controller
    public static final int HANGER1 = 17;

    public static final int CONVEYOR = 43; 

    public static final int CLIMBER1MOTOR = 17;
    
    //the range that the goal has to be in so we can shoot
    public static final double GOAL_LEFT_BOUND = 141.0;//a

    public static final double GOAL_RIGHT_BOUND = 200.0;//b


    public static final int LEFT_HOOK = 40; 
    public static final int RIGHT_HOOK = 99; //spx

    public static final int LEFT_WINCH = 53;
    public static final int RIGHT_WINCH = 55;

    public static final double INCHES_PER_ROTATION = 6*Math.PI;
}