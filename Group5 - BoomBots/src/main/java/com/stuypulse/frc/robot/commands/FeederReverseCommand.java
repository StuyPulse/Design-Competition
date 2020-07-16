package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class FeederReverseCommand extends CommandBase {

    private final Shooter shooter;

    public FeederReverseCommand(Shooter shooter) {
        this.shooter = shooter;
        addRequirements(shooter);
    }

    @Override
    public void execute() {
        shooter.vomit();
    }

    @Override
    public void end(boolean interrupted) {
        shooter.stopFeeder();
    }
    
}