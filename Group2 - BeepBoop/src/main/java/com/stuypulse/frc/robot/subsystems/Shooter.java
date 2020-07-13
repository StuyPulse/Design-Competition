package com.stuypulse.frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.stuypulse.frc.robot.Constants;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
    private CANSparkMax leftShooterMotor;
    private CANSparkMax midShooterMotor;
    private CANSparkMax rightShooterMotor;

    private SpeedControllerGroup shooterMotors;

    private CANSparkMax feederMotor;

    public Shooter() {
        leftShooterMotor = new CANSparkMax(Constants.Shooter.LEFT_SHOOTER_MOTOR_PORT, MotorType.kBrushless);
        midShooterMotor = new CANSparkMax(Constants.Shooter.MID_SHOOTER_MOTOR_PORT, MotorType.kBrushless);
        rightShooterMotor = new CANSparkMax(Constants.Shooter.RIGHT_SHOOTER_MOTOR_PORT, MotorType.kBrushless); 

        leftShooterMotor.setInverted(true);

        leftShooterMotor.setIdleMode(IdleMode.kCoast);
        midShooterMotor.setIdleMode(IdleMode.kCoast);
        rightShooterMotor.setIdleMode(IdleMode.kCoast);

        shooterMotors = new SpeedControllerGroup(leftShooterMotor,midShooterMotor, rightShooterMotor);

        feederMotor = new CANSparkMax(Constants.Shooter.FEEDER_MOTOR_PORT, MotorType.kBrushless);
        feederMotor.setInverted(true);
    }

    public void shoot(double speed) {
        shooterMotors.set(speed);
    }
    
    public void stopShooter() {
        shooterMotors.set(0);
    }

    public void feed(double speed) {
        feederMotor.set(speed);
    }

    public void stopFeeder() {
        feederMotor.set(0); 
    }
}