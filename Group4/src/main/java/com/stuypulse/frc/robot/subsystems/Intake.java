package com.stuypulse.frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


import com.stuypulse.frc.robot.Constants.kIntake;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

    private CANSparkMax aMotor;

    //(a,b) placeholders for now
    private Solenoid aSolenoid, bSolenoid;

    public Intake () {
        //ports unknown fill in later
        aSolenoid = new Solenoid(kIntake.Ports.SOLENOID_A);
        bSolenoid = new Solenoid(kIntake.Ports.SOLENOID_B);

        aMotor = new CANSparkMax(kIntake.Ports.MOTOR_A, MotorType.kBrushless);
    }

    public void acquire() {
        set(kIntake.INTAKE_SPEED);
    }

    public void deacquire() {
        set(-kIntake.INTAKE_SPEED);
    }

    public void stop() {
        set(0);
    }

    private void set(double value) {
        aMotor.set(value);
    }

}
