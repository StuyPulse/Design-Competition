package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Drivetrain;

import com.stuypulse.stuylib.math.*;

/**
 * Drivetrain command to move a certain distance and turn a certain angle.
 * (useful for autons)
 */
public class DrivetrainMoveCommand extends DrivetrainAlignCommand {

    private final double feet;
    private final Angle angle;

    public DrivetrainMoveCommand(Drivetrain swag, double feet, Angle angle) {
        super(swag);

        this.feet = feet;
        this.angle = angle;
    }

    public Angle getAngleError() {
        return angle;
    }

    public double getSpeedError() {
        return feet;
    }

}
