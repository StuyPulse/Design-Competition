package com.stuypulse.frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import com.stuypulse.frc.robot.Constants.kShooter;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import com.revrobotics.CANEncoder;

import com.stuypulse.stuylib.control.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {

    private CANSparkMax feeder;

    private CANSparkMax aMotor,bMotor,cMotor;

    private CANEncoder aEncoder, bEncoder, cEncoder, feederEncoder;

    private SpeedControllerGroup shooterMotors;

    private double targetRPM;

    private Controller shooterController;
    private Controller feederController;

    public Shooter() {

        aMotor = new CANSparkMax(kShooter.Ports.MOTOR_A, MotorType.kBrushless);
        bMotor = new CANSparkMax(kShooter.Ports.MOTOR_B, MotorType.kBrushless);
        cMotor = new CANSparkMax(kShooter.Ports.MOTOR_C, MotorType.kBrushless);

        aEncoder = aMotor.getEncoder();
        bEncoder = bMotor.getEncoder();
        cEncoder = cMotor.getEncoder();

        shooterMotors = new SpeedControllerGroup(aMotor, bMotor, cMotor);

        feeder = new CANSparkMax(kShooter.Ports.FEEDER_MOTOR, MotorType.kBrushless);
        feederEncoder = feeder.getEncoder();

        targetRPM = 0.0;

        //
        shooterController = new PIDController(0,0,0);
        feederController = new PIDController(0,0,0);

        // do motor initialization here
    }

    public void setTargetRPM(double rpm) {
        targetRPM = rpm;
    }

    public double getTargetRPM() {
        return targetRPM;
    }

    public double getRPM() {
        return 0.0; // encoder value
    }

    public void setShooter(double value) {
        // set shooter motors to some value
    }

    public void stopShooter() {
        setShooter(0);
    }

    @Override
    public void periodic() {

        // do some checks if it's done
        double shooterError = shooterController.update(targetRPM - getRPM());

        setShooter(shooterError);

    }
}
