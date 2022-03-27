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
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class IntakeSubsystem extends SubsystemBase {
     // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    //public DoubleSolenoid intakeArm =  new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);

    CANSparkMax intake;
    DoubleSolenoid intakeArm;

    //double speed = 0.3;
    
    public IntakeSubsystem(){
        intake = new CANSparkMax(RobotMap.IntakeM, MotorType.kBrushless);
        intakeArm =  new DoubleSolenoid(9, PneumaticsModuleType.CTREPCM, 0, 2);
        intakeArm.set(Value.kForward);
    }
    
    public void intakeInitialize() {
        intakeArm.set(Value.kForward);
        //intake.set(speed);
    }

    public void intakeToggle() {
        intakeArm.toggle();
    }

    public void intakeSpin(double speed){
        intake.set(speed);
        
    }

    
    public void intakeRetract(boolean retract){
        intakeArm.set(Value.kForward);
    }

    
    @Override
    public void periodic() {
      // This method will be called once per scheduler run
    }

}