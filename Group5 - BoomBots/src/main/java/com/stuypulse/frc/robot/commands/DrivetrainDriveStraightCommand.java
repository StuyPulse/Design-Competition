package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DrivetrainDriveStraightCommand extends CommandBase {

    private Drivetrain drivetrain;
    private double distance;

    public DrivetrainDriveStraightCommand(Drivetrain drivetrain, double distance) {
        this.drivetrain = drivetrain;
        this.distance = distance;
        addRequirements(drivetrain);
    }

    public void execute() {
        while (Math.min(drivetrain.getLeftEncoderDistance(), drivetrain.getRightEncoderDistance()) < distance) {
            drivetrain.drive();
        }
    }

    public void end() {
        drivetrain.stop();
    }

}