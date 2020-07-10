package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class DrivetrainLowGearCommand extends InstantCommand {
    private final Drivetrain drivetrain;

    public DrivetrainLowGearCommand(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
    }

    public void initialize() {
        drivetrain.setLowGear();
    }

}