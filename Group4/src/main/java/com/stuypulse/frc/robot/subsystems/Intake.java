package com.stuypulse.frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import static com.stuypulse.frc.robot.Constants.kIntake.*;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

    // TODO: which direction is forward and which is back

    private CANSparkMax aMotor;

    private DoubleSolenoid hoodSolenoid;

    public Intake () {
        hoodSolenoid = new DoubleSolenoid(Ports.SOLENOID_A, Ports.SOLENOID_B);

        aMotor = new CANSparkMax(Ports.MOTOR_A, MotorType.kBrushless);
    }

    public void extend() {
        hoodSolenoid.set(Value.kForward);
    }

    public void retract() {
        hoodSolenoid.set(Value.kReverse);
    }

    public void acquire() {
        set(INTAKE_SPEED);
    }

    public void deacquire() {
        set(-INTAKE_SPEED);
    }

    public void stop() {
        set(0);
    }

    private void set(double value) {
        aMotor.set(value);
    }

}
