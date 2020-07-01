/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.stuypulse.frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.stuypulse.frc.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  CANSparkMax topLeftMotor;
  CANSparkMax topRightMotor;
  CANSparkMax middleLeftMotor;
  CANSparkMax middleRightMotor;
  CANSparkMax bottomLeftMotor;
  CANSparkMax bottomRightMotor;

  CANSparkMax[] leftMotors;
  CANSparkMax[] rightMotors;

  CANEncoder leftEncoder;
  CANEncoder rightEncoder;
  //i think the rev robotics docs broke
  public Drivetrain() {
    leftMotors = new CANSparkMax[] {
      topleftMotor = new CANSparkMax(, MotorType.kBrushless);
      middleleftMotor = new CANSparkMax(, MotorType.kBrushless);
      bottomleftMotor = new CANSparkMax(, MotorType.kBrushless);
    
    rightMotors = new CANSparkMax[] {
      toprightMotor = new CANSparkMax(, MotorType.kBrushless);
      middlerightMotor = new CANSparkMax(, MotorType.kBrushless);
      bottomrightMotor = new CANSparkMax(, MotorType.kBrushless);

    leftEncoder = new CANEncoder();
    rightEncoder = new CANEncoder();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
