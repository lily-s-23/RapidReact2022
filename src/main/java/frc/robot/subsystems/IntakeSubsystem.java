// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class IntakeSubsystem extends SubsystemBase {
     // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public DoubleSolenoid intakeArm=  new DoubleSolenoid(3,5);
 
    CANSparkMax intakeClose = new CANSparkMax(9);
    CANSparkMax intakeFar = new CANSparkMax(15);

    @Override
    public void initDefaultCommand() {
        intakeArm.set(Value.kForward);
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }


    public void closeIntakeSpin(double speed){
        intakeClose.set(ControlMode.PercentOutput, speed);
    }
    public void farIntakeSpin(double speed){
        intakeFar.set(ControlMode.PercentOutput, speed);
    }

}
