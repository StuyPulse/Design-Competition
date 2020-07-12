package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Shooter;

/**
 * Sets the target RPM to 0 and stops the motors.
 */
public class ShooterStopCommand extends ShooterUpdateCommand {

    public ShooterStopCommand(Shooter shooter) {
        super(shooter, 0);
    }

    @Override
    public void initialize() {
        super.initialize();

        shooter.stopShooter();
        shooter.stopFeeder();
    }

}
