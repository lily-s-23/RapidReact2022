// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import edu.wpi.first.wpilibj.DigitalInput;
public class ElevatorSubsystem extends SubsystemBase {
  /** Creates a new Elevator. */
  TalonFX elevator;
  DigitalInput limitSwitch1;
  DigitalInput limitSwitch2;

  public ElevatorSubsystem() {
    elevator = new TalonFX(1);
    limitSwitch1 = new DigitalInput(1);
    limitSwitch2 = new DigitalInput(2);
  }

  public void extend() {
    elevator.set(ControlMode.PercentOutput, 1.0);
  }

  public void stopExtend() {
    if (limitSwitch1.get()) {
      elevator.set(ControlMode.PercentOutput, 0.0);
    }
  }

  public void pull() {
    elevator.set(ControlMode.PercentOutput, -1.0);
  }

  public void stopPull() {
    if (limitSwitch2.get()) {
      elevator.set(ControlMode.PercentOutput, 0.0);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
