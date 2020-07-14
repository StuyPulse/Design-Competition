package com.stuypulse.frc.robot.commands;

import static com.stuypulse.frc.robot.Constants.kDrivetrain.DriveCommand.*;
import static com.stuypulse.frc.robot.Constants.kDrivetrain.Gears.*;
import com.stuypulse.frc.robot.subsystems.Drivetrain;

import com.stuypulse.stuylib.streams.*;
import com.stuypulse.stuylib.streams.filters.*;

import com.stuypulse.frc.robot.util.GearController;
import com.stuypulse.frc.robot.util.GearSwitch;
import com.stuypulse.frc.robot.util.GearController.Gear;
import com.stuypulse.stuylib.input.Gamepad;

/**
 * Controls the drivetrain with the gamepad with filtering.
 */
public final class DrivetrainDriveCommand extends DrivetrainCommand {

    /**
     * Gamepad.
     */
    private Gamepad gamepad;

    /**
     * Angle and speed filters.
     */
    private IStream angleFilter, speedFilter;

    /**
     * Internal gear controller.
     */
    private GearController gearController;

    /**
     * Create drivetrain drive command.
     *
     * @param drivetrain drivetrain to control
     * @param gamepad    gamepad
     */
    public DrivetrainDriveCommand(Drivetrain drivetrain, Gamepad gamepad) {
        super(drivetrain);
        this.gamepad = gamepad;

        gearController = new GearSwitch(drivetrain, LOW_GEAR_THRESHOLD, HIGH_GEAR_THRESHOLD,
                new LowPassFilter(ROC_FILTER));

        speedFilter = new FilteredIStream(

            () -> gamepad.getLeftStick().y,

            new LowPassFilter(SPEED_FILTER)

        );

        angleFilter = new FilteredIStream(

            () -> gamepad.getLeftStick().x,

            new LowPassFilter(ANGLE_FILTER)

        );
    }

    public double getSpeed() {
        return speedFilter.get();
    }

    public double getAngle() {
        return angleFilter.get();
    }

    @Override
    public Gear getGear() {
        return gearController.getGear();
    }

}
