package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ShooterFeedCommand extends CommandBase {
    private final Shooter shooter;

    public ShooterFeedCommand(Shooter shooter) {
        this.shooter = shooter;
        addRequirements(shooter);
    }

    public void initialize() {
        shooter.feed();
    }

    public void end(boolean interrupted) {
        shooter.stopFeed();
    }
}