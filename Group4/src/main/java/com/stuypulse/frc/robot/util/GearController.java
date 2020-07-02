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
    private final Drivetrain drivetrain;

    /**
     * Create a gear controller for a drivetrain.
     *
     * @param drivetrain drivetrain
     */
    public GearController(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
    }

    /**
     * Protect the drivetrain from child implementations because only the gear is
     * really important.
     *
     * @return returns the gear of the drivetrain.
     */
    protected final Gear getGear() {
        return drivetrain.getGear();
    }

    /**
     * This is where the algorithm would be implemented and a gear would be returned
     *
     * @param distance accumulated distance of a drivetrain
     * @return gear of the drivetrain
     */
    public abstract Gear update(double distance);

}
