// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.WaitCommand;


public class IntakeSubsystem extends SubsystemBase {
     // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    //public DoubleSolenoid intakeArm =  new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);

    CANSparkMax intake;
    Solenoid intakeArm;

    //double speed = 0.3;
    
    public IntakeSubsystem(){
        intake = new CANSparkMax(RobotMap.IntakeM, MotorType.kBrushless);
        intakeArm =  new Solenoid( PneumaticsModuleType.CTREPCM, 0);
        intakeArm.set(false);
    }
    
    public void intakeInitialize() {
        //intakeArm.set(Value.kForward);
        intakeArm.set(true);
        //intake.set(speed);
    }

    public void intakeToggle() {
        intakeArm.toggle();
    }

    public void intakeSpin(double speed){
        //WaitCommand()
        intake.set(speed);
        
    }

    
    public void intakeRetract(boolean retract){
        //intakeArm.set(Value.kForward);
    }

    
    @Override
    public void periodic() {
      // This method will be called once per scheduler run
    }

}