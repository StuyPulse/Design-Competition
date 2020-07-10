package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj2.command.InstantCommand;

public class DrivetrainHighGearCommand extends InstantCommand {
    private final Drivetrain drivetrain;

    public DrivetrainHighGearCommand(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
    }

    public void initialize() {
        drivetrain.setHighGear();
    }

}
