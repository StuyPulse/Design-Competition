package com.stuypulse.frc.robot.commands;
import static com.stuypulse.frc.robot.Constants.kDrivetrain.GoalCommand.*;
import com.stuypulse.frc.robot.subsystems.Drivetrain;

import com.stuypulse.stuylib.math.*;
import com.stuypulse.stuylib.network.limelight.Limelight;

/**
 * Drivetrain command to align with the goal.
 */
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
        double distance = GOAL_HEIGHT / ty.tan();

        if (distance < MIN_DISTANCE || distance > MAX_DISTANCE) {
            return 0.0;
        }

        return distance;
    }

}
