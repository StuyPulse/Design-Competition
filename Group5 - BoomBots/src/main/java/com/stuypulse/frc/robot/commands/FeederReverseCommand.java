package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class FeederReverseCommand extends CommandBase {

    private final Shooter shooter;

    public FeederReverseCommand(Shooter shooter) {
        this.shooter = shooter;
        addRequirements(shooter);
    }

    public void execute() {
        shooter.vomit();
    }

    public void end() {
        shooter.stopFeeder();
    }
    
}