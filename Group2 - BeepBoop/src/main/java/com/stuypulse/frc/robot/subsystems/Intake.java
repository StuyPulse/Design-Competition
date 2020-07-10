/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.stuypulse.frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.stuypulse.frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  private CANSparkMax motor; 
  private CANEncoder neoEncoder; 
  
  public Intake() {
    motor = new CANSparkMax(Constants.Ports.Intake.MOTOR, MotorType.kBrushless); 
    neoEncoder = motor.getEncoder(); 
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void acquire(double speed) {
    motor.set(speed);
  }

  public void deacquire(double speed) {
    acquire(-speed); 
  }

  public void stop() {
    motor.set(0); 
  }

  public double getNeoEncoder() {
    return neoEncoder.getPosition(); 
  }

  public void resetNeoEncoder() {
    neoEncoder.setPosition(0); 
  }
}
