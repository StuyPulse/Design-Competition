package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.InstantCommand;

public class ShooterUpdateCommand extends InstantCommand {

    private final double goalRPM;

    private final Shooter shooter;

    public ShooterUpdateCommand(Shooter shooter, double rpm) {
        goalRPM = rpm;
        this.shooter = shooter;
    }

    @Override
    public void initialize() {
        shooter.setTargetRPM(goalRPM);
    }

}
