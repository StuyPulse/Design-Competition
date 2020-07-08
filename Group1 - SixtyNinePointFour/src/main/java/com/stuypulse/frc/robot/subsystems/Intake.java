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
  DoubleSolenoid piston;
  CANSparkMax motor;
  DigitalInput button1;

  public Intake() {
    piston = new DoubleSolenoid(Ports.Intake.INTAKE_SOLENOID_FIRST_CHANNEL,Ports.Intake.INTAKE_SOLENOID_SECOND_CHANNEL);
    motor = new CANSparkMax(Ports.Intake.INTAKE_BUTTON, MotorType.kBrushless);
    button1 = new DigitalInput(Ports.Intake.INTAKE_BUTTON);
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
    piston.set(Value.kForward);
  }

  public void retract() {
    piston.set(Value.kReverse);
  }

  public boolean isBallDetected() {
    return button1.get();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
