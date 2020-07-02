package com.stuypulse.frc.robot.util.swerve;

import com.stuypulse.stuylib.control.Controller;
import com.stuypulse.stuylib.math.Angle;
import com.stuypulse.stuylib.math.Vector2D;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * <p>
 * This is an abstract implementation for a Swerve Module. 
 * Its pivot rotation can be tuned with a controller.
 * </p>
 *  
 * Only methods relevant to the state of the module (angle, etc.) and 
 * interacting with the motors (pivot and drive) need to be defined
 */
public abstract class SwerveModuleSubsystem extends SubsystemBase {

    /**
     * Internal angle controller.
     */
    private final Controller mAngle;

    /**
     * Internal target degrees for getting angle error.
     */
    private double mTargetDegrees; // -180 to 180

    /**
     * A swerve module should have PID tuning for its module.
     * 
     * @param angleController controller for pivot
     */
    public SwerveModuleSubsystem(Controller angleController) {
        mAngle = angleController;
        mTargetDegrees = 0.0;
    }

    /**
     * @param target degrees [-180, 180]
     */
    private void setTargetAngle(double target) {
        mTargetDegrees = target;
    }

    /**
     * @return mTargetDegrees [-180, 180]
     */
    private double getTargetAngle() {
        return mTargetDegrees;
    }

    /**
     * <p>
     * Gets the error of the swerve module to its target angle.
     * </p>
     * 
     * Mitigation and direction flipping may occur here.
     * 
     * @return the angle error [-180, 180]
     */
    private double getErrorAngle() {
        double err = getTargetAngle() - getAngle().toDegrees();

        // add mitigation algorithm here ??
        // mitigation would require abstract methods for speed motor
        // and would multiply into the speed value

        if (Math.abs(err) > 180) {
            err -= Math.signum(err) * 360;
        }

        return mAngle.update(err);
    }


    /**
     * <p>
     * This method is given a vector in polar coordinate space 
     * and handles the conversion into [-1,1]
     * </p>
     * 
     * Usually the x component of this vector will already be normalized.
     * 
     * @param direction
     */
    public final void set(Vector2D direction) {
        setTargetAngle(direction.y);
        direction = new Vector2D(direction.x, getErrorAngle());

        setMotors(direction);
    }

    /**
     * Returns the angle that the swerve module is facing.
     *
     * @return angle of the module
     */
    public abstract Angle getAngle();

    /**
     * Interact with the motors.
     *
     * @param direction a vector of (drive [-1,1] and angle [-1, 1])
     */
    public abstract void setMotors(Vector2D direction);

}
