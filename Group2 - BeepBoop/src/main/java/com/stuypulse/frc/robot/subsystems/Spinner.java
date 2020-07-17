package com.stuypulse.frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.stuypulse.frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Spinner extends SubsystemBase {
    private CANSparkMax motor;
    private CANEncoder neoEncoder;

    public Spinner() {
        motor = new CANSparkMax(Constants.Spinner.MOTOR_PORT, MotorType.kBrushless);
        neoEncoder = motor.getEncoder();
    }

    public void spin(double speed) {
        motor.set(speed);
    }

    public void stop() {
        motor.set(0);
    }

    public double getNeoEncoder() {
        return neoEncoder.getPosition();
    }

    public void resetNeoEncoder() {
        neoEncoder.setPosition(0);
    }
}