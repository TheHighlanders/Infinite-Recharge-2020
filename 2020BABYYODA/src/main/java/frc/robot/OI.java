/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID;


/** import edu.wpi.first.hal.sim.mockdata.DriverStationDataJNI; import edu.wpi.first.wpilibj.Joystick;*/


public class OI {

    public XboxController xbox = new XboxController(Constants.XBOX_PORT);

    /** Contructer */

    public OI() {

    
        /**	Fill in the Xbox Array
         * 
         *  for(int i = 1; i < xboxButton_array.length; i++) {
			    xboxButton_array[i] = new JoystickButton(xbox, i);	
		    }
        */
	


    }
    /**   Xbox Joysticks */   

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
		return xbox.getY(GenericHID.Hand.kRight) - 0.1;//try this later

    }

    /** Xbox Triggers */

    public double getXboxRightTrigger() {
        return xbox.getTriggerAxis(GenericHID.Hand.kRight);
        }

    public double getXboxLeftTrigger() {
        return xbox.getTriggerAxis(GenericHID.Hand.kLeft);
        }

    /** RUMBLE CODE
    public void setXboxRumble(double power) {
        xbox.setRumble(GenericHID.RumbleType.kLeftRumble, power);
        xbox.setRumble(GenericHID.RumbleType.kRightRumble, power);
        }
    */






}