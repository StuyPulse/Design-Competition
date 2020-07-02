package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.Constants.Ports.Drivetrain;
import com.stuypulse.stuylib.input.Gamepad;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DrivetrainTankDriveCommand extends CommandBase {
    
    private Drivetrain drivetrain;
    private Gamepad gamepad;

    public DrivetrainTankDriveCommand(Drivetrain drivetrain, Gamepad gamepad) {
        this.drivetrain = drivetrain;
        this.gamepad = gamepad;
        addRequirements(this.drivetrain);
    }

    public void execute() {
        drivetrain.tankDrive(gamepad.getLeftY(), gamepad.getRightY());
    }
}