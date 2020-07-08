package com.stuypulse.frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import com.stuypulse.frc.robot.Constants.kShooter;

import com.stuypulse.stuylib.control.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {

    private CANSparkMax aMotor,bMotor,cMotor;

    private double targetRPM;

    private Controller shooterController;

    public Shooter() {

        aMotor = new CANSparkMax(kShooter.Ports.MOTOR_A, MotorType.kBrushless);
        bMotor = new CANSparkMax(kShooter.Ports.MOTOR_B, MotorType.kBrushless);
        cMotor = new CANSparkMax(kShooter.Ports.MOTOR_C, MotorType.kBrushless);

        targetRPM = 0.0;

        shooterController = new PIDController(0,0,0);
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
