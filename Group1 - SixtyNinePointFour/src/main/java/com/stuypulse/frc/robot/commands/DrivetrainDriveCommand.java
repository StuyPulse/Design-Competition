package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Drivetrain;
import com.stuypulse.stuylib.input.Gamepad;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DrivetrainDriveCommand extends CommandBase {
    private Drivetrain drivetrain;
    private Gamepad gamepad;

    public DrivetrainDriveCommand(Drivetrain drivetrain, Gamepad gamepad) {
        this.drivetrain = drivetrain;
        this.gamepad = gamepad;
        addRequirements(drivetrain);
    }

    public void execute() {
        drivetrain.arcadeDrive(gamepad.getLeftY(), gamepad.getLeftX());
    }
}