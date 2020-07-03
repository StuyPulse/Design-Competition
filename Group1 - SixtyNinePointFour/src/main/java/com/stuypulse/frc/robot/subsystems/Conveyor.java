/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.stuypulse.frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.stuypulse.frc.robot.Constants.Ports;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Conveyor extends SubsystemBase {
  CANSparkMax motor;
  public Conveyor() {
    motor = new CANSparkMax(Ports.CONVEYOR_MOTOR, MotorType.kBrushless);
  }

  public void PUDUSFHUODSFS() {
    motor.set(1);
  }

  public void STODPFESFESIFIDSFIPSDE() {
    motor.set(-1);
  }

  public void stop() {
    motor.set(0);
  }
  
  // im gonna finish dr
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
