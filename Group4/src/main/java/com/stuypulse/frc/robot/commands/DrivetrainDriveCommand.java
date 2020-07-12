package com.stuypulse.frc.robot.commands;

import static com.stuypulse.frc.robot.Constants.kDrivetrain.DriveCommand.*;
import static com.stuypulse.frc.robot.Constants.kDrivetrain.Gears.*;
import com.stuypulse.frc.robot.subsystems.Drivetrain;
import com.stuypulse.frc.robot.util.FilteredVStream;
import com.stuypulse.frc.robot.util.GearController;
import com.stuypulse.frc.robot.util.GearSwitch;
import com.stuypulse.frc.robot.util.VStream;
import com.stuypulse.frc.robot.util.GearController.Gear;
import com.stuypulse.stuylib.input.Gamepad;
import com.stuypulse.stuylib.math.Vector2D;
import com.stuypulse.stuylib.streams.filters.LowPassFilter;

/**
 * Controls the drivetrain with the gamepad with filtering.
 */
public final class DrivetrainDriveCommand extends DrivetrainCommand {

    /**
     * Gamepad.
     */
    private Gamepad gamepad;

    /**
     * Vector input stream (it is possible to implement filtering here with FilteredVStream).
     */
    private VStream inputStream;

    /**
     * Internal gear controller.
     */
    private GearController gearController;

    /**
     * Create drivetrain drive command.
     *
     * @param drivetrain drivetrain to control
     * @param gamepad gamepad
     */
    public DrivetrainDriveCommand(Drivetrain drivetrain, Gamepad gamepad) {
        super(drivetrain);
        this.gamepad = gamepad;

        gearController = new GearSwitch(
            drivetrain,
            LOW_GEAR_THRESHOLD,
            HIGH_GEAR_THRESHOLD,
            new LowPassFilter(ROC_FILTER)
        );

        inputStream = new FilteredVStream(

            () -> gamepad.getLeftStick(),

            new LowPassFilter(SPEED_FILTER),

            new LowPassFilter(ANGLE_FILTER)

        );
    }

    @Override
    public Vector2D getDirection() {
        return inputStream.get();
    }

    @Override
    public Gear getGear() {
        return gearController.getGear();
    }

}
