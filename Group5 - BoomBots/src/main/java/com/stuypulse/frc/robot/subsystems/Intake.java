package com.stuypulse.frc.robot.subsystems;

import com.stuypulse.frc.robot.Constants;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    
    private Talon motor;
    private DoubleSolenoid solenoid;
    private DigitalInput sensor;

    public Intake() {
        motor = new Talon(Constants.Intake.INTAKE_MOTOR_PORT);
        solenoid = new DoubleSolenoid(Constants.Intake.INTAKE_SOLENOID_CHANNEL_A,Constants.Intake.INTAKE_SOLENOID_CHANNEL_B);
        sensor = new DigitalInput(Constants.Intake.INTAKE_SENSOR_PORT);
    }

    public void acquire() {
        motor.set(Constants.Intake.INTAKE_MOTOR_ACQUIRE_SPEED);
    }

    public void deacquire() {
        motor.set(-1 * Constants.Intake.INTAKE_MOTOR_ACQUIRE_SPEED);
    }

    public void stop() {
        motor.stopMotor();
    }

    public void extend() {
        solenoid.set(Value.kForward);
    }

    public void retract() {
        solenoid.set(Value.kReverse);
    }

    public boolean isBallDetected() {
        return sensor.get();
    }
    
}