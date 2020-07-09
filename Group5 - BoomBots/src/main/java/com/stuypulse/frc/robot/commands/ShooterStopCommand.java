package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ShooterStopCommand extends CommandBase {

    private final Shooter shooter;

    public ShooterStopCommand(Shooter shooter) {
        this.shooter = shooter;
        addRequirements(shooter);
    }

    public void execute() {
        shooter.stopShooter();
    }

}
