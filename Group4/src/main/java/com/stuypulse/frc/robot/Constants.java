/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.stuypulse.frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public interface Constants {

    int GAMEPAD_PORT = -1;

    // NOTE: our plan was to use `k` as a symbol that represented subsystem so that each interface nested from Constants
    // can be imported with all of its relevant constants and nested interfaces without getting info for other subsystems and commands

    public interface kDrivetrain {
        double INTERNAL_FILTER = 1;

        interface Ports {
            int LEFT_FRONT = -1;
            int LEFT_BACK = -1;
            int RIGHT_FRONT = -1;
            int RIGHT_BACK = -1;

            int SOLENOID_A = -1;
            int SOLENOID_B = -1;
        }

        interface Gears {
            // these thresholds are feet per second
            // there is no one threshhold to prevent flickering
            double HIGH_GEAR_THRESHOLD = 4.0;
            double LOW_GEAR_THRESHOLD  = 3.0;

            double ROC_FILTER = 1;
        }

        interface Encoders {
            double NEO_YIELD = 1;
            double NEO_LEFT_YIELD = 1;
            double NEO_RIGHT_YIELD = 1;

            double NEO_FACTOR_TO_FEET = 1; // some value of the circumfrence of the wheel
        }

        interface DriveCommand {
            double ANGLE_FILTER = 1;
            double SPEED_FILTER = 1;
        }
    }

}
