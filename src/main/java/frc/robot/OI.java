// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import frc.robot.commands.ConveyorBeltCommand;
import frc.robot.commands.DriveCommand;
import edu.wpi.first.wpilibj.GenericHID;


public class OI {
  public XboxController driver;
  public JoystickButton AButton;
  public JoystickButton BButton;
  public JoystickButton XButton;

  /** Creates a new OI. */
  public OI() {
    driver = new XboxController(0);

    //eed edit: 1
    AButton = new JoystickButton(driver, 1);


    AButton.whileHeld(new ConveyorBeltCommand());

  }


  // method that takes speed to go forwards or backwards from bumpers of controller depending on how hard driver presses
  public double getSpeed() {
    double speed  = driver.getLeftTriggerAxis() - driver.getRightTriggerAxis();
    if (Math.abs(speed) < 0.05) {
      speed = 0;
    }
    return speed * speed * (speed / Math.abs(speed));
  }

  // method that allows for joystick control to determine turns to left/right
  public double getTurn() {
    double turn = driver.getRawAxis(0);
    if (Math.abs(turn) < 0.05) {
      turn = 0;
    }
    return turn * turn * (turn/Math.abs(turn));
  }

  //method that takes speed for conveyor belt from second controller triggers
}
