package com.stuypulse.frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import static com.stuypulse.frc.robot.Constants.kClimber.*;

public class Climber extends SubsystemBase {

    private CANSparkMax aMotor;//, bMotor;

    public Climber() {

        aMotor = new CANSparkMax(Ports.MOTOR_A, MotorType.kBrushless);

        // 𐌁Motor is in jail until further notice

        // bMotor = new CANSparkMax(Ports.MOTOR_B, MotorType.kBrushless);

    }

    public void liftUp() {
        setLift(UP_SPEED);
    }

    public void liftDown() {
        setLift(DOWN_SPEED);
    }

    public void setLift(double value) {
        aMotor.set(value);
    }

    public void stop() {
        setLift(0);
    }

}
