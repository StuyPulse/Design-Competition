package com.stuypulse.frc.robot.util;

import com.stuypulse.frc.robot.subsystems.Drivetrain;

/**
 * Empty gear controller.
 */
public class NoGear extends GearController {

    /**
     * Create a no gear controller.
     *
     * @param drivetrain drivetrain to use
     */
    public NoGear(Drivetrain drivetrain) {
        super(drivetrain);
    }

    /**
     * @return the gear of the drivetrain (no shifting)
     */
    @Override
    public Gear update(double newDistance) {
        return getGear();
    }

}
