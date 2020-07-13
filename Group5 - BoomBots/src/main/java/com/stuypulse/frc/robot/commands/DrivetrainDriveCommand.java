package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Drivetrain;
import com.stuypulse.stuylib.input.Gamepad;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DrivetrainDriveCommand extends CommandBase {
    private Drivetrain drivetrain;
    private Gamepad operator;

    public DrivetrainDriveCommand(Drivetrain drivetrain, Gamepad operator) {
        this.drivetrain = drivetrain;
        this.operator = operator;
        addRequirements(drivetrain);
    }

    public void execute() {
        drivetrain.tankDrive(operator.getLeftY(), operator.getLeftX());
    }

    public void end() {
        drivetrain.stop();
    }
    
}