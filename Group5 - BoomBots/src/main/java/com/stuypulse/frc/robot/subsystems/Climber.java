package com.stuypulse.frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.stuypulse.frc.robot.Constants;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climber extends SubsystemBase {
    
    private CANSparkMax leftMotor;
    private CANSparkMax rightMotor;

    private SpeedControllerGroup liftMotors;

    public Climber() {
        leftMotor = new CANSparkMax(Constants.Climber.CLIMBER_LEFT_MOTOR_PORT, MotorType.kBrushless);
        rightMotor = new CANSparkMax(Constants.Climber.CLIMBER_RIGHT_MOTOR_PORT, MotorType.kBrushless);

        liftMotors = new SpeedControllerGroup(leftMotor, rightMotor);
    }

    public void climb(double speed) {
        liftMotors.set(speed);
    }

    public void climbUp() {
        climb(Constants.Climber.CLIMBER_LIFT_UP_SPEED);
    }

    public void climbDown() {
        climb(Constants.Climber.CLIMBER_LIFT_DOWN_SPEED);
    }

    public void stop() {
        climb(0);
    }
    
}

