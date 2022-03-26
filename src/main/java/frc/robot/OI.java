// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj.GenericHID;

//Importing Commands
import frc.robot.commands.DriveCommand;
import frc.robot.commands.ClimberCommandMove;
import frc.robot.commands.ConveyorBeltCommandForward;
import frc.robot.commands.ConveyorBeltCommandToggle;
import frc.robot.commands.IntakeCommandToggle;
import frc.robot.commands.IntakeCommandStop;




public class OI {

    public XboxController driver = new XboxController(0);
    
    public XboxController operator = new XboxController(1);

    //Driver Controls
    public JoystickButton driverAButton;
    public JoystickButton driverBButton;
    public JoystickButton driverXButton;
    public JoystickButton driverYButton;
    public JoystickButton driverLbump;
    public JoystickButton driverRbump;

    public JoystickButton driverLeftTrigger;
    public JoystickButton driverRightTrigger;

    //Operator Controls
    public JoystickButton operatorAButton;
    public JoystickButton operatorBButton;
    public JoystickButton operatorXButton;
    public JoystickButton operatorYButton;

  /** Creates a new OI. */
  public OI() {
    

    //Need edit: 1
    driverAButton = new JoystickButton(driver, 1);
    driverBButton = new JoystickButton(driver, 2);
    driverXButton = new JoystickButton(driver, 3);
    driverYButton = new JoystickButton(driver, 4);
    driverLbump = new JoystickButton(driver, 5);
    driverRbump = new JoystickButton(driver, 6);

    driverLeftTrigger = new JoystickButton(driver, 5);
    driverRightTrigger = new JoystickButton(driver, 6);

    operatorAButton = new JoystickButton(operator, 1);
    operatorBButton = new JoystickButton(operator, 2);
    operatorXButton = new JoystickButton(operator, 3);
    operatorYButton = new JoystickButton(operator, 4);
    
    
    
    // driverBButton.whileHeld(new ConveyorBeltCommandForward(Robot.ConveyorBelt));
    // ==driverXButton.whileHeld(new ConveyorBeltCommandStop(Robot.ConveyorBelt));
    // driverAButton.whileHeld(new IntakeCommand());

    //If operators x button and operator y button pressed complete release function that then goes into third climb
      //if these two buttons are pressed again then release into third climb
 
    //operatorAButton.whileHeld(new Co  nveyorBeltCommand());
    /*
    if (driverAButton.getAsBoolean()){
      new ClimberCommandMove(Robot.climber);
      System.out.println("button pressed");
    } else {
      System.out.println(driverAButton.getAsBoolean());
    }*/
    driverAButton.whenPressed(new ClimberCommandMove(Robot.climber));
    
    // driverBButton.whenPressed(new IntakeCommandToggle(Robot.Intake));
    // driverBButton.whenReleased(new IntakeCommandStop(Robot.Intake));
    driverRbump.whenPressed(new IntakeCommandToggle(Robot.Intake));
    
    // driverXButton.whenPressed(new ConveyorBeltCommandForward(Robot.conveyor));
    // driverXButton.whenReleased(new ConveyorBeltCommandStop(Robot.conveyor));
    driverLbump.whenPressed(new ConveyorBeltCommandToggle(Robot.conveyor));
    
    
    //driverXButton.whenPressed(new ConveyorBeltCommandForward(Robot.conveyor));
    //driverYButton.whenPressed(new ConveyorBeltCommandStop(Robot.conveyor));

  }


  // method that takes speed to go forwards or backwards from bumpers of controller depending on how hard driver presses
  public double getSpeed() {
    if (Math.abs(driver.getLeftTriggerAxis() - driver.getRightTriggerAxis()) > 0.15){
      return driver.getLeftTriggerAxis() - driver.getRightTriggerAxis();}
    else
      return 0.0;

    
  }

  // method that allows for joystick control to determine turns to left/right
  public double getTurn() {
    if (Math.abs(driver.getRawAxis(0)) > 0.2) {
      return driver.getRawAxis(0);
    } else {
      return 0.0;
    }
  }

  //method that takes speed for conveyor belt from second controller triggers
}