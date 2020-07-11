package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ShooterStopFeedCommand extends CommandBase {
    private final Shooter shooter;

    public ShooterStopFeedCommand(Shooter shooter) {
        this.shooter = shooter;
        addRequirements(shooter);
    }

    public void initialize() {
        shooter.stopFeed();
    }
}