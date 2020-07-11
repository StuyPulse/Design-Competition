/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.stuypulse.frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.stuypulse.frc.robot.Constants.Ports;

public class Intake extends SubsystemBase {
  private DoubleSolenoid leftPiston;
  private DoubleSolenoid rightPiston;
  private CANSparkMax motor;
  private DigitalInput button;

  public Intake() {
    leftPiston = new DoubleSolenoid(Ports.Intake.LEFT_INTAKE_SOLENOID_A,Ports.Intake.LEFT_INTAKE_SOLENOID_B);
    rightPiston = new DoubleSolenoid(Ports.Intake.RIGHT_INTAKE_SOLENOID_A,Ports.Intake.RIGHT_INTAKE_SOLENOID_B);
    motor = new CANSparkMax(Ports.Intake.INTAKE_BUTTON, MotorType.kBrushless);
    button = new DigitalInput(Ports.Intake.INTAKE_BUTTON);
  }
  
  public void acquire() {
    motor.set(1);
  }

  public void deacquire() {
    motor.set(-1);
  }

  public void stop() {
    motor.set(0);

  }
  public void extend() {
    leftPiston.set(Value.kForward);
    rightPiston.set(Value.kForward);
  }

  public void retract() {
    leftPiston.set(Value.kReverse);
    rightPiston.set(Value.kReverse);
  }

  public boolean isBallDetected() {
    return button.get();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
