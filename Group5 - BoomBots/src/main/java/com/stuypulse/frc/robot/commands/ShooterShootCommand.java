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

    public void execute() {
        shooter.setShooterSpeed(Constants.Shooter.SHOOTER_TARGET_VELOCITY);
    }

    public void end() {
        shooter.stopShooter();
    }
    
}