// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.simulation.XboxControllerSim;
//import frc.robot.commands.ExampleCommand;
//import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DriveCommand;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandScheduler;



/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer { 
  // The robot's subsystems and commands are defined here...
  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  //private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  
  public static final DriveSubsystem driveSubsystem = new DriveSubsystem();

  //new DifferentialDrive(new Talon(0), new Talon(1));
  private final Joystick m_stick = new Joystick(0);
  private final Timer m_timer = new Timer();
  //public static OI OI = new OI();
  //public static DriveCommand DriveCommand = new DriveCommand();
  DriveCommand DriveCommand = new DriveCommand();
  CommandScheduler commandScheduler = CommandScheduler.getInstance();
  //private final DriveCommand m_dDriveCommand = new DriveCommand();
  
  public XboxController Driver = new XboxController(0);

  //public XboxController Operator = new XboxController(1);

  public JoystickButton DriverAButton;
  public JoystickButton DriverBButton;
  public JoystickButton DriverXButton;
  public JoystickButton DriverYButton;

 // public JoystickButton DriverLeftTrigger;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    driveSubsystem.setDefaultCommand(DriveCommand);
 

    DriverAButton = new JoystickButton(Driver, 1);
    DriverBButton = new JoystickButton(Driver, 2);
    DriverXButton = new JoystickButton(Driver, 3);
    DriverYButton = new JoystickButton(Driver, 4);

    //DriverLeftTrigger = new JoystickButton(Driver, 5);


  
  
    // Operator Individual Controller Devices
    //public JoystickButton OperatorAButton;
    //public JoystickButton OperatorBButton;
    //public JoystickButton OperatorXButton;
    //public JoystickButton OperatorYButton;
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}
  
  public double getSpeed() {
    return Driver.getLeftTriggerAxis() - Driver.getRightTriggerAxis();}

  public double getTurn() {
    return Driver.getRawAxis(0);}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }

}
