package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class FeederFeedCommand extends CommandBase {

    private final Shooter shooter;

    public FeederFeedCommand(Shooter shooter) {
        this.shooter = shooter;
        addRequirements(shooter);
    }

    public void execute() {
        shooter.feed();
    }

    public void end() {
        shooter.stopFeeder();
    }
}