package com.stuypulse.frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


import com.stuypulse.frc.robot.Constants.kShooter;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {

    private CANSparkMax aMotor,bMotor,cMotor;

    public Shooter() {

        aMotor = new CANSparkMax(kShooter.Ports.MOTOR_A, MotorType.kBrushless);
        bMotor = new CANSparkMax(kShooter.Ports.MOTOR_B, MotorType.kBrushless);
        cMotor = new CANSparkMax(kShooter.Ports.MOTOR_C, MotorType.kBrushless);

    }
}
