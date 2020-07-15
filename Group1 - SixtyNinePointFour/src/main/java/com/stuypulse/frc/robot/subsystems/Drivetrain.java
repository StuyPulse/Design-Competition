/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.stuypulse.frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.stuypulse.frc.robot.Constants.ConversionConstants;
import com.stuypulse.frc.robot.Constants.Ports;
import com.stuypulse.stuylib.math.Angle;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

  public static enum Gear {
    HIGH, LOW
  };

  private CANSparkMax[] leftMotors;
  private CANSparkMax[] rightMotors;

  private CANEncoder leftEncoder;
  private CANEncoder rightEncoder;

  private Gear gear;
  private Solenoid leftGearShift;
  private Solenoid rightGearShift;

  // remove
  private DifferentialDrive highGearDrive;
  private DifferentialDrive lowGearDrive;

  private AHRS navx;

  public Drivetrain() {
    leftMotors = new CANSparkMax[] {
      new CANSparkMax(Ports.Drivetrain.DRIVETRAIN_TOP_LEFT_MOTOR, MotorType.kBrushless),
      new CANSparkMax(Ports.Drivetrain.DRIVETRAIN_MIDDLE_LEFT_MOTOR, MotorType.kBrushless),
      new CANSparkMax(Ports.Drivetrain.DRIVETRAIN_BOTTOM_LEFT_MOTOR, MotorType.kBrushless)
    };
    
    rightMotors = new CANSparkMax[] {
      new CANSparkMax(Ports.Drivetrain.DRIVETRAIN_TOP_LEFT_MOTOR, MotorType.kBrushless),
      new CANSparkMax(Ports.Drivetrain.DRIVETRAIN_MIDDLE_RIGHT_MOTOR, MotorType.kBrushless),
      new CANSparkMax(Ports.Drivetrain.DRIVETRAIN_BOTTOM_RIGHT_MOTOR, MotorType.kBrushless)
    };

    highGearDrive = new DifferentialDrive(
            new SpeedControllerGroup(leftMotors[0], leftMotors[1], leftMotors[2]),
            new SpeedControllerGroup(rightMotors[0], rightMotors[1], rightMotors[2])
        );

    lowGearDrive = highGearDrive;

    leftEncoder = leftMotors[1].getEncoder();
    rightEncoder = rightMotors[1].getEncoder();

    leftEncoder.setPosition(0);
    rightEncoder.setPosition(0);

    leftGearShift = new Solenoid(Ports.Drivetrain.LEFT_GEAR_SHIFT);
    rightGearShift = new Solenoid(Ports.Drivetrain.RIGHT_GEAR_SHIFT);
  }
  
  public Gear getGear() {
    return gear;
  }

  public void setLowGear() {
    if (gear != Gear.LOW) {
      gear = Gear.LOW;
      leftGearShift.set(false);
      rightGearShift.set(false);
    }
  }

  public void setHighGear() {
    if (gear != Gear.HIGH) {
      gear = Gear.HIGH;
      leftGearShift.set(true);
      rightGearShift.set(true);
    }
  }

  public AHRS getNavX() {
    return navx;
  }
  
  public Angle getGyroAngle() {
    return Angle.degrees(navx.getAngle());
  }

  public double getRawLeftEncoderDistance() {
    return leftEncoder.getPosition();
  }

  public double getRawRightEncoderDistance() {
    return rightEncoder.getPosition();
  }

  public double getRawDistance() {
    return Math.abs(Math.max(getRawLeftEncoderDistance(), getRawRightEncoderDistance()));
  }

  public double getDistance() {
    return getRawDistance() * ConversionConstants.Drivetrain.ENCODER_DISTANCE_TO_FEET;
  }

  public DifferentialDrive getCurrentDrive() {
    if (gear == Gear.HIGH) {
        return highGearDrive;
    } else {
        return lowGearDrive;
    }
}

  public void stop() {
    getCurrentDrive().tankDrive(0, 0);
  }

  public void arcadeDrive(double speed, double rotation) {
    getCurrentDrive().arcadeDrive(speed, rotation);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
