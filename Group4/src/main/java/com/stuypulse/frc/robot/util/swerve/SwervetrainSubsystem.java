package com.stuypulse.frc.robot.util.swerve;

import com.stuypulse.stuylib.math.Vector2D;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * A swervable drivetrain intended for four modules in each corner.
 */
public abstract class SwervetrainSubsystem extends SubsystemBase {

    /**
     * <p>
     * Internal vector representing the dimensions of the robot.
     * </p>
     * 
     * Should be wheelbase, trackwidth
     */
    private final Vector2D mSize;

    private final SwerveModuleSubsystem mLeftFront;
    private final SwerveModuleSubsystem mRightFront;
    private final SwerveModuleSubsystem mLeftBack;
    private final SwerveModuleSubsystem mRightBack;

    /**
     * Creaate a swervetrain subsystem with 4 swerve modules.
     * 
     * @param dimensions vector representing the space of the robot ( wheelbase, trackwidth )
     * @param leftFront front left swerveable module
     * @param rightFront front right swerveable module
     * @param leftBack back left swerveable module
     * @param rightBack back right swerveable module
     */
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
     * @param rotation angular speed [ -1, ]
     */
    public final void swerveDrive(Vector2D velocity, double rotation) {
        // the first step is to calculate the desired direction, velocity
        // vector for each wheel of the

        if (isFieldCentric()) {
            // field centric rotations ??
            velocity = velocity.rotate(getAngle());
        }

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

    /**
     * @param cartesian vector in cartesian
     * @return vector in polar coordinate space
     */
    private final static Vector2D convertToPolar(Vector2D cartesian) {
        // angles range from -180 to 180 degrees clockwise (0 is straight ahead)
        return new Vector2D(cartesian.magnitude(), Math.atan2(cartesian.y, cartesian.x) * 180 / Math.PI);
    }

    /**
     * Varargs max function.
     * 
     * @param a first double
     * @param b list of doubles
     * @return maximum entry
     */
    private static double max(double a, double... b) {
        double out = a;

        for (int i = 0; i < b.length;++i) {
            if (b[i] > a) {
                out = b[i];
            }
        }

        return out;
    }

    /**
     * <p>
     * Returns the angle of the swervetrain in order to do field centric rotation.
     * Field centric maintains that the robot will go in the same direction despite its rotation.
     * </p>
     * 
     * Usually from a gyroscope reading.
     * 
     * @return angle of the drivetrain
     */
    public abstract Angle getAngle();

    /**
     * A method to determined whether the swerve train should use field centric rotations.
     * 
     * @return whether or not to use field centric rotations
     */
    public abstract boolean isFieldCentric();

}
