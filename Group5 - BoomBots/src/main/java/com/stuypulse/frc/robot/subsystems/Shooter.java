package com.stuypulse.frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.stuypulse.frc.robot.Constants.Ports;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {

    // Motors
    private CANSparkMax feederMotor;
    private CANSparkMax topShooterMotor;
    private CANSparkMax bottomShooterMotor;

    // Encoders
    private CANEncoder feederEncoder;
    private CANEncoder topShooterEncoder;
    private CANEncoder bottomShooterEncoder;

    // SpeedControllerGroup
    private SpeedControllerGroup shooterMotors;

    public Shooter() {
        feederMotor = new CANSparkMax(Ports.Shooter.FEEDER_PORT, MotorType.kBrushless);
        topShooterMotor = new CANSparkMax(Ports.Shooter.SHOOTER_TOP_PORT, MotorType.kBrushless);
        bottomShooterMotor = new CANSparkMax(Ports.Shooter.SHOOTER_BOTTOM_PORT, MotorType.kBrushless);

        feederEncoder = new CANEncoder(feederMotor);
        topShooterEncoder = new CANEncoder(topShooterMotor);
        bottomShooterEncoder = new CANEncoder(bottomShooterMotor);

        shooterMotors = new SpeedControllerGroup(topShooterMotor, bottomShooterMotor);
    }
    
    public double getMaxShooterVelocity() {
        return Math.max(topShooterEncoder.getVelocity(),bottomShooterEncoder.getVelocity());
    }

    public double getMinShooterVelocity() {
        return Math.min(topShooterEncoder.getVelocity(),bottomShooterEncoder.getVelocity());
    }

    public double getFeederVelocity() {
        return feederEncoder.getVelocity();
    }

    public void setShooterSpeed(double speed) {
        shooterMotors.set(speed);
    }

    public void feed() {
        feederMotor.set(Ports.Shooter.FEEDER_FEED_CONSTANT);
    }

    public void vomit() {
        feederMotor.set(-1 * Ports.Shooter.FEEDER_FEED_CONSTANT);
    }

    public void stopShooter() {
        shooterMotors.stopMotor();
    }

    public void stopFeeder() {
        feederMotor.stopMotor();
    }

}
