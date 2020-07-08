package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ShooterControlCommand extends CommandBase {

    private final Shooter shooter;
    private final double motorValue;

    public ShooterControlCommand(Shooter shooter, double motorValue) {
        this.shooter = shooter;
        this.motorValue = motorValue;
    }

    @Override
    public void initialize() {
        shooter.setShooter(motorValue);
    }

    @Override
    public void end(boolean interrupted) {
        shooter.stopShooter();
    }

}
