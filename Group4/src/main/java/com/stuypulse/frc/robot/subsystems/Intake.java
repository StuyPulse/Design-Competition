package com.stuypulse.frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import static com.stuypulse.frc.robot.Constants.kIntake.*;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

    private CANSparkMax aMotor;

    private Solenoid aSolenoid, bSolenoid;

    public Intake () {
        //ports unknown fill in later
        aSolenoid = new Solenoid(Ports.SOLENOID_A);
        bSolenoid = new Solenoid(Ports.SOLENOID_B);

        aMotor = new CANSparkMax(Ports.MOTOR_A, MotorType.kBrushless);
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
