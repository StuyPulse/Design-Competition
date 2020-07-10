package com.stuypulse.frc.robot.commands;
import com.stuypulse.frc.robot.subsystems.Drivetrain;

import com.stuypulse.stuylib.math.*;
import com.stuypulse.stuylib.network.limelight.Limelight;

public class DrivetrainGoalCommand extends DrivetrainAlignCommand {

    public DrivetrainGoalCommand(Drivetrain swag) {
        super(swag);
    }

    public Angle getAngleError() {
        if(!Limelight.hasValidTarget()) {
            return Angle.fromDegrees(0);
        }

        return Angle.fromDegrees(0);
    }

    public double getSpeedError() {
        if (!Limelight.hasValidTarget()) {
            return 0.0;
        }

        return 0.0;
    }

}
