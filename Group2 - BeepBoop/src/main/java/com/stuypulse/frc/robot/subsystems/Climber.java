package com.stuypulse.frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.stuypulse.frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climber extends SubsystemBase {
    private WPI_TalonSRX motor;

    public Climber() {
        motor = new WPI_TalonSRX(Constants.Ports.Climber.CLIMBER);
    }

    public void climb(double speed) {
        motor.set(speed);
    }

    public void stop() {
        motor.set(0);
    }
    
}