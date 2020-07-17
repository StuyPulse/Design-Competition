package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.Constants;
import com.stuypulse.stuylib.network.limelight.Limelight;
import com.stuypulse.stuylib.network.limelight.Limelight.LEDMode;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DrivetrainGetDistanceError extends CommandBase {

    private double distance;

    public DrivetrainGetDistanceError(double distance) {
        this.distance = distance;
    }

    @Override
    public void initialize() {
        Limelight.setLEDMode(LEDMode.FORCE_ON);
    }

    public double getSpeedError() {
        if(Limelight.hasValidTarget()) {
            double goal_pitch = Limelight.getTargetYAngle() + Constants.Measurements.PITCH;
            double goal_height = Constants.Measurements.GOAL_HEIGHT - Constants.Measurements.HEIGHT;
            double goal_dist = goal_height / Math.tan(Math.toRadians(goal_pitch));
        
            if(goal_dist < Constants.Measurements.MIN_DISTANCE) {
                return 0;
            } else if(goal_dist > Constants.Measurements.MAX_DISTANCE) {
                return 0;
            }

            return 0 - (goal_dist - distance);
        } else {
            return 0;
        }
    }

}   