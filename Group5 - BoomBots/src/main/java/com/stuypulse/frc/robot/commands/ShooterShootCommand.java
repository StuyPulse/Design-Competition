package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.Constants;
import com.stuypulse.frc.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ShooterShootCommand extends CommandBase {

    private final Shooter shooter;

    public ShooterShootCommand(Shooter shooter) {
        this.shooter = shooter;
        addRequirements(shooter);
    }

    @Override
    public void execute() {
        shooter.setShooterSpeed(Constants.Shooter.SHOOTER_TARGET_VELOCITY);
    }

    @Override
    public void end(boolean interrupted) {
        shooter.stopShooter();
    }
    
}