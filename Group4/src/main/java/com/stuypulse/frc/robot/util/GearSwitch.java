package com.stuypulse.frc.robot.util;

import com.stuypulse.stuylib.streams.filters.IFilter;
import com.stuypulse.stuylib.util.StopWatch;

import com.stuypulse.frc.robot.subsystems.Drivetrain;

/**
 * Basic implementation of a gear switching algorithm.
 */
public class GearSwitch extends GearController {

    // use onderivative ???

    /**
     * Threshold required to go above to go into high gear.
     */
    private final double high;

    /**
     * Threshold required to go below to go into low gear.
     */
    private final double low;

    /**
     * Filter for updating distance to remove noise.
     */
    private final IFilter rocFilter;

    /**
     * Stores the last distance (necessary for tracking the rate of change)
     */
    private double lastDistance;

    /**
     * Stores the rate of change in distance.
     */
    private double roc;

    /**
     * Internal stopwatch.
     */
    private final StopWatch stopwatch;

    /**
     * Create an auto gear switcher.
     *
     * @param drivetrain    drivetrain
     * @param lowThreshold  low gear threshold in FEET/SECONDS
     * @param highThreshold high gear threshold in FEET/SECONDS
     * @param rateOfChange  noise filtering for the rate of change
     */
    public GearSwitch(Drivetrain drivetrain, double lowThreshold, double highThreshold, IFilter rateOfChange) {
        super(drivetrain);

        low = lowThreshold;
        high = highThreshold;

        rocFilter = rateOfChange;

        lastDistance = 0.0;
        roc = 0.0;

        stopwatch = new StopWatch();
    }

    /**
     * Checks if the rate of change crosses a threshold and returns the new gear.
     *
     * @param newDistance the updated distance
     * @return new state of the gear
     */
    @Override
    public Gear getGear() {
        // filter distance first... ?
        double filteredDistance = rocFilter.get(drivetrain.getDistance());

        double dt = stopwatch.reset();
        double dx = filteredDistance - lastDistance;

        Gear currentGear = drivetrain.getGear();

        roc = Math.abs(dx / dt);

        lastDistance = filteredDistance;

        if (roc <= low) {
            return Gear.LOW;
        }

        else if (roc >= high) {
            return Gear.HIGH;
        }

        return currentGear;
    }

}
