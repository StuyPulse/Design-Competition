package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.Constants.DrivetrainMovement;
import com.stuypulse.frc.robot.subsystems.Drivetrain;
import com.stuypulse.stuylib.control.Controller;
import com.stuypulse.stuylib.control.PIDController;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DrivetrainMovementCommand extends CommandBase {
    private Drivetrain drivetrain;
    private double targetDistance;
    private Controller controller = new PIDController(DrivetrainMovement.P, DrivetrainMovement.I, DrivetrainMovement.D);

    public DrivetrainMovementCommand(Drivetrain drivetrain, double targetDistance) {
        this.drivetrain = drivetrain;
        this.targetDistance = targetDistance;
    }

    public void initialize() {
        targetDistance = targetDistance + drivetrain.getDistance();
    }

    public void execute() {
        double error = targetDistance - drivetrain.getDistance();
        drivetrain.arcadeDrive(controller.update(error), 0);
    }

    public boolean isFinished() {
        // Controller.isDone()
        return controller.isDone(DrivetrainMovement.MOVEMENT_ERROR);
    }
}

