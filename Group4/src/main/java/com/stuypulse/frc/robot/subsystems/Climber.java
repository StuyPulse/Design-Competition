package com.stuypulse.frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import static com.stuypulse.frc.robot.Constants.kClimber.*;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Climber extends SubsystemBase {

    private CANSparkMax winder;
    private CANEncoder encoder;
    private DoubleSolenoid brake;

    public Climber() {

        winder = new CANSparkMax(Ports.MOTOR_A, MotorType.kBrushless);
        encoder = winder.getEncoder();

        brake = new DoubleSolenoid(Ports.SOLENOID_A, Ports.SOLENOID_B);

        // motor initialization here

        resetEncoders();
        setEncoderFactor(NEO_CONVERSION_TO_FEET);

    }

    private void resetEncoders() {
        encoder.setPosition(0);
    }

    private void setEncoderFactor(double factor) {
        encoder.setPositionConversionFactor(factor);
    }

    public double getDistance() {
        return encoder.getPosition();
    }

    public void liftUp() {
        setLift(UP_SPEED);
    }

    public void liftDown() {
        setLift(DOWN_SPEED);
    }

    public void setBrake(DoubleSolenoid.Value value) {
        brake.set(value);
    }

    public void setBrake() {
        setBrake(DoubleSolenoid.Value.kForward);
    }

    public void retractBrake() {
        setBrake(DoubleSolenoid.Value.kReverse);
    }

    public void setLift(double value) {
        winder.set(value);
    }

    public void stop() {
        setLift(0);
    }

}
