package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Drivetrain;
import com.stuypulse.frc.robot.subsystems.Drivetrain.Gear;

import edu.wpi.first.wpilibj2.command.InstantCommand;

public class DrivetrainSetLowGearCommand extends InstantCommand {
    
    private Drivetrain drivetrain;

    public DrivetrainSetLowGearCommand(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        drivetrain.setGear(Gear.LOW);
    }

}