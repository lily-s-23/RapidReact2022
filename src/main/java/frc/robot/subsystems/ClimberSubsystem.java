// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

//import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DigitalInput;


// 1 Falcon for elevator
// falcon/Neo for winch
// 6 piston powered by 3 solenoids
// 6 limit switches (1 per claw)

public class ClimberSubsystem extends SubsystemBase {
  /** Creates a new ClimberSubsystem. */
  TalonFX elevator;
  TalonFX winch;
  DoubleSolenoid sol1;
  DoubleSolenoid sol2;
  DoubleSolenoid sol3;
  DigitalInput sensor1;
  DigitalInput sensor2;
  DigitalInput sensor3;
  DigitalInput sensor4;
  DigitalInput sensor5;
  DigitalInput sensor6;

  public ClimberSubsystem() {
    elevator = new TalonFX(0);
    winch = new TalonFX(1);
    sol1 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);
    sol2 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 3, 5);
    sol3 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 3, 5);
    sensor1 = new DigitalInput(0);
    sensor2 = new DigitalInput(0);
    sensor3 = new DigitalInput(0);
    sensor4 = new DigitalInput(0);
    sensor5 = new DigitalInput(0);
    sensor6 = new DigitalInput(0);
  }

  public void setElevatorSpeed(double speed) {
    elevator.set(ControlMode.PercentOutput, speed);
  }

  public void setSpinSpeed(double speed) {
    winch.set(ControlMode.PercentOutput, speed);
  }
  
  public void sol1clamp() {
    sol1.set(Value.kReverse);
  }
  public void sol1Off() {
    sol1.set(Value.kOff);
  }
  public void sol1Release() {
    sol1.set(Value.kForward);
  }

  //return true if the sensor is triggered
  public boolean sensor1Status() {
    if (sensor1.get()) {
      return true;
    } else {
      return false;
    }
  }
  //same method for rest of sensors

  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}