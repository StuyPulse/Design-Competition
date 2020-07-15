package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.Constants.DrivetrainTurn;
import com.stuypulse.frc.robot.subsystems.Drivetrain;
import com.stuypulse.stuylib.control.Controller;
import com.stuypulse.stuylib.control.PIDController;
import com.stuypulse.stuylib.math.Angle;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DrivetrainTurnCommand extends CommandBase {
    private Drivetrain drivetrain;
    private Angle targetAngle;
    private Controller controller = new PIDController(DrivetrainTurn.P, DrivetrainTurn.I, DrivetrainTurn.D);

    public DrivetrainTurnCommand(Drivetrain drivetrain, Angle targetAngle) {
        this.drivetrain = drivetrain;
        this.targetAngle = targetAngle;
    }

    public void initialize() {
        targetAngle = targetAngle.add(drivetrain.getGyroAngle());
    }

    public void execute() {
        double error = targetAngle.sub(drivetrain.getGyroAngle()).toDegrees();
        drivetrain.arcadeDrive(0, controller.update(error));
    }

    public boolean isFinished() {
        return (controller.isDone(DrivetrainTurn.TURNING_ERROR));
    }
}

