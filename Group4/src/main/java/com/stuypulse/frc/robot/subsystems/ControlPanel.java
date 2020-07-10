package com.stuypulse.frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.stuypulse.frc.robot.Constants.kControlPanel;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * - Control Panel
  - 1 Motor
 */
public class ControlPanel extends SubsystemBase{
    private CANSparkMax aMotor;

    public ControlPanel () {
        aMotor = new CANSparkMax(kControlPanel.Ports.MOTOR_A, MotorType.kBrushless);
    }

    public void spin() {
        aMotor.set(kControlPanel.SPIN_SPEED);
    }

    public void stop() {
        aMotor.set(0);
    }

}
