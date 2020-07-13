package com.stuypulse.frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import static com.stuypulse.frc.robot.Constants.kClimber.*;

import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class Climber extends SubsystemBase {

    private CANSparkMax sideA, sideB;

    private SpeedControllerGroup lift;

    public Climber() {

        sideA = new CANSparkMax(Ports.MOTOR_A, MotorType.kBrushless);
        sideB = new CANSparkMax(Ports.MOTOR_B, MotorType.kBrushless);

        lift = new SpeedControllerGroup(sideA, sideB);

        // motor initialization here

    }

    public void liftUp() {
        setLift(UP_SPEED);
    }

    public void liftDown() {
        setLift(DOWN_SPEED);
    }

    public void setLift(double value) {
        lift.set(value);
    }

    public void stop() {
        setLift(0);
    }

}
