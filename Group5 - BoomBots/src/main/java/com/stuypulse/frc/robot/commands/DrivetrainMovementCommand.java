package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.Constants;
import com.stuypulse.frc.robot.subsystems.Drivetrain;
import com.stuypulse.stuylib.control.Controller;
import com.stuypulse.stuylib.control.PIDController;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DrivetrainMovementCommand extends CommandBase {

    private Drivetrain drivetrain;

    private double currentAngle;
    private double targetAngle;
    private double targetDistance;
    
    private Controller angleController = new PIDController(Constants.Drivetrain.DRIVETRAIN_TURN_P, Constants.Drivetrain.DRIVETRAIN_TURN_I, Constants.Drivetrain.DRIVETRAIN_TURN_D);
    private Controller distanceController = new PIDController(Constants.Drivetrain.DRIVETRAIN_DRIVE_P, Constants.Drivetrain.DRIVETRAIN_TURN_I, Constants.Drivetrain.DRIVETRAIN_TURN_D);

    public DrivetrainMovementCommand(Drivetrain drivetrain, double targetAngle, double targetDistance) {
        this.drivetrain = drivetrain;

        currentAngle = drivetrain.getGyroAngle().toDegrees();
        this.targetAngle = targetAngle;

        this.targetDistance = targetDistance;
        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        targetAngle = targetAngle + currentAngle;
    }

    @Override
    public void execute() {
        drivetrain.arcadeDrive(distanceController.update(drivetrain.getDistance(), targetDistance), angleController.update(currentAngle, targetAngle));
    }

    @Override  
    public boolean isFinished() {
        return angleController.isDone(Constants.Drivetrain.DRIVETRAIN_TURNING_ERROR_TOLERANCE) && distanceController.isDone(Constants.Drivetrain.DRIVETRAIN_DRIVE_ERROR_TOLERANCE);
    }
    
}