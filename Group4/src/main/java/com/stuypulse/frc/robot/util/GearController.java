package com.stuypulse.frc.robot.util;

import com.stuypulse.frc.robot.subsystems.Drivetrain;

/**
 * Abstract class for implementations of gear shifting algorithms.
 */
public abstract class GearController {

    /**
     * Enumeration for gear states.
     */
    public enum Gear {
        LOW, HIGH
    };

    /**
     * Internal reference to the drivetrain.
     */
    protected final Drivetrain drivetrain;

    /**
     * Create a gear controller for a drivetrain.
     *
     * @param drivetrain drivetrain
     */
    public GearController(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
    }

    /**
     * This is where the algorithm would be implemented and a gear would be returned
     *
     * @return gear of the drivetrain
     */
    public abstract Gear getGear();

}
