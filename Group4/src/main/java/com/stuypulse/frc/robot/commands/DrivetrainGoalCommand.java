package com.stuypulse.frc.robot.commands;

import static com.stuypulse.frc.robot.Constants.kDrivetrain.GoalCommand.*;
import com.stuypulse.frc.robot.subsystems.Drivetrain;

import com.stuypulse.stuylib.math.*;
import com.stuypulse.stuylib.network.limelight.Limelight;

/**
 * Drivetrain command to align with the goal from a certain distance offset. For
 * example, if the offset were zero, it would go as close as possible. If the
 * offset were something like the distance from the trench to the goal, it would
 * settle at the trench.
 */
public class DrivetrainGoalCommand extends DrivetrainAlignCommand {

    // TODO: fix returning zero on target not foudn

    private final double offset;

    public DrivetrainGoalCommand(Drivetrain swag, double distanceOffset) {
        super(swag);

        offset = distanceOffset;
    }

    @Override
    public void initialize() {
        super.initialize();

        Limelight.setLEDMode(Limelight.LEDMode.FORCE_ON);
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

    public void end(boolean i ) {
        super.end(i);

        Limelight.setLEDMode(Limelight.LEDMode.FORCE_OFF);
    }

}
