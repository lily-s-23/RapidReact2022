// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;

public class ConveyorBeltSubsystem extends SubsystemBase {
  CANSparkMax motor;
  RelativeEncoder encoder;
  /** Creates a new ConveyorBeltSubsystem. */
  public ConveyorBeltSubsystem() {
    

    //need edit: 0
    motor = new CANSparkMax(0, MotorType.kBrushless);



    encoder = motor.getEncoder();
  }

  //input: desired speed for conveyor belt going forward
  public void setMotorSpeed(double speed) {
    motor.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
