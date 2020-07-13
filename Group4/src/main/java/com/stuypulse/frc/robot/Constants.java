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

    int DRIVER_PORT = -1;
    int OPERATOR_PORT = -1;

    // SHOOTER VALUES
    double INITATION_LINE_RPM = 0;
    double TRENCH_RPM= 0;
    double FAR_RPM = 0;

    double REVERSE_VALUE = -1;
    double FORWARD_VALUE = 1;

    // DRIVETRAIN VALUES
    double INITATION_LINE_DISTANCE = 0;
    double TRENCH_DISTANCE = 0;

    // CONTROLL PANEL ROTATION
    double CONTROL_PANEL_ROTATIONZ = 1000000;

    // "There are no facts, only interpretations."

    public interface kDrivetrain {

        interface Ports {
            int LEFT_FRONT = -1;
            int LEFT_BACK = -1;
            int RIGHT_FRONT = -1;
            int RIGHT_BACK = -1;

            int SOLENOID_A = -1;
            int SOLENOID_B = -1;

            int LEFT_MID = -1;
            int RIGHT_MID = -1;
        }

        interface Gears {
            // these thresholds are feet per second
            // there is no one threshhold to prevent flickering
            double HIGH_GEAR_THRESHOLD = 4.0;
            double LOW_GEAR_THRESHOLD = 3.0;

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

        interface AlignCommand {
            double SPEED_P = 1;
            double SPEED_I = 1;
            double SPEED_D = 1;

            double SPEED_PID_FILTER = 1;

            double ANGLE_P = 1;
            double ANGLE_I = 1;
            double ANGLE_D = 1;

            double ANGLE_PID_FILTER = 1;

            double SPEED_MAX_VELOCITY = 1;
            double SPEED_MAX_ERROR = 1;

            double ANGLE_MAX_VELOCITY = 1;
            double ANGLE_MAX_ERROR = 1;
        }

        interface GoalCommand {
            double GOAL_HEIGHT = 10;
            double MIN_ERROR = 5;
        }
    }

    public interface kIntake {
        interface Ports {
            int SOLENOID_A = 1;
            int SOLENOID_B = 1;

            int MOTOR_A = 1;
        }

        double INTAKE_SPEED = 1;
    }

    public interface kShooter {
        interface Ports {
            int MOTOR_A = 1;
            int MOTOR_B = 1;
            int MOTOR_C = 1;

            int FEEDER_MOTOR = 1;
        }

        interface TuneCommand {
            double SHOOTER_P = 1;
            double SHOOTER_I = 1;
            double SHOOTER_D = 1;

            double FEEDER_P = 1;
            double FEEDER_I = 1;
            double FEEDER_D = 1;
        }
    }

    public interface kControlPanel {
        interface Ports {
            int MOTOR_A = 1;
        }

        double SPIN_SPEED = 1;
        double NEO_FACTOR_TO_ROTATIONS = 1;

        interface ControlCommand {
            double MIN_FORCE = 0.1;
        }

        interface RotateCommand {
            double ROT_P = 1;
            double ROT_I = 1;
            double ROT_D = 1;

            double ROT_MAX_VELOCITY = 1;
            double ROT_MAX_ERROR = 1;
        }

    }

    public interface kLEDController {
        int CHANNEL = -1;
        /*
         * 2.003ms = full "forward" 1.550ms = the "high end" of the deadband range
         * 1.500ms = center of the deadband range (off) 1.460ms = the "low end" of the
         * deadband range 0.999ms = full "reverse"
         *
         */

        double BLACK = 0.99;
        double WHITE = 0.93;
    }

    public interface kClimber {
        interface Ports {
            int MOTOR_A = -1;
            int MOTOR_B = -1;
        }

        double UP_SPEED = 1;
        double DOWN_SPEED = -1;
    }

}
