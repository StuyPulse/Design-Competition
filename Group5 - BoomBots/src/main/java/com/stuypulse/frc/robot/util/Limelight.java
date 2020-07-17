package com.stuypulse.frc.robot.util;

import com.stuypulse.frc.robot.Constants;
import com.stuypulse.stuylib.network.limelight.Limelight.LEDMode;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight {

    private static NetworkTableInstance tableInstance = NetworkTableInstance.getDefault();
    private static NetworkTable table = tableInstance.getTable("limelight");

    private static NetworkTableEntry LEDModeEntry = table.getEntry("ledmode");
    private static NetworkTableEntry validTargetEntry = table.getEntry("tv");
    private static NetworkTableEntry xAngleEntry = table.getEntry("tx");
    private static NetworkTableEntry yAngleEntry = table.getEntry("ty");

    public static boolean hasAnyTarget() {
        boolean validTarget = validTargetEntry.getDouble(0) > 0.5;
        return validTarget;
    }

    public static boolean hasValidTarget(double targetHeightTolerance, double angleTolerance, double minRatio, double maxRatio) {
        return hasValidTarget(Constants.CV.DEFAULT_TARGET_HEIGHT_THRESHOLD, Constants.CV.DEFAULT_ANGLE_THRESHOLD, Constants.CV.DEFAULT_MIN_ASPECT_RATIO, Constants.CV.DEFAULT_MAX_ASPECT_RATIO);
    }

    public static double getTargetXAngle() {
        return xAngleEntry.getDouble(0);
    }

    public static double getTargetYAngle() {
        return yAngleEntry.getDouble(0);
    }

    public static void setLEDMode(LEDMode mode) {
        LEDModeEntry.setNumber(mode.getCodeValue());
    }

}