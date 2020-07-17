package com.stuypulse.frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANEncoder;
import static com.stuypulse.frc.robot.Constants.kControlPanel.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Control panel subsytem that spins the control panel. It doesn't have a color
 * sensor but if the encoder is used correctly it should return rotations, which
 * allows for control over how many spins with PID.
 */
public class ControlPanel extends SubsystemBase {
    private CANSparkMax aMotor;

    private CANEncoder aEncoder;

    public ControlPanel() {
        aMotor = new CANSparkMax(Ports.MOTOR_A, MotorType.kBrushless);
        aEncoder = aMotor.getEncoder();

        resetEncoder();
        setEncoderFactor(NEO_FACTOR_TO_ROTATIONS);

        // motor initialization
    }

    public void spin(double speed) {
        aMotor.set(speed);
    }

    public void spin() {
        spin(SPIN_SPEED);
    }

    public double getRotations() {
        return aEncoder.getPosition();
    }

    public void setEncoderFactor(double factor) {
        aEncoder.setPositionConversionFactor(factor);
    }

    public void resetEncoder() {
        aEncoder.setPosition(0);
    }

    public void stop() {
        spin(0);
    }

}
