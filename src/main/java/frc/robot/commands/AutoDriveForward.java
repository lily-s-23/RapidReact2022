// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.DriveSubsystem;

public class AutoDriveForward extends CommandBase {
  double currentTime;
  /** Creates a new AutoDriveForward. */
  public AutoDriveForward() {
    //requires(Robot.DriveSubsystem)
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.DriveSubsystem);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.DriveSubsystem.ArcadeDrive(0.5, 0.0);
    currentTime = 0.0;
    //Robot.DriveSubsystem.L1encoder.setPosition(0);
    //Robot.DriveSubsystem.L1motor.setPosition(0);
    //Robot.DriveSubsystem.
    
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    currentTime = System.currentTimeMillis();
    System.out.println(currentTime);
    Robot.DriveSubsystem.ArcadeDrive(0.5, 0.0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.DriveSubsystem.ArcadeDrive(0.0, 0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (currentTime > 1.0){

    }
    return false;
  }
}