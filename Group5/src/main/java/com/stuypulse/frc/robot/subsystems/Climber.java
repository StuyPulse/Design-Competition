package com.stuypulse.frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.stuypulse.frc.robot.Constants.Ports;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climber extends SubsystemBase {
    
    private CANSparkMax leftMotor;
    private CANSparkMax rightMotor;

    private SpeedControllerGroup liftMotors;

    public Climber() {
        leftMotor = new CANSparkMax(Ports.Climber.CLIMBER_LEFT_MOTOR_PORT, MotorType.kBrushless);
        rightMotor = new CANSparkMax(Ports.Climber.CLIMBER_RIGHT_MOTOR_PORT, MotorType.kBrushless);

        liftMotors = new SpeedControllerGroup(leftMotor, rightMotor);
    }

    public void climb(double speed) {
        liftMotors.set(speed);
    }

    public void climbUp() {
        climb(Ports.Climber.CLIMBER_LIFT_UP_SPEED);
    }

    public void climbDown() {
        climb(Ports.Climber.CLIMBER_LIFT_DOWN_SPEED);
    }

    public void stop() {
        climb(0);
    }
}