package com.stuypulse.frc.robot.util.swerve;

import com.stuypulse.stuylib.math.Vector2D;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwervetrainSubsystem extends SubsystemBase {

    // wheelbase (l), trackwidth (w)
    private final Vector2D mSize;

    private final SwerveModuleSubsystem mLeftFront;
    private final SwerveModuleSubsystem mRightFront;
    private final SwerveModuleSubsystem mLeftBack;
    private final SwerveModuleSubsystem mRightBack;

    public SwervetrainSubsystem(Vector2D dimensions, SwerveModuleSubsystem leftFront, SwerveModuleSubsystem rightFront, SwerveModuleSubsystem leftBack, SwerveModuleSubsystem rightBack) {
        mSize = dimensions;

        mLeftFront = leftFront;
        mLeftBack = leftBack;

        mRightFront = rightFront;
        mRightBack = rightBack;
    }

    /**
     * Move a swervetrain based on a standard 4 motor algorithm.
     *
     * @param velocity vector describing the velocity of the robot
     * @param rotation angular speed (?? fix unit but it should be [-1,1])
     */
    public final void swerveDrive(Vector2D velocity, double rotation) {
        // the first step is to calculate the desired direction, velocity
        // vector for each wheel of the

        Vector2D angular = new Vector2D(rotation * mSize.y / 2, rotation * mSize.x / 2);

        Vector2D rFront = velocity.add(angular);
        Vector2D lBack = velocity.sub(angular);

        Vector2D lFront = new Vector2D(lBack.x, rFront.y);
        Vector2D rBack = new Vector2D(rFront.x, lBack.y);

        // now that we have the direction for each of the wheels
        // we have to convert it to polar coordinates

        lFront = convertToPolar(lFront);
        rFront = convertToPolar(rFront);

        lBack = convertToPolar(lBack);
        rBack = convertToPolar(rBack);

        // post normalization for speed
        double maxSpeed = max(lFront.x, rFront.x, lBack.x, rBack.x);

        if (maxSpeed > 1) {
            Vector2D divisor = new Vector2D(maxSpeed, 1);

            lFront = lFront.div(divisor);
            rFront = rFront.div(divisor);

            lBack = lBack.div(divisor);
            rBack = rBack.div(divisor);
        }

        mLeftFront.set(lFront);
        mRightFront.set(rFront);

        mLeftBack.set(lBack);
        mRightBack.set(rBack);

    }

    private final static Vector2D convertToPolar(Vector2D cartesian) {
        // angles range from -180 to 180 degrees clockwise (0 is straight ahead)
        return new Vector2D(cartesian.magnitude(), Math.atan2(cartesian.y, cartesian.x) * 180 / Math.PI);
    }

    public static double max(double a, double... b) {
        double out = a;

        for (int i = 0; i < b.length;++i) {
            if (b[i] > a) {
                out = b[i];
            }
        }

        return out;
    }

}
