package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.InstantCommand;

/**
 * Sets the target RPM of the shooter.
 */
public class ShooterUpdateCommand extends InstantCommand {

    private final double goalRPM;

    protected final Shooter shooter;

    public ShooterUpdateCommand(Shooter shooter, double rpm) {
        this.shooter = shooter;

        goalRPM = rpm;

        addRequirements(shooter);
    }

    @Override
    public void initialize() {
        shooter.setTargetRPM(goalRPM);
    }

}
