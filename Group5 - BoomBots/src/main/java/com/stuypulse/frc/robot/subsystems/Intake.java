package com.stuypulse.frc.robot.subsystems;

import com.stuypulse.frc.robot.Constants.Ports;

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
        motor = new Talon(Ports.Intake.INTAKE_MOTOR_PORT);
        solenoid = new DoubleSolenoid(Ports.Intake.INTAKE_SOLENOID_CHANNEL_A,Ports.Intake.INTAKE_SOLENOID_CHANNEL_B);
        sensor = new DigitalInput(Ports.Intake.INTAKE_SENSOR_PORT);
    }

    public void acquire() {
        motor.set(Ports.Intake.INTAKE_MOTOR_ACQUIRE_SPEED);
    }

    public void deacquire() {
        motor.set(-1 * Ports.Intake.INTAKE_MOTOR_ACQUIRE_SPEED);
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