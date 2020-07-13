package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj2.command.InstantCommand;

public class DrivetrainManualTurnCommand extends InstantCommand {
    
    private Drivetrain drivetrain;
    private double angle;
    
    public DrivetrainManualTurnCommand(Drivetrain drivetrain, double angle) {
        this.drivetrain = drivetrain;
        this.angle = angle;
        addRequirements(drivetrain);
    }

    public void execute() {
        drivetrain.turn(angle);
    }

}