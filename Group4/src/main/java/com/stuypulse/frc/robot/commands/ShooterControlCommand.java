package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * This is a command specifically for a gamepad bind that just interrupts the
 * tuning to allow for something like a reversal or a speed up. Once the command
 * ends it should go back to tuning.
 */
public class ShooterControlCommand extends CommandBase {

    private final Shooter shooter;

    private final double motorValue;

    public ShooterControlCommand(Shooter shooter, double motorValue) {
        this.shooter = shooter;

        this.motorValue = motorValue;

        addRequirements(shooter);
    }

    @Override
    public void execute() {
        shooter.setShooter(motorValue);
        shooter.setFeeder(motorValue);
    }

    @Override
    public void end(boolean i) {
        shooter.stopShooter();
        shooter.stopFeeder();
    }

}
