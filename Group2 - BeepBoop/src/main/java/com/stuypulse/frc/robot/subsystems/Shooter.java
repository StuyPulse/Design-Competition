package com.stuypulse.frc.robot.subsystems;

import java.util.Arrays;

import com.revrobotics.CANEncoder;
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

    private CANEncoder leftShooterEncoder;
    private CANEncoder midShooterEncoder;
    private CANEncoder rightShooterEncoder;

    private SpeedControllerGroup shooterMotors;

    private CANSparkMax feederMotor;
    private CANEncoder feederEncoder; 

    public Shooter() {
        leftShooterMotor = new CANSparkMax(Constants.Shooter.LEFT_SHOOTER_MOTOR_PORT, MotorType.kBrushless);
        midShooterMotor = new CANSparkMax(Constants.Shooter.MID_SHOOTER_MOTOR_PORT, MotorType.kBrushless);
        rightShooterMotor = new CANSparkMax(Constants.Shooter.RIGHT_SHOOTER_MOTOR_PORT, MotorType.kBrushless); 

        leftShooterMotor.setInverted(true);

        leftShooterMotor.setIdleMode(IdleMode.kCoast);
        midShooterMotor.setIdleMode(IdleMode.kCoast);
        rightShooterMotor.setIdleMode(IdleMode.kCoast);
        
        leftShooterEncoder = leftShooterMotor.getEncoder(); 
        midShooterEncoder = midShooterMotor.getEncoder();
        rightShooterEncoder = rightShooterMotor.getEncoder();

        shooterMotors = new SpeedControllerGroup(leftShooterMotor, midShooterMotor, rightShooterMotor);

        feederMotor = new CANSparkMax(Constants.Shooter.FEEDER_MOTOR_PORT, MotorType.kBrushless);
        feederMotor.setInverted(true);

        feederEncoder = feederMotor.getEncoder();
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

    public double getShooterVoltage() {
        // TODO: account for other motors 
        return leftShooterMotor.getBusVoltage(); 
    }

    public void setShooterVoltage(double volts) {
        shooterMotors.setVoltage(volts);
    }

    public double getMedianShooterRPM() {
        double[] speed = {
            leftShooterEncoder.getVelocity(), 
            midShooterEncoder.getVelocity(), 
            rightShooterEncoder.getVelocity()
        }; 
        Arrays.sort(speed); 
        return speed[1]; 
    }

    public double getFeederRPM() {
        return feederEncoder.getVelocity(); 
    }
}