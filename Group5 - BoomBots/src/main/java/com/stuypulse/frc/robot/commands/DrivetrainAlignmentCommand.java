package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.Constants;
import com.stuypulse.frc.robot.subsystems.Drivetrain;
import com.stuypulse.stuylib.control.Controller;
import com.stuypulse.stuylib.control.PIDController;
import com.stuypulse.stuylib.math.Angle;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DrivetrainAlignmentCommand extends CommandBase {

    private double currentAngle;
    private double targetAngle;
    private Drivetrain drivetrain;
    private Controller pidcontroller = new PIDController(Constants.Drivetrain.DRIVETRAIN_TURN_P, Constants.Drivetrain.DRIVETRAIN_TURN_I, Constants.Drivetrain.DRIVETRAIN_TURN_D);

    public DrivetrainAlignmentCommand(Drivetrain drivetrain, double targetAngle) {
        this.drivetrain = drivetrain;
        this.targetAngle = targetAngle;
        this.currentAngle = drivetrain.getGyroAngle().toDegrees();
        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        targetAngle = targetAngle + currentAngle;
    }

    @Override
    public void execute() {
        drivetrain.arcadeDrive(0, pidcontroller.update(currentAngle, targetAngle));
    }

    @Override
    public boolean isFinished() {
        return pidcontroller.isDone(Constants.Drivetrain.DRIVETRAIN_TURNING_ERROR_TOLERANCE);
    }

}