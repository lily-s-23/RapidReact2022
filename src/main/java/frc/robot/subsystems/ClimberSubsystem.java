// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import org.ejml.equation.Variable;

//import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
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
  DoubleSolenoid solenoid1;
  DoubleSolenoid solenoid2;
  DoubleSolenoid solenoid3;
  DigitalInput limitSwitch1;
  DigitalInput limitSwitch2;
  DigitalInput limitSwitch3;
  

  public ClimberSubsystem() {
    elevator = new TalonFX(0);
    winch = new TalonFX(1);
    solenoid1 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);
    solenoid2 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 3, 5);
    solenoid3 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 3, 5);
    limitSwitch1 = new DigitalInput(0);
    limitSwitch2 = new DigitalInput(1);
    limitSwitch3 = new DigitalInput(2); }
    
     
  public void climbLevelOne(double speedofElevator){
    if (limitSwitch1.get()){
      elevator.set(ControlMode.PercentOutput, 0.0);
      solenoid1.set(Value.kForward);
      elevator.set(ControlMode.PercentOutput, -speedofElevator);
      //need a stopping point  
    } else {
      elevator.set(ControlMode.PercentOutput, speedofElevator);
    }
  }
    
  public void climbLevelTwo(double speedofWinch){
    if (limitSwitch1.get()){
      winch.set(ControlMode.PercentOutput, 0.0);
      solenoid2.set(Value.kForward);
      //This is where we need the driver to confirm the release

      

      
    } else {
      winch.set(ControlMode.PercentOutput, speedofWinch);
    }}
   

    //while DigitalInput(0)
    //elevator.set(ControlMode.PercentOutput, speed);

    //extend motor 1 until limit switch is pressed
    //set soleniod to move forward
    //reverse motor 1
    //rotate winch
  

  /**
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
  //same method for rest of solenoids

  //return true if the sensor is triggered
  public boolean sensor1Status() {
    if (sensor1.get()) {
      return true;
    } else {
      return false;
    }
  }
  //same method for rest of sensors
  */
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}