package com.stuypulse.frc.robot.commands;
import com.stuypulse.frc.robot.Constants.kDrivetrain;
import com.stuypulse.frc.robot.subsystems.Drivetrain;

import com.stuypulse.stuylib.math.*;
import com.stuypulse.stuylib.network.limelight.Limelight;

public class DrivetrainGoalCommand extends DrivetrainAlignCommand {

    public DrivetrainGoalCommand(Drivetrain swag) {
        super(swag);
    }

    public Angle getAngleError() {
        if(!Limelight.hasValidTarget()) {
            return Angle.fromDegrees(0);
        }

        return Angle.fromDegrees(Limelight.getTargetXAngle());
    }

    public double getSpeedError() {
        if (!Limelight.hasValidTarget()) {
            return 0.0;
        }

        Angle ty = Angle.fromDegrees(Limelight.getTargetYAngle());
        double distance = kDrivetrain.GoalCommand.GOAL_HEIGHT / ty.tan();

        if (distance < kDrivetrain.GoalCommand.MIN_DISTANCE || distance > kDrivetrain.GoalCommand.MAX_DISTANCE) {
            return 0.0;
        }

        return distance;
    }

}
