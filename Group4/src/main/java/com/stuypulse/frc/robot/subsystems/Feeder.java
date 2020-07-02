package com.stuypulse.frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.stuypulse.frc.robot.Constants.kFeeder;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * - Feeder
  - 1 Motor
 */
public class Feeder extends SubsystemBase {
    private CANSparkMax aMotor;

    public Feeder() {
        aMotor = new CANSparkMax(kFeeder.Ports.MOTOR_A, MotorType.kBrushless);
    }

}
