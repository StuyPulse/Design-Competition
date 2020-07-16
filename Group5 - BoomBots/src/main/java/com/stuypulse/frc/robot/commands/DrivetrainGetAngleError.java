package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.Constants;
import com.stuypulse.stuylib.network.limelight.Limelight;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DrivetrainGetAngleError extends CommandBase {

    public double getAngleError() {
        if(Limelight.hasValidTarget()) {
            return (com.stuypulse.frc.robot.util.Limelight.getTargetXAngle() + Constants.Measurements.YAW);
        } else {
            return 0;
        }
    }
}