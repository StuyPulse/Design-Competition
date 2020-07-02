package com.stuypulse.frc.robot.util.swerve;

import com.stuypulse.stuylib.control.Controller;
import com.stuypulse.stuylib.math.Angle;
import com.stuypulse.stuylib.math.Vector2D;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public abstract class SwerveModuleSubsystem extends SubsystemBase {

    private final Controller mAngle;

    // the angle class is to inconvenient here

    private double mTargetDegrees; // -180 to 180

    public SwerveModuleSubsystem(Controller angleController) {
        mAngle = angleController;
        mTargetDegrees = 0.0;
    }

    private void setTargetAngle(double target) {
        mTargetDegrees = target;
    }

    private double getTargetAngle() {
        return mTargetDegrees;
    }

    private double getErrorAngle() {
        double err = getTargetAngle() - getAngle().toDegrees();

        // add mitigation algorithm here ??

        if (Math.abs(err) > 180)
            err -= Math.signum(err) * 360;

        return mAngle.update(err);
    }

    // private Vector2D getDirection() {
        // return new Vector2D(getSpeed(), getErrorAngle());
    // }

    public final void set(Vector2D direction) {
        setTargetAngle(direction.y);

        direction = new Vector2D(direction.x, getErrorAngle());

        setMotors(direction);
    }

    /**
     * Returns the angle that the swerve module is facing.
     *
     * @return angle
     */
    public abstract Angle getAngle();

    /**
     * Returns the speed that the swerve module's drive motor is moving
     *
     * @return [-1, 1]
     */
    public abstract double getSpeed();

    /**
     * Interact with the motors.
     *
     * @param direction a vector of (drive [-1,1] and angle [-1, 1])
     */
    public abstract void setMotors(Vector2D direction);

}
