package com.stuypulse.frc.robot.commands.autopid;

import static com.stuypulse.frc.robot.Constants.kDrivetrain.GoalCommand.*;
import com.stuypulse.frc.robot.subsystems.Drivetrain;

import com.stuypulse.stuylib.math.*;
import com.stuypulse.stuylib.network.limelight.Limelight;

/**
 * Drivetrain goal command with AutoPID
 */
public class DrivetrainAutoGoalCommand extends DrivetrainAutoCommand {

    // TODO: fix returning zero on target not foudn

    private final double offset;

    public DrivetrainAutoGoalCommand(Drivetrain swag, double distanceOffset) {
        super(swag);

        offset = distanceOffset;
    }

    public Angle getAngleError() {
        if (!Limelight.hasValidTarget()) {
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

        distance -= offset;

        // prevent drivetrain from getting too close to the goal
        // use abs to allow negative distance (after subtracting offset) to return
        // negative error
        if (Math.abs(distance) < MIN_ERROR) {
            return 0.0;
        }

        return distance;
    }

}
