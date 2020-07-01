package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Drivetrain;
import com.stuypulse.stuylib.math.Vector2D;

import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * <p>
 * This is the base class for drivetrain commands.
 * </p>
 *
 * Based off of Edwin with simplifications so it easier to explain. All of these
 * also make heavy use of SL Math functions.
 */
public abstract class DrivetrainCommand extends CommandBase {

    /**
     * Internal instance of the drivetrain that subclasses will use.
     */
    protected Drivetrain drivetrain;

    /**
     * Construct a drivetrain command with a drivetrain.
     *
     * @param drivetrain drivetrain to work
     */
    public DrivetrainCommand(Drivetrain drivetrain) {

        // `this` reference is to the current object, not the class, but to any object
        // made from new Drivetrain(...)
        this.drivetrain = drivetrain;

        // Add the drivetrain to the requirements to prevent collisions / errors in the
        // CommandScheduler.
        addRequirements(drivetrain);

    }

    /**
     * Returns the desired direction of the robot.
     *
     * @return vector representing the direction of the robot.
     */
    public abstract Vector2D getDirection();

    /**
     * This is the execute method of the command, which is run by the
     * CommandScheduler.
     *
     * The drivetrain is always active throughout a match (or it's getting it's
     * input from a controller, which may not moving it)
     *
     * This execute method uses the getDirection() methods in order to arcade drive
     * the robot.
     */
    @Override
    public void execute() {
        drivetrain.arcadeDrive(getDirection());
    }

}
