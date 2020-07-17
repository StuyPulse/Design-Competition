package com.stuypulse.frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import static com.stuypulse.frc.robot.Constants.kShooter.*;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import com.revrobotics.CANEncoder;

import java.util.Arrays;

import com.stuypulse.stuylib.control.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {

    private CANSparkMax feeder;

    private CANSparkMax aMotor, bMotor, cMotor;

    private CANEncoder aEncoder, bEncoder, cEncoder, feederEncoder;

    private SpeedControllerGroup shooterMotors;

    private double targetRPM;

    public Shooter() {

        aMotor = new CANSparkMax(Ports.MOTOR_A, MotorType.kBrushless);
        bMotor = new CANSparkMax(Ports.MOTOR_B, MotorType.kBrushless);
        cMotor = new CANSparkMax(Ports.MOTOR_C, MotorType.kBrushless);

        aEncoder = aMotor.getEncoder();
        bEncoder = bMotor.getEncoder();
        cEncoder = cMotor.getEncoder();

        shooterMotors = new SpeedControllerGroup(aMotor, bMotor, cMotor);

        feeder = new CANSparkMax(Ports.FEEDER_MOTOR, MotorType.kBrushless);
        feederEncoder = feeder.getEncoder();

        targetRPM = 0.0;

        // do motor initialization here

    }

    public void setTargetRPM(double rpm) {
        targetRPM = rpm;
    }

    public double getTargetRPM() {
        return targetRPM;
    }

    private double getMedianShooterRPM() {
        double[] vels = { aEncoder.getVelocity(), bEncoder.getVelocity(), cEncoder.getVelocity() };
        Arrays.sort(vels);
        return vels[1];
    }

    public double getShooterRPM() {
        // choose algorithm to get rpm of the 3 motors here
        return getMedianShooterRPM();
    }

    public double getFeederRPM() {
        return feederEncoder.getVelocity();
    }

    public void setShooter(double value) {
        shooterMotors.set(value);
    }

    public void setFeeder(double value) {
        feeder.set(value);
    }

    public void stopFeeder() {
        setFeeder(0);
    }

    public void stopShooter() {
        setShooter(0);
    }

}
