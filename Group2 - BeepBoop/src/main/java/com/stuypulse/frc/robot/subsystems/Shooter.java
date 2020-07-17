package com.stuypulse.frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.stuypulse.frc.robot.Constants;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {

    private WPI_TalonSRX motorA; 
    private WPI_TalonSRX motorB; 

    private SpeedControllerGroup shooterMotors;

    public Shooter() {
        motorA = new WPI_TalonSRX(Constants.Shooter.MOTOR_A_PORT);
        motorB = new WPI_TalonSRX(Constants.Shooter.MOTOR_B_PORT);

        motorB.setInverted(true);

        shooterMotors = new SpeedControllerGroup(motorA, motorB);

        motorA.setNeutralMode(NeutralMode.Coast);
        motorB.setNeutralMode(NeutralMode.Coast);

        motorA.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0);
        motorB.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0); 
    }

    public void shoot(double speed) {
        shooterMotors.set(speed);
    }
    
    public void stopShooter() {
        shooterMotors.set(0);
    }

    public double getShooterVoltage() {
        return (motorA.getBusVoltage()
            + motorB.getBusVoltage()) / 2;
    }

    public void setShooterVoltage(double volts) {
        shooterMotors.setVoltage(volts);
    }

    public double getShooterRPM() {
        return (motorA.getSelectedSensorVelocity(0)
            + motorB.getSelectedSensorVelocity(0)) / 2; 
    }
}