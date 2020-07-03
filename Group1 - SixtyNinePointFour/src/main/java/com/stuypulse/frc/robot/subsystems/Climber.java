/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.stuypulse.frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.stuypulse.frc.robot.Constants.Ports;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climber extends SubsystemBase {
  CANSparkMax leftMotor;
  CANSparkMax rightMotor;
  public Climber() {
    leftMotor = new CANSparkMax(Ports.CLIMBER_LEFT_MOTOR, kbrushless);
    rightMotor = new CANSparkMax(Ports.CLIMBER_RIGHT_MOTOR, kbrushless);
  }
  public void PUSHSSHSHHSHHS() {
    leftMotor.set(1);
    rightMotor.set(1);
  }

  public void STOPOPODPOPSDFDSJFISDPI() {
    leftMotor.set(-1);
    rightMotor.set(-1);
  }

  public void SDSOIOIOTEOWOUDUFUioirfhuioreufreuifuer() {
    leftMotor.set(0);
    rightMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
