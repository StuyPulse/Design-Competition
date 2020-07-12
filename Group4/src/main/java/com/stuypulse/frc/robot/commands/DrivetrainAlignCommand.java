package com.stuypulse.frc.robot.commands;

import com.stuypulse.stuylib.streams.filters.*;

import static com.stuypulse.frc.robot.Constants.kDrivetrain.AlignCommand.*;

import com.stuypulse.frc.robot.subsystems.Drivetrain;
import com.stuypulse.frc.robot.util.GearController.Gear;
import com.stuypulse.stuylib.math.*;

import com.stuypulse.stuylib.control.*;

/**
 * Command in which rather than defining the direction of the robot, errors are
 * defined and a controller is used to get the drivetrain to that point.
 */
public abstract class DrivetrainAlignCommand extends DrivetrainCommand {

    private final Controller speedController, angleController;

    private Angle targetAngle;
    private double targetSpeed;

    public DrivetrainAlignCommand(Drivetrain drivetrain) {
        super(drivetrain);

        // create constants
        speedController = new PIDController(SPEED_P, SPEED_I, SPEED_D);
        angleController = new PIDController(ANGLE_P, ANGLE_I, ANGLE_D);

        // create constants
        speedController.setOutputFilter(new LowPassFilter(SPEED_PID_FILTER));
        angleController.setOutputFilter(new LowPassFilter(ANGLE_PID_FILTER));

        targetAngle = Angle.fromDegrees(0);
        targetSpeed = 0.0;
    }

    /**
     * <p>
     * Everytime this command is called, initialize will be run. Target angle and
     * speed are the setpoints that will be determined when the command is started
     * by taking the getError functions and adding it to the drivetrain's current
     * speed and angle.
     * </p>
     *
     * ...
     */
    @Override
    public void initialize() {
        targetAngle = drivetrain.getAngle().add(getAngleError());
        targetSpeed = drivetrain.getDistance() + getSpeedError();
    }

    public Vector2D getDirection() {
        return new Vector2D(speedController.update(targetSpeed - drivetrain.getDistance()),
                angleController.update(targetAngle.sub(drivetrain.getAngle()).toDegrees()));
    }

    public abstract double getSpeedError();

    public abstract Angle getAngleError();

    @Override
    public boolean isFinished() {
        // needs to be constants
        return speedController.isDone(ANGLE_MAX_VELOCITY, SPEED_MAX_VELOCITY)
                && angleController.isDone(ANGLE_MAX_ERROR, ANGLE_MAX_VELOCITY);
    }

    @Override
    public Gear getGear() {
        return Gear.LOW;
    }

}
