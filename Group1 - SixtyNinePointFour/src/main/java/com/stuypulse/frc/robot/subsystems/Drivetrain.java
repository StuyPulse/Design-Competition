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

// ill d
//also do I need to git clone stuypulse stuylib
// anything else so i do
// no cuz like im getting an error for the tank d
//
import com.stuypulse.frc.robot.Constants;
import com.stuypulse.frc.robot.Constants.Ports;
import com.stuypulse.stuylib.util.TankDriveEncoder;

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

  private TankDriveEncoder TankDrive;
  // nvm
  //also edwin has a buncha weird stuff idk how works like high gear and stuff
  public Drivetrain() {
    leftMotors = new CANSparkMax[] {
      topleftMotor = new CANSparkMax(Ports.DRIVETRAIN_TOP_LEFT_MOTOR, MotorType.kBrushless); //my constants is broken :(
      middleleftMotor = new CANSparkMax(Ports.DRIVETRAIN_MIDDLE_LEFT_MOTOR, MotorType.kBrushless);
      bottomleftMotor = new CANSparkMax(Ports.DRIVETRAIN_BOTTOM_LEFT_MOTOR, MotorType.kBrushless);
    
    rightMotors = new CANSparkMax[] {
      toprightMotor = new CANSparkMax(Ports.DRIVETRAIN_TOP_LEFT_MOTOR, MotorType.kBrushless);
      middlerightMotor = new CANSparkMax(Ports.DRIVETRAIN_MIDDLE_RIGHT_MOTOR, MotorType.kBrushless);
      bottomrightMotor = new CANSparkMax(Ports.DRIVETRAIN_BOTTOM_RIGHT_MOTOR, MotorType.kBrushless);

    leftEncoder = leftMotors[].CANEncoder();
    rightEncoder = rightMotors[].CANEncoder();
  }
  public void forward() {
    leftMotors.set(1);
    rightMotors.set(1);
  }
  public void reverse() {
    leftMotors.set(-1);
    rightMotors.set(-1);
  }
  public void left() {
    leftMotors.set(-1);
    rightMotors.set(1);
  }
  public void right() {
    leftMotors.set(1);
    rightMotors.set(-1);
  }
  public void stop() {
    leftMotors.set(0);
    rightMotors.set(0);
  }
  public double leftDistance() {
    return leftEncoder.getPosition();
  }
  public double rightDistance() {
    return rightEncoder.getPosition();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
