package com.stuypulse.frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.stuypulse.frc.robot.Constants.Ports;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
    private CANSparkMax leftFeeder;
    private CANSparkMax rightFeeder;
    private CANSparkMax leftShooter;
    private CANSparkMax rightShooter;

    public Shooter() {
        leftFeeder = new CANSparkMax(Ports.Shooter.LEFT_FEEDER, MotorType.kBrushless);
        rightFeeder = new CANSparkMax(Ports.Shooter.RIGHT_FEEDER, MotorType.kBrushless);
        leftShooter = new CANSparkMax(Ports.Shooter.LEFT_SHOOTER, MotorType.kBrushless);
        rightShooter = new CANSparkMax(Ports.Shooter.RIGHT_SHOOTER, MotorType.kBrushless);
    }

    public void feed() {
        leftFeeder.set(1);
        rightFeeder.set(1);
    }

    public void shoot() {
        leftShooter.set(1);
        rightShooter.set(1);
    }

    public void stopFeed() {
        leftFeeder.set(0);
        rightFeeder.set(0);
    }

    public void stopShoot() {
        leftShooter.set(0);
        rightShooter.set(0);
    }
}