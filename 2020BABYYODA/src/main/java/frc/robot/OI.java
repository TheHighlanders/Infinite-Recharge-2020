/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;

/** import edu.wpi.first.hal.sim.mockdata.DriverStationDataJNI; import edu.wpi.first.wpilibj.Joystick;*/

public class OI {

    public Joystick WiiControllDriver = new Joystick(Constants.WII_DRIVER);
    public Joystick WiiControlOperator = new Joystick(Constants.WII_OPERATOR);
    //Not in use for wii remotes, I kept them so code would stop screaming
    //public XboxController xbox = new XboxController(Constants.XBOX_PORT);
    public Joystick Control2 = new Joystick(Constants.CONTROL2_PORT);    
    public Joystick Control3 = new Joystick(Constants.CONTROL3_PORT);
    /** Contructer */

    public OI() {


    }
    /*
        Driver #1
        Wii control
    */
    public boolean get1Button(){
        return WiiControllDriver.getRawButton(1);
    }

    public boolean get2Button(){
        return WiiControllDriver.getRawButton(2);
    }

    public boolean getBackButton(){
        return WiiControllDriver.getRawButton(4);
    }

    //getXboxLeftX
    public double getWiiAxisLeftX(){
        return WiiControllDriver.getRawAxis(4);
    }

    //getXboxLeftY
    public double getWiiAxisLeftY(){
        return WiiControllDriver.getRawAxis(3);
    }
    //getXboxRightX
    public double getWiiAxisRightX(){
        return WiiControllDriver.getRawAxis(3);
    }
    //getXboxRightY
    public double getWiiAxisRightY(){
        return WiiControllDriver.getRawAxis(4);
    }
    /*
        Driver #1
        Xbox control
    */
    /*
    public boolean getXboxButtonA(){
        return xbox.getAButton();
    }

    public double getXboxLeftX() {
		return xbox.getX(GenericHID.Hand.kLeft);
	}

    public double getXboxLeftY() {
		return xbox.getY(GenericHID.Hand.kLeft);
	}

    public double getXboxRightX() {
		return xbox.getX(GenericHID.Hand.kRight);
	}

    public double getXboxRightY() {
		return xbox.getY(GenericHID.Hand.kRight);

    }
    */
    /** Xbox Triggers */
    /*
    public double getXboxRightTrigger() {
        return xbox.getTriggerAxis(GenericHID.Hand.kRight);
        }

    public double getXboxLeftTrigger() {
        return xbox.getTriggerAxis(GenericHID.Hand.kLeft);
        }

   RUMBLE CODE
    public void setXboxRumble(double power) {
        xbox.setRumble(GenericHID.RumbleType.kLeftRumble, power);
        xbox.setRumble(GenericHID.RumbleType.kRightRumble, power);
        }
    */
    

}